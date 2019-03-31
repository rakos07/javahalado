package hu.me.spring_boot_calculator.controller;

import hu.me.spring_boot_calculator.dto.InputValues;
import hu.me.spring_boot_calculator.exceptions.DevideFirstParamException;
import hu.me.spring_boot_calculator.exceptions.DevideSecondParamException;
import hu.me.spring_boot_calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView init() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        mav.addObject("inputValues",new InputValues("add",0,0));
        mav.addObject("result", 0);
        mav.addObject("logs", "Empty");

        return mav;

    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView post(@Valid InputValues inputValues, BindingResult bindingResult) {

        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mav.setViewName("index");
        } else {
            try {
                mav.addObject("result", calculatorService.calc(inputValues));
            } catch (DevideFirstParamException e){
                bindingResult.addError(new FieldError("inputValues", "number1", "0 nem lehet osztandó!"));
                mav.addObject("logs", calculatorService.getLogs());
                mav.setViewName("index");
                return mav;
            } catch (DevideSecondParamException e){
                bindingResult.addError(new FieldError("inputValues", "number2", "0 nem lehet osztó!"));
                mav.addObject("logs", calculatorService.getLogs());
                mav.setViewName("index");
                return mav;
            }

            if("add".equals(inputValues.getOperation())){
                inputValues.setOperation("+");
            }
            if("subtract".equals(inputValues.getOperation())){
                inputValues.setOperation("-");
            }
            if("multiply".equals(inputValues.getOperation())){
                inputValues.setOperation("*");
            }
            if("divide".equals(inputValues.getOperation())){
                inputValues.setOperation("/");
            }


            calculatorService.logs("{" + inputValues.getNumber1() + " "
                                        + inputValues.getOperation() + " "
                                        + inputValues.getNumber2()
                    + " = " + mav.getModel().values().toString().replace("[", "").replace("]", "") + "}");
            mav.addObject("logs", calculatorService.getLogs());
            mav.setViewName("index");
        }
        return mav;

    }

    @RequestMapping(method = RequestMethod.GET, path = "/logs")
    @ResponseBody
    public List logs() {
        return calculatorService.getLogs();
    }

}
