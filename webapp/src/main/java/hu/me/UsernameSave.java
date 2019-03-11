package hu.me;

import java.util.Scanner;

public class UsernameSave {
    public static void usernamesave(UserDTO userDTO) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adja meg a felhasználónevét! Minumum 6 karakter és Space-t nem tartalmazhat.");
        userDTO.setUsername(sc.nextLine());
    }
}
