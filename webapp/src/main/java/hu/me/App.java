package hu.me;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        UserDTO userDTO = new UserDTO();

        UsernameSave usernameSave = new UsernameSave();
        PasswordSave passwordSave = new PasswordSave();
        Print print = new Print();
        UserNameValidator userNameValidator = new UserNameValidator();
        PasswordValidator passwordValidator = new PasswordValidator();

        List<Validator<UserDTO>> validators = new ArrayList<>();
        validators.add(userNameValidator);
        validators.add(passwordValidator);

        usernameSave.usernamesave(userDTO);
        passwordSave.passwordsave(userDTO);

        if(userDTO.getPassword().contains(" ") || userDTO.getUsername().contains(" ")){
            userDTO.setErrorMessage(ErrorMessage.CharactersCountainSpace);
        }

        if(userDTO.getPassword().length() <= 5 || userDTO.getUsername().length() <=5) {
            userDTO.setErrorMessage(ErrorMessage.TooLowCharacters);
        }

        boolean result = validators.stream().allMatch(item -> item.validate(userDTO));

        print.print(userDTO, result);


    }
}
