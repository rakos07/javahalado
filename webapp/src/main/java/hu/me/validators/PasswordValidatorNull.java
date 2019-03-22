package hu.me.validators;

import hu.me.UserDTO;
import hu.me.Validator;
import hu.me.ErrorMessage;
import hu.me.ValidatorResponse;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidatorNull implements Validator {
    @Override
    public ValidatorResponse validate(UserDTO userDTO) {
        ValidatorResponse validatorResponse;
        if (userDTO.getPassword() == null || userDTO.getPassword().isEmpty()) {
            validatorResponse = new ValidatorResponse(false, ErrorMessage.PasswordNull);
            return validatorResponse;
        } else {
            validatorResponse = new ValidatorResponse(true, ErrorMessage.Valid);
            return validatorResponse;
        }
    }
}
