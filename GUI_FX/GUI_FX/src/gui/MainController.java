package gui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML TableView<PasswordItem> passwordTable;
    @FXML TableColumn<PasswordItem, String> passwordCol;
    @FXML TableColumn<PasswordItem, String> sourceCol;

    private ObservableList<PasswordItem> tableList = FXCollections.observableList(new ArrayList<>());
    @FXML
    public void onLoadClicked(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(passwordTable.getScene().getWindow());
        if(selectedFile != null)
        {
            tableList.clear();

            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Wprowadz hasło");
            dialog.setHeaderText("Wprowadź hasło");
            dialog.setContentText("Wprowadź hasło do pliku:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent())
            {
                String password = result.get();
                FileManager fileManager = new FileManager(selectedFile);
                try {
                    boolean success = fileManager.decodeFile(password);
                    if(!success)
                    {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Niepoprawne hasło");
                        alert.show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wystąpił problem z odczytem");
                    alert.show();
                }

                try {
                    List<String> decoded = fileManager.getDecodedFileContents();
                    for (String line : decoded) {
                        PasswordItem item = new PasswordItem(line);
                        tableList.add(item);
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Plik jest uszkodzony");
                    alert.show();
                }
            }
        }
    }

    @FXML
    public void onSaveClicked(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showSaveDialog(passwordTable.getScene().getWindow());
        if(selectedFile != null)
        {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Wprowadz hasło");
            dialog.setHeaderText("Nadaj hasło pliku");
            dialog.setContentText("Wprowadź hasło do odczytu:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                String password = result.get();

                List<String> content = new ArrayList<>();
                for (PasswordItem passwordItem : getTableList()) {
                    content.add(passwordItem.getSaveFormat());
                }

                try {
                    FileManager.saveAndEncode(selectedFile, content, password);
                } catch (IOException e) {
                    e.printStackTrace();
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Wystąpił problem z zapisem");
                    alert.show();
                }
            }
        }
    }

    @FXML
    public void onAddClicked() throws IOException {
        FXMLLoader loader = new FXMLLoader(AddPassController.class.getResource("addpass.fxml"));
        Parent root = loader.load();
        AddPassController controller = loader.getController();
        controller.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Add Password");
        stage.setScene(new Scene(root));
        stage.setMinWidth(root.minWidth(-1));
        stage.setMinHeight(root.minHeight(-1));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(getStage());
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        passwordTable.setPlaceholder(new Label("Wczytaj dane z menu Plik -> Wczytaj"));
        passwordTable.setItems(tableList);
        passwordCol.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getPassword()));
        sourceCol.setCellValueFactory(cell -> new ReadOnlyObjectWrapper<>(cell.getValue().getSource()));
    }

    public ObservableList<PasswordItem> getTableList() {
        return tableList;
    }

    public Stage getStage(){
        return (Stage)passwordTable.getScene().getWindow();
    }
}
