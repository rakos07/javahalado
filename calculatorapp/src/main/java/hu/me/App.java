package hu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class App implements CommandLineRunner{


    CalculatorImpl calcImpl;
    KeresFeldolgozo keresFeldolgozo;
    Json json;
    Yaml yaml;
    Menu menu;

    @Autowired
    public void setCalcImpl(CalculatorImpl calcImpl) {
        this.calcImpl = calcImpl;
    }

    @Autowired
    public void setKeresFeldolgozo(KeresFeldolgozo keresFeldolgozo) {
        this.keresFeldolgozo = keresFeldolgozo;
    }

    @Autowired
    public void setJson(Json json) {
        this.json = json;
    }

    @Autowired
    public void setYaml(Yaml yaml) {
        this.yaml = yaml;
    }

    @Autowired
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        try {
            while (true) {
                    int choose = menu.mainMenu();
                switch (choose){
                    case 1:
                        json.jsonMenu(keresFeldolgozo);

                        break;
                    case 2:
                        yaml.yamlmenu(keresFeldolgozo);

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