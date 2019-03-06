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
        inputValues.setOperandus1(null);
        inputValues.setOperandus2(null);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.HianyzoOperandus));
    }

    @Test
    public void feldolgoz_whenOsszeadas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.add(3, 4)).thenReturn(7.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("+");
        inputValues.setOperandus1(3.0);
        inputValues.setOperandus2(4.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(7.));
    }

    @Test
    public void feldolgoz_whenKivonas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.subtract(5, 2)).thenReturn(3.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("-");
        inputValues.setOperandus1(5.0);
        inputValues.setOperandus2(2.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(3.));
    }

    @Test
    public void feldolgoz_whenSzorzas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.multiply(5, 2)).thenReturn(10.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("*");
        inputValues.setOperandus1(5.0);
        inputValues.setOperandus2(2.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(10.));
    }

    @Test
    public void feldolgoz_whenOsztas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.divide(10, 2)).thenReturn(5.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(10.0);
        inputValues.setOperandus2(2.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(5.));
    }

    @Test
    public void feldolgoz_whenOsztasOperandus1isnull_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.divide(10, 0)).thenReturn(0.0);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(10.0);
        inputValues.setOperandus2(0.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NullavalValoOsztas));
    }

    @Test
    public void feldolgoz_whenOsztasOperandus2isnull_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.divide(0, 10)).thenReturn(0.0);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(0.0);
        inputValues.setOperandus2(10.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibakod(), is(Hibakod.NullavalValoOsztas));
    }


}
