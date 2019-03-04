package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hu.me.logika.CalculatorImpl;

import java.io.IOException;
import java.util.Scanner;


public class App {

    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        Scanner jsonsc = new Scanner(System.in);
        Scanner yamlsc = new Scanner(System.in);
        CalculatorImpl calcImpl = new CalculatorImpl();
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calcImpl);

        try {
            int choose;
            while (true) {
                System.out.println("Válasszon!:\n 1 - Json \n 2 - Yaml \n 0 - Kilépés");
                choose = sc.nextInt();
                if (choose == 0) System.exit(0);
                switch (choose){
                    case 1:
                        ObjectMapper objectMapperJson = new ObjectMapper();

                        String CalculatorJson = "{ \"muvelet\" : \"-\" , \"operandus1\" : 5 , \"operandus2\" : 1}";

                        InputValues inputjson = objectMapperJson.readValue(CalculatorJson, InputValues.class);

                        System.out.println("Kérem a műveletet!");
                        System.out.println("Válasszon!: + Összeadás - Kivonás * Szorzás / Osztás 0 Kilépés");

                        inputjson.setMuvelet(jsonsc.next());

                        if("0".equals(inputjson.getMuvelet())){
                            System.exit(0);
                        }

                        System.out.println("Adja meg az első számot: ");
                        inputjson.setOperandus1(jsonsc.nextInt());
                        System.out.println("Adja meg a második számot: ");
                        inputjson.setOperandus2(jsonsc.nextInt());


                        String json = objectMapperJson.writeValueAsString(keresFeldolgozo.feldolgoz(inputjson));
                        System.out.println(json + "\n");

                        break;
                    case 2:
                        ObjectMapper objectMapperYaml = new ObjectMapper(new YAMLFactory());

                        String CalculatorYaml =
                                "muvelet: \"+\"\n" +
                                        "operandus1: 5\n" +
                                        "operandus2: 1";

                        InputValues inputyaml = objectMapperYaml.readValue(CalculatorYaml, InputValues.class);

                        System.out.println("Kérem a műveletet!");
                        System.out.println("Válasszon!: + Összeadás - Kivonás * Szorzás / Osztás 0 Kilépés");

                        inputyaml.setMuvelet(yamlsc.next());

                        if("0".equals(inputyaml.getMuvelet())){
                            System.exit(0);
                        }

                        System.out.println("Adja meg az első számot: ");
                        inputyaml.setOperandus1(yamlsc.nextInt());
                        System.out.println("Adja meg a második számot: ");
                        inputyaml.setOperandus2(yamlsc.nextInt());


                        String yaml = objectMapperYaml.writeValueAsString(keresFeldolgozo.feldolgoz(inputyaml));
                        System.out.println(yaml + "\n");

                        break;
                    default:
                        System.out.println("Illigal Operation");
                }

            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }


    }
}