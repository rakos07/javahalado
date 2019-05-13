package hu.me.validator;

import hu.me.dto.Input;
import hu.me.entity.UserEntity;
import hu.me.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;

@Component
public class InputValidator implements Validator {
    private CalculatorService calculatorService;
    private List<String> operationss = new ArrayList<>();
    private String inputvalues;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @Override
    public boolean supports(Class Input){
        return hu.me.dto.Input.class.equals(Input);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "operations", "input.operations.empty");
        ValidationUtils.rejectIfEmpty(errors, "num1", "input.num1.empty");
        ValidationUtils.rejectIfEmpty(errors, "num2", "input.num2.empty");
        ValidationUtils.rejectIfEmpty(errors, "userID", "input.id.empty");
        ValidationUtils.rejectIfEmpty(errors, "userName", "input.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "userAge", "input.age.empty");

        Input input = (Input) object;

        if(input.getUserID() == 0 || ("").equals(input.getUserName())){
            errors.rejectValue("userID", "input.inputvalues.data");
            errors.rejectValue("userName", "input.inputvalues.data");
        }

        Iterable<UserEntity> lekeres = calculatorService.getUsers();

        for (UserEntity userEntity : lekeres) {
            if(input.getUserID() == userEntity.getUserID()){
                if(!(input.getUserName().equals(userEntity.getUserName()))){
                    errors.rejectValue("userID", "input.inputvalues.alreadyuse");
                } else {
                    break;
                }
            }
        }

        if (("div").equals(input.getOperations()) && input.getNum2() == 0){
            errors.rejectValue("num2", "input.divByZero");
        } else {
            operationss = calculatorService.getLog();

            inputvalues = ("{" + input.getNum1() + " " +
                                input.getOperations() + " " +
                                input.getNum2() + " = " +
                                calculatorService.calc(input, false) + " , " +
                                input.getUserID() + " , " +
                                input.getUserName() + " , " +
                                input.getUserAge() + "}");


            for (String operations : operationss) {
                System.out.println(operations);

                if( inputvalues.equals(operations)){
                    errors.rejectValue("operations", "input.operations.done");
                }
            }
        }
    }
}
