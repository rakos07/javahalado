package hu.me;

import hu.me.validators.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        UsernameValidatorNull usernameValidatorNull = new UsernameValidatorNull();
        PasswordValidatorNull passwordValidatorNull = new PasswordValidatorNull();
        UsernameValidatorTooShort usernameValidatorTooShort = new UsernameValidatorTooShort();
        PasswordValidatorTooShort passwordValidatorTooShort = new PasswordValidatorTooShort();
        UsernameValidatorNoSpace usernameValidatorNoSpace = new UsernameValidatorNoSpace();
        PasswordValidatorNoSpace passwordValidatorNoSpace = new PasswordValidatorNoSpace();

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

        UserControllerImpl controller = new UserControllerImpl(validators);
        Scanner sc = new Scanner(System.in);

        while (run) {

            System.out.println("\nMenu (1-3)");
            System.out.println("1 - Adatok felvitele");
            System.out.println("2 - Eddig felvitt adatok kiírása");
            System.out.println("3 - Kilepes");

            try {
                choose = Integer.parseInt(sc.nextLine());
            }
            catch (NumberFormatException e) {}
            switch(choose){
                case 1: {

                    boolean error = false;

                    UserDTO userDTO = new UserDTO();
                    System.out.println("Felhasználónevet kérek! (Min 6 karakter, Space-t nem tartalmazhat)");
                    String username = sc.nextLine();
                    userDTO.setUsername(username);
                    System.out.println("Jelszót kérek! (Min 6 karakter, Space-t nem tartalmazhat)");
                    String password = sc.nextLine();
                    userDTO.setPassword(password);


                    messages = controller.saveUser(userDTO);
                    if (!(messages.isEmpty())){
                        error = true;
                    }

                    if (!error) {
                        System.out.println("Sikeres felvitel!");
                    }
                    else {
                        System.out.println("Sikertelen felvitel! Hibak:");
                        for ( ErrorMessage message : messages ){
                            System.out.println(message);
                        }
                    }
                    break;
                }
                case 2: {
                    for (UserDTO i : controller.getUserDTOStore()) {
                        System.out.println(i);
                    }
                    break;
                }
                case 3: {
                    sc.close();
                    run = false;
                    break;
                }
                default: System.out.println("Nincs ilyen menüpont!");
            }
        }
    }
}