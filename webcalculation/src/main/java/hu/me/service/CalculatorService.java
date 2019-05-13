package hu.me.service;

import hu.me.dto.Input;
import hu.me.entity.CalculatorEntity;
import hu.me.entity.UserEntity;
import hu.me.logic.CalculatorInterface;
import hu.me.repository.CalculatorRepository;
import hu.me.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    public void setCalculatorRepository(CalculatorRepository calculatorRepository){ this.calculatorRepository = calculatorRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public CalculatorService(CalculatorInterface calculatorInterface){ this.calculatorInterface = calculatorInterface; }

    private CalculatorRepository calculatorRepository;
    private UserRepository userRepository;
    private CalculatorInterface calculatorInterface;
    private List<String> log = new ArrayList<>();

    public Double calc(Input input, Boolean save) {
        Double result = null;
        if ("add".equals(input.getOperations())) {
            result = calculatorInterface.add(input.getNum1(), input.getNum2());
        } else if ("sub".equals(input.getOperations())) {
            result = calculatorInterface.sub(input.getNum1(), input.getNum2());
        } else if ("mult".equals(input.getOperations())) {
            result = calculatorInterface.mult(input.getNum1(), input.getNum2());
        } else if ("div".equals(input.getOperations())) {
            result = calculatorInterface.div(input.getNum1(), input.getNum2());
        }
        if (save) {
            calculatorRepository.save(new CalculatorEntity(input.getNum1(), input.getNum2(), input.getOperations(), result, input.getUserID()));
            userRepository.save(new UserEntity(input.getUserID(), input.getUserName(), input.getUserAge()));
            return result;
        } else {
            return result;
        }
    }

    public List<String> log(String s) {
        log.add(s);
        return log;
    }

    public List<String> getLog() {
        return log;
    }

    public Iterable<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public Iterable<CalculatorEntity> getCalculations() {
        return calculatorRepository.findAll();
    }

    public Iterable<CalculatorEntity> getByOperations(String operations) {
        return calculatorRepository.findByOperations(operations);
    }

    public List<String> getByOperationsFinal(String operations){
        Iterable <CalculatorEntity> calculations = getByOperations(operations);
        Iterable <UserEntity> users = getUsers();
        List<String> data = new ArrayList<>();

        for (UserEntity userEntity : users) {
            for (CalculatorEntity calculatorEntity : calculations) {
                if(userEntity.getUserID() == calculatorEntity.getUserID()){
                    data.add("UserID: " + calculatorEntity.getUserID() +
                            ", UserName: " + userEntity.getUserName() +
                            ", UserAge: " + userEntity.getUserAge() +
                            ", Calculation: " + calculatorEntity.getNum1() +
                            " " + calculatorEntity.getOperations() +
                            " " + calculatorEntity.getNum2() +
                            " = " + calculatorEntity.getResult()
                    );
                }
            }
        }
        return data;
    }

    public List<String> getUserData(int userID){
        Iterable<CalculatorEntity> calculations = calculatorRepository.findAll();
        Iterable<UserEntity> users = userRepository.findAll();
        List<String> data = new ArrayList<>();

        for (CalculatorEntity calculatorEntity : calculations) {
            for (UserEntity userEntity : users) {
                if(calculatorEntity.getUserID() == userEntity.getUserID() && userEntity.getUserID() == userID){
                    data.add("UserID: " + calculatorEntity.getUserID() +
                            ", UserName: " + userEntity.getUserName() +
                            ", UserAge: " + userEntity.getUserAge() +
                            ", Calculation: " + calculatorEntity.getNum1() +
                            " " + calculatorEntity.getOperations() +
                            " " + calculatorEntity.getNum2() +
                            " = " + calculatorEntity.getResult()
                    );
                }
            }
        }
        return data;
    }
}