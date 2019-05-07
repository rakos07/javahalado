package hu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserControllerImpl implements UserController {

    private List<UserDTO> userDTOStore;
    private List<Validator> validators;
    private List<ValidatorResponse> validatorResponses;
    private List<ErrorMessage> errorResponses;

    @Autowired
    public UserControllerImpl(List<Validator> validators) {
        this.userDTOStore = new ArrayList<>();
        this.validators = validators;
    }

    @Autowired
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
            if(validators.isEmpty()) {
                userDTOStore.add(userDTO);
            }
            else userDTOStore.add(userDTO);
            return errorResponses;
        }
        else {
            return errorResponses;
        }
    }

    @Autowired
    public List<UserDTO> getUserDTOStore() {
        return userDTOStore;
    }
}

