package hu.me;
import hu.me.inputJarmu;
public class Kapcsolat {
    JarmuLogika jarmuLogika;
    public Kapcsolat(JarmuLogika jarmuLogika) {
        this.jarmuLogika = jarmuLogika;
    }
    public outputJarmu feldolgoz(inputJarmu input) {
        outputJarmu outputJarmu = new outputJarmu();
        if(input.getHozzaad()) {
            outputJarmu.setOsszesuly(
                    this.jarmuLogika.sulyplusz(
                            input.getSuly(),
                            input.getSulyhozza())
            );
        }
        return outputJarmu;
    }
}