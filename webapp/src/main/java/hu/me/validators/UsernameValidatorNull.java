package hu.me.validators;

import hu.me.UserDTO;
import hu.me.Validator;
import hu.me.ErrorMessage;
import hu.me.ValidatorResponse;

public class UsernameValidatorNull implements Validator {
    @Override
    public ValidatorResponse validate(UserDTO userDTO) {
        ValidatorResponse validatorResponse;
        if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty()) {
            validatorResponse = new ValidatorResponse(false, ErrorMessage.UsernameNull);
            return validatorResponse;
        } else {
            validatorResponse = new ValidatorResponse(true, ErrorMessage.Valid);
            return validatorResponse;
        }
    }
}
