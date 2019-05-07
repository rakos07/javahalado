package hu.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeresFeldolgozo {

    Calculator calculator;

    @Autowired
    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Autowired
    public KeresFeldolgozo(Calculator calculator) {
        this.calculator = calculator;
    }

    @Autowired
    public OutputValues feldolgoz(InputValues input) {
        OutputValues outputValues = new OutputValues();

        if(input.getMuvelet() == null || input.getMuvelet().isEmpty() || input.getOperandus1() == 0.0 || input.getOperandus2() == 0.0) {
            outputValues.setHibaszoveg(Hibaszoveg.HibasAdat);
            outputValues.setHibakod(1);
        }


        if("+".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.add(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
            outputValues.setHibaszoveg(Hibaszoveg.NincsHiba);
            outputValues.setHibakod(0);
        }

        if("-".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.subtract(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
            outputValues.setHibaszoveg(Hibaszoveg.NincsHiba);
            outputValues.setHibakod(0);
        }

        if("*".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.multiply(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
            outputValues.setHibaszoveg(Hibaszoveg.NincsHiba);
            outputValues.setHibakod(0);
        }

        if("/".equals(input.getMuvelet())) {
            outputValues.setEredmeny(
                    this.calculator.divide(
                            input.getOperandus1(),
                            input.getOperandus2()
                    )
            );
            outputValues.setHibaszoveg(Hibaszoveg.NincsHiba);
            outputValues.setHibakod(0);
        }

        if("/".equals(input.getMuvelet())) {
            if(input.getOperandus1() == 0.0 || input.getOperandus2() == 0.0){
                outputValues.setHibaszoveg(Hibaszoveg.NullavalValoOsztas);
                outputValues.setHibakod(2);
            }
        }

        return outputValues;
    }
}