package hu.me;

public class Kapcsolat {

    JarmuLogika jarmuLogika;

    public Kapcsolat(JarmuLogika jarmuLogika) {
        this.jarmuLogika = jarmuLogika;
    }

    public OutputJarmu feldolgoz(InputJarmu input) {

        OutputJarmu outputJarmu = new OutputJarmu();

        if(input.getHozzaad() == null) {
            outputJarmu.setJarmuhiba(JarmuHiba.Nincshozzaadas);
        }

        if(input.getHozzaad()) {
            outputJarmu.setOsszesuly(
                    this.jarmuLogika.sulyplusz(
                            input.getSuly(),
                            input.getSulyhozza())
            );
            outputJarmu.setJarmuhiba(JarmuHiba.Nincshiba);
            if (input.getSulyhozza() <= 0){
                outputJarmu.setJarmuhiba(JarmuHiba.Hibaspluszsuly);
            }
        }

        return outputJarmu;
    }
}