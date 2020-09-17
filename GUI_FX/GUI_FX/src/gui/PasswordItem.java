package gui;

public class PasswordItem {

    private String password;
    private String source;

    public PasswordItem(String password, String source) {
        this.password = password;
        this.source = source;
    }

    public PasswordItem(String line) throws Exception {
        String[] split = line.split(";");
        this.password = split[0];
        this.source = split[1];
    }

    public String getSaveFormat() {
        return password + ";" + source;
    }

    public String getPassword() {
        return password;
    }

    public String getSource() {
        return source;
    }
}
