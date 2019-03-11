package hu.me;

import java.util.Scanner;

public class PasswordSave {
    public static void passwordsave(UserDTO userDTO) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a jelszót! Minumum 6 karakter és Space-t nem tartalmazhat.");
        userDTO.setPassword(sc.nextLine());
    }
}
