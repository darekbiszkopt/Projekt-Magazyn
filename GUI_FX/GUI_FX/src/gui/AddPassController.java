package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;


public class AddPassController implements Initializable {
    @FXML TextField passwordTextfield;
    @FXML TextField sourceTextfield;
    @FXML Button addButton;
    @FXML Button cancelButton;
    @FXML CheckBox generateCheckbox;

    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cancelButton.setOnAction(e -> getStage().close());
        addButton.setOnAction(e -> onAddClicked());
        generateCheckbox.selectedProperty().addListener((a, b, isChecked) -> {
            if(isChecked) {
                passwordTextfield.setText(generateRandomPassword());
            }
        });
    }

    public void onAddClicked(){

        if(sourceTextfield.getText().trim().length() < 1 || passwordTextfield.getText().trim().length() < 1)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Proszę wypełnić wszystkie pola");
            alert.show();
        }
        else
        {
            mainController.getTableList().add(new PasswordItem(passwordTextfield.getText(), sourceTextfield.getText()));
            getStage().close();
        }

    }

    public Stage getStage(){
        return (Stage)passwordTextfield.getScene().getWindow();
    }


    // Function to generate random alpha-numeric password of specific length
    // https://www.techiedelight.com/generate-random-alphanumeric-password-java
    public static String generateRandomPassword()
    {
        final int len = 7;
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public void setMainController(MainController controller) {
        this.mainController = controller;
    }
}
