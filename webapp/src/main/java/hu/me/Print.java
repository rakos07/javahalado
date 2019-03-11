package hu.me;

public class Print {

    public void print(UserDTO userDTO, boolean result) {
        if (result) {
            userDTO.setErrorMessage(ErrorMessage.NoError);
            System.out.println("Felhasználóneve: " + userDTO.getUsername() + " " + userDTO.getErrorMessage());
        } else {
            System.out.println(userDTO.getErrorMessage());
        }
    }
}

