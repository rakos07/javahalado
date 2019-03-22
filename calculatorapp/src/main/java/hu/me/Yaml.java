package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Yaml {

    public void yamlmenu(KeresFeldolgozo keresFeldolgozo) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        String CalculatorYaml =
                "muvelet: \"+\"\n" +
                        "operandus1: 5\n" +
                        "operandus2: 1";

        Menu menu = new Menu();
        menu.allMenu(objectMapper, CalculatorYaml, keresFeldolgozo);


    }
}
