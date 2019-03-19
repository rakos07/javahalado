package hu.me;

import java.util.ArrayList;
import java.util.List;

public class UserControllerImpl implements UserController {

    private List<UserDTO> userDTOStore;
    private List<Validator> validators;
    private List<ValidatorResponse> validatorResponses;
    private List<ErrorMessage> errorResponses;

    public UserControllerImpl(List<Validator> validators) {
        this.userDTOStore = new ArrayList<>();
        this.validators = validators;
    }

    public List<ErrorMessage> saveUser(UserDTO userDTO){
        validatorResponses = new ArrayList<>();
        errorResponses = new ArrayList<>();
        for (Validator validator : validators) {
            validatorResponses.add(validator.validate(userDTO));
        }

        boolean errors = false;

        for (ValidatorResponse validatorResponse : validatorResponses) {
            if (!validatorResponse.isValid()){
                errors = true;
                errorResponses.add(validatorResponse.getErrorMessage());
            }
        }

        if(!errors){
            userDTOStore.add(userDTO);
            return errorResponses;
        }
        else {
            return errorResponses;
        }
    }

    public List<UserDTO> getUserDTOStore() {
        return userDTOStore;
    }
}

