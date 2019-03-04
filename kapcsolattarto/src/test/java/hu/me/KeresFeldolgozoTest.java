package hu.me;

import hu.me.logika.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class KeresFeldolgozoTest {

    @Test
    public void feldolgoz_whenEmptyOperator_thenGiveErrorString() {
        String input = "";

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("");

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.HibasMuveletiJel));
    }

    @Test
    public void feldolgoz_whenNullInput_thenGiveErrorString() {

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.HibasMuveletiJel));
    }

    @Test
    public void feldolgoz_whenOsszeadas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.add(3, 4)).thenReturn(7.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("+");
        inputValues.setOperandus1(3);
        inputValues.setOperandus2(4);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(7.));
    }


}

// kivonás szorzás osztás
// nézni kódlefedettség, hogyan
