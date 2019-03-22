package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Json {

    public void jsonMenu(KeresFeldolgozo keresFeldolgozo) throws IOException {

        String CalculatorJson = "{ \"muvelet\" : \"-\" , \"operandus1\" : 5 , \"operandus2\" : 1}";

        ObjectMapper objectMapper = new ObjectMapper();

        Menu menu = new Menu();
        menu.allMenu(objectMapper, CalculatorJson, keresFeldolgozo);
    }
}
