package hu.me;

public class UserDTO {


    private String username;
    private String password;
    private ErrorMessage errorMessage;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    /*

    public final String username;
    public final String password;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    */
}
