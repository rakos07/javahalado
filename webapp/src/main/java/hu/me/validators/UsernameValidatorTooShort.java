package hu.me.validators;

import hu.me.UserDTO;
import hu.me.Validator;
import hu.me.ErrorMessage;
import hu.me.ValidatorResponse;
import org.springframework.stereotype.Service;

@Service
public class UsernameValidatorTooShort implements Validator {
    @Override
    public ValidatorResponse validate(UserDTO userDTO) {
        ValidatorResponse validatorResponse;
        if (userDTO.getUsername() != null && userDTO.getUsername().length() <= 5) {
            validatorResponse = new ValidatorResponse(false, ErrorMessage.UserNameTooShort);
            return validatorResponse;
        } else {
            validatorResponse = new ValidatorResponse(true, ErrorMessage.Valid);
            return validatorResponse;
        }
    }
}
