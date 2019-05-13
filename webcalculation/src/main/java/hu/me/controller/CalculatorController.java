package hu.me.controller;


import hu.me.dto.Input;
import hu.me.entity.CalculatorEntity;
import hu.me.entity.UserEntity;
import hu.me.service.CalculatorService;
import hu.me.validator.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculatorController {

    private InputValidator inputValidator;
    private CalculatorService calculatorService;

    @Autowired
    public void setInputValidator(InputValidator inputValidator){
        this.inputValidator = inputValidator;
    }

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService){ this.calculatorService = calculatorService; }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(inputValidator);
    }

    @ModelAttribute("operations")
    public List<String> operations() {
        List<String> operations = new ArrayList<>();
        operations.add("add");
        operations.add("sub");
        operations.add("mult");
        operations.add("div");
        return operations;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initialize(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("input", new Input("", 0, 0, 0, "",0));
        modelAndView.addObject("result", 0);
        modelAndView.addObject("log");
        modelAndView.addObject("userData");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView input(@Validated Input input, BindingResult bindingResult){

        System.out.println(input);
        System.out.println(bindingResult);

        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
        } else {
                modelAndView.addObject("result", calculatorService.calc(input, true));
                calculatorService.log("{" + input.getNum1() +
                        " " + input.getOperations() +
                        " " + input.getNum2() +
                        " = " + calculatorService.calc(input, false) +
                        " , " + input.getUserID() +
                        " , " + input.getUserName() +
                        " , " + input.getUserAge() +
                        "}"
                );

                modelAndView.addObject("log", calculatorService.getLog());
                modelAndView.addObject("userData", calculatorService.getUserData(input.getUserID()));
                modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/listByOperator")
    @ResponseBody
    public List<String> output(String operations){
        System.out.println(operations);
        return calculatorService.getByOperationsFinal(operations);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/log")
    @ResponseBody
    public List<String> log() {
        return calculatorService.getLog();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/logDBCalculations")
    @ResponseBody
    public Iterable<CalculatorEntity> logDBCalculations() {
        return calculatorService.getCalculations();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/logDBUsers")
    @ResponseBody
    public Iterable<UserEntity> logDBUsers() {
        return calculatorService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/listByUser")
    @ResponseBody
    public List<String> logDBUserCalculations(int userID) {
        return calculatorService.getUserData(userID);
    }
}
