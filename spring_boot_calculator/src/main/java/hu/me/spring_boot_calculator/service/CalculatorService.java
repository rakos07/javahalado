package hu.me.spring_boot_calculator.service;

import hu.me.spring_boot_calculator.dto.InputValues;
import hu.me.spring_boot_calculator.exceptions.DevideFirstParamException;
import hu.me.spring_boot_calculator.exceptions.DevideSecondParamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {
    Calculator calculator;
    private List logs = new ArrayList();

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public CalculatorService(Calculator calculator){this.calculator = calculator;}

    public Double calc(InputValues inputValues) throws DevideFirstParamException, DevideSecondParamException {
        Double result = null;
        if ("add".equals(inputValues.getOperation())) {
            result = calculator.add(inputValues.getNumber1(), inputValues.getNumber2());
            return result;
        }
        else if ("subtract".equals(inputValues.getOperation())) {
            result = calculator.subtract(inputValues.getNumber1(), inputValues.getNumber2());
            return result;
        }
        else if ("multiply".equals(inputValues.getOperation())) {
            result = calculator.multiply(inputValues.getNumber1(), inputValues.getNumber2());
            return result;
        }
        else if ("divide".equals(inputValues.getOperation())) {
            if (inputValues.getNumber1() == 0) throw new DevideFirstParamException();
            if (inputValues.getNumber2() == 0)  throw new DevideSecondParamException();
            result = calculator.divide(inputValues.getNumber1(), inputValues.getNumber2());
            return result;
        }
        else {
            return result;
        }
    }

    public List logs(String log) {
        logs.add(log);
        return logs;
    }

    public List getLogs() {
        return logs;
    }


}
