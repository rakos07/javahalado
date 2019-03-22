package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Yaml {

    Menu menu;

    @Autowired
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void yamlmenu(KeresFeldolgozo keresFeldolgozo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String CalculatorYaml =
                "muvelet: \"+\"\n" +
                        "operandus1: 5\n" +
                        "operandus2: 1";

        menu.allMenu(objectMapper, CalculatorYaml, keresFeldolgozo);


    }
}
