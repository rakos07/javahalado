package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Json {

    Menu menu;

    @Autowired
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void jsonMenu(KeresFeldolgozo keresFeldolgozo) throws IOException {

        String CalculatorJson = "{ \"muvelet\" : \"-\" , \"operandus1\" : 5 , \"operandus2\" : 1}";

        ObjectMapper objectMapper = new ObjectMapper();

        menu.allMenu(objectMapper, CalculatorJson, keresFeldolgozo);
    }
}
