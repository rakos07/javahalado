package hu.me;

import hu.me.validators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class App implements CommandLineRunner {

    UsernameValidatorNull usernameValidatorNull;
    PasswordValidatorNull passwordValidatorNull;
    UsernameValidatorTooShort usernameValidatorTooShort;
    PasswordValidatorTooShort passwordValidatorTooShort;
    UsernameValidatorNoSpace usernameValidatorNoSpace;
    PasswordValidatorNoSpace passwordValidatorNoSpace;

    UserControllerImpl userController;
    UserDTO userDTO;

    @Autowired
    public void setUsernameValidatorNull(UsernameValidatorNull usernameValidatorNull) {
        this.usernameValidatorNull = usernameValidatorNull;
    }

    @Autowired
    public void setPasswordValidatorNull(PasswordValidatorNull passwordValidatorNull) {
        this.passwordValidatorNull = passwordValidatorNull;
    }

    @Autowired
    public void setUsernameValidatorTooShort(UsernameValidatorTooShort usernameValidatorTooShort) {
        this.usernameValidatorTooShort = usernameValidatorTooShort;
    }

    @Autowired
    public void setPasswordValidatorTooShort(PasswordValidatorTooShort passwordValidatorTooShort) {
        this.passwordValidatorTooShort = passwordValidatorTooShort;
    }

    @Autowired
    public void setUsernameValidatorNoSpace(UsernameValidatorNoSpace usernameValidatorNoSpace) {
        this.usernameValidatorNoSpace = usernameValidatorNoSpace;
    }

    @Autowired
    public void setPasswordValidatorNoSpace(PasswordValidatorNoSpace passwordValidatorNoSpace) {
        this.passwordValidatorNoSpace = passwordValidatorNoSpace;
    }

    @Autowired
    public void setUserController(UserControllerImpl userController) {
        this.userController = userController;
    }

    @Autowired
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


    public static void main(String[] args)  {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

            boolean run = true;
            int choose = 0;

            List<Validator> validators = new ArrayList<>();
            validators.add(usernameValidatorNull);
            validators.add(passwordValidatorNull);
            validators.add(usernameValidatorTooShort);
            validators.add(passwordValidatorTooShort);
            validators.add(usernameValidatorNoSpace);
            validators.add(passwordValidatorNoSpace);

            List<ErrorMessage> messages;

            Scanner sc = new Scanner(System.in);


            try {
                while (true) {

                    System.out.println("\nMenu (1-3)");
                    System.out.println("1 - Adatok felvitele");
                    System.out.println("2 - Eddig felvitt adatok kiírása");
                    System.out.println("0 - Kilepes");

                    choose = sc.nextInt();
                    switch (choose) {
                        case 1:

                            boolean error = false;

                            System.out.println("Felhasználónevet kérek! (Min 6 karakter, Space-t nem tartalmazhat)");
                            sc.nextLine();
                            userDTO.setUsername(sc.nextLine());

                            System.out.println("Jelszót kérek! (Min 6 karakter, Space-t nem tartalmazhat)");
                            userDTO.setPassword(sc.next());


                            messages = userController.saveUser(userDTO);
                            if (!(messages.isEmpty())) {
                                error = true;
                            }

                            if (!error) {
                                System.out.println("Sikeres felvitel!");
                            }
                            else {
                                System.out.println("Sikertelen felvitel! Hibak:");
                                for (ErrorMessage message : messages) {
                                    System.out.println(message);
                                }
                            }

                            break;

                        case 2:
                            for (UserDTO i : userController.getUserDTOStore()) {
                                System.out.println(i);
                            }

                            break;

                        case 0:
                            sc.close();
                            System.exit(0);

                            break;

                        default:
                            System.out.println("Nincs ilyen menüpont!");
                    }
                }
            }catch (NumberFormatException e) {
            }



        }


}