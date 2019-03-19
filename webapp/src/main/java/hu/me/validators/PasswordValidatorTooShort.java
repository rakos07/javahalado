package hu.me.validators;

import hu.me.UserDTO;
import hu.me.Validator;
import hu.me.ErrorMessage;
import hu.me.ValidatorResponse;

public class PasswordValidatorTooShort implements Validator {
    @Override
    public ValidatorResponse validate(UserDTO userDTO) {
        ValidatorResponse validatorResponse;
        if (userDTO.getPassword() != null && userDTO.getPassword().length() <= 5) {
            validatorResponse = new ValidatorResponse(false, ErrorMessage.PasswordTooShort);
            return validatorResponse;
        } else {
            validatorResponse = new ValidatorResponse(true, ErrorMessage.Valid);
            return validatorResponse;
        }
    }
}
