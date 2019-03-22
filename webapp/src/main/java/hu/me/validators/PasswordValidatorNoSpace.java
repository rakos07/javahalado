package hu.me.validators;

import hu.me.UserDTO;
import hu.me.Validator;
import hu.me.ErrorMessage;
import hu.me.ValidatorResponse;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidatorNoSpace implements Validator {
    @Override
    public ValidatorResponse validate(UserDTO userDTO) {
        ValidatorResponse validatorResponse;
        if (userDTO.getPassword() != null && userDTO.getPassword().contains(" ")) {
            validatorResponse = new ValidatorResponse(false, ErrorMessage.PasswordContainsSpace);
            return validatorResponse;
        } else {
            validatorResponse = new ValidatorResponse(true, ErrorMessage.Valid);
            return validatorResponse;
        }
    }
}