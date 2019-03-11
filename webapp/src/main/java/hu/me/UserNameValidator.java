package hu.me;

public class UserNameValidator implements Validator<UserDTO> {
    @Override
    public boolean validate(UserDTO input) {
        if(input.getUsername().contains(" ") || input.getUsername().length() <= 5){
            return false;
        }
        return true;
    }
}
