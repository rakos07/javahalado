package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;



@Service
public class Menu {

    public int mainMenu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Válasszon!:\n 1 - Json \n 2 - Yaml \n 0 - Kilépés");
        int choose = sc.nextInt();
        if (choose == 0) System.exit(0);

        return choose;
    }

    public void allMenu(ObjectMapper objectMapper, String CalcBody, KeresFeldolgozo keresFeldolgozo) throws IOException {



        Scanner sc = new Scanner(System.in);

        InputValues input = objectMapper.readValue(CalcBody, InputValues.class);

        System.out.println("Kérem a műveletet!");
        System.out.println("Válasszon!: + Összeadás - Kivonás * Szorzás / Osztás 0 Kilépés");

        input.setMuvelet(sc.next());

        if("0".equals(input.getMuvelet())){
            System.exit(0);
        }

        System.out.println("Adja meg az első számot: ");
        input.setOperandus1(sc.nextInt());
        System.out.println("Adja meg a második számot: ");
        input.setOperandus2(sc.nextInt());


        String result = objectMapper.writeValueAsString(keresFeldolgozo.feldolgoz(input));
        System.out.println(result + "\n");
        
    }

}
