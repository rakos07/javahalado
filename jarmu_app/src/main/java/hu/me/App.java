package hu.me;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        JarmuLogikaImpl jarmuLogika = new JarmuLogikaImpl();
        Kapcsolat kapcsolat = new Kapcsolat(jarmuLogika);
        String JarmuJson = "{ \"suly\" : 300 , \"hozzaad\" : false , \"sulyhozza\" : 1}";
        ObjectMapper objectMapperJson = new ObjectMapper();
        inputJarmu inputJarmu = objectMapperJson.readValue(JarmuJson, inputJarmu.class);
        System.out.println("Kérem adja meg a jármű súlyát!");
        inputJarmu.setSuly(sc.nextInt());
        System.out.println("Kérem adja meg, hogy szeretne-e súly hozzáadni? (true igen, false nem)");
        inputJarmu.setHozzaad(sc.nextBoolean());
        if(inputJarmu.getHozzaad()){
            System.out.println("Kérem adja meg mennyivel szeretné növelni!");
            inputJarmu.setSulyhozza(sc.nextInt());
        }
        String json = objectMapperJson.writeValueAsString(kapcsolat.feldolgoz(inputJarmu));
        System.out.println(json + "\n");
    }
}