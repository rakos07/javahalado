package hu.me;

public class PasswordValidator implements Validator<UserDTO> {
    @Override
    public boolean validate(UserDTO input) {
        if(input.getPassword().contains(" ") || input.getPassword().length() <= 5){
            return false;
        }
        return true;
    }
}
