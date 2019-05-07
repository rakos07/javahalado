package hu.me;

import org.springframework.stereotype.Service;

@Service
public class OutputValues {

    private double eredmeny;
    private Hibaszoveg hibaszoveg;
    private int hibakod;

    public double getEredmeny() {
        return eredmeny;
    }

    public void setEredmeny(double eredmeny) {
        this.eredmeny = eredmeny;
    }

    public Hibaszoveg getHibaszoveg() {
        return hibaszoveg;
    }

    public void setHibaszoveg(Hibaszoveg hibaszoveg) {
        this.hibaszoveg = hibaszoveg;
    }

    public int getHibakod() {
        return hibakod;
    }

    public void setHibakod(int hibakod) {
        this.hibakod = hibakod;
    }
}
