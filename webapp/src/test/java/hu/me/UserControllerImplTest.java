package hu.me;

import hu.me.validators.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class UserControllerImplTest {

    public UserController userController;
    public List<Validator> validators;


    @Before
    public void init() {

        validators = new ArrayList<>();
        validators.add(new UsernameValidatorNull());
        validators.add(new PasswordValidatorNull());
        validators.add(new UsernameValidatorTooShort());
        validators.add(new PasswordValidatorTooShort());
        validators.add(new UsernameValidatorNoSpace());
        validators.add(new PasswordValidatorNoSpace());
        userController = new UserControllerImpl(validators);
    }

    @Test
    public void chechValidUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("asdasd");
        userDTO.setPassword("123qwe");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setUsername("asdasd");
        userDTO2.setPassword("123qwe");
        List<UserDTO> expectedUserd = new ArrayList<>();
        expectedUserd.add(userDTO2);


        Assert.assertEquals("Save user is succesful", true, errorMessages.isEmpty());
        Assert.assertEquals("Users list must be empty",expectedUserd, users);

    }

    @Test
    public void checkNullUsername() {
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword("123qwe");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();


        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.UsernameNull);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());
    }

    @Test
    public void checkNullPassword() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("asdasd");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.PasswordNull);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());
    }

    @Test
    public void checkLengthUsername() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("12345");
        userDTO.setPassword("123qwe");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.UserNameTooShort);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());

    }

    @Test
    public void checkLengthPassword() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("123456");
        userDTO.setPassword("12345");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.PasswordTooShort);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());

    }

    @Test
    public void checkUsernameCountainsSpace() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("12345 6");
        userDTO.setPassword("123qwe");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.UsernameContainsSpace);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());

    }

    @Test
    public void checkPasswordCountainsSpace() {
        UserDTO userDTO = new UserDTO();

        userDTO.setUsername("123456");
        userDTO.setPassword("123qw e");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<UserDTO> users = userController.getUserDTOStore();

        List<ErrorMessage> expectedErrors = new ArrayList<>();
        expectedErrors.add(ErrorMessage.PasswordContainsSpace);


        Assert.assertEquals(expectedErrors, errorMessages);
        Assert.assertEquals("Users list must be empty",true, users.isEmpty());

    }

    @Test
    public void checkValidUserAddOnly(){
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("asdasd");
        userDTO.setPassword("123qwe");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setUsername("asd asd");
        userDTO2.setPassword("123 qwe");

        List<ErrorMessage> errorMessages = userController.saveUser(userDTO);
        List<ErrorMessage> errorMessages2 = userController.saveUser(userDTO2);

        List<UserDTO> users = userController.getUserDTOStore();


        List<UserDTO> expectedUsers = new ArrayList<>();
        expectedUsers.add(userDTO);


        Assert.assertEquals("Save only valid user", expectedUsers, users);
    }

}
