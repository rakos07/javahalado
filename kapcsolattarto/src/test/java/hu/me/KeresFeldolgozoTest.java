package hu.me;

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

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.HibasAdat));
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

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(7.));
    }

    @Test
    public void feldolgoz_whenKivonas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.subtract(5, 2)).thenReturn(3.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("-");
        inputValues.setOperandus1(5);
        inputValues.setOperandus2(2);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(3.));
    }

    @Test
    public void feldolgoz_whenSzorzas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.multiply(5, 2)).thenReturn(10.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("*");
        inputValues.setOperandus1(5);
        inputValues.setOperandus2(2);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(10.));
    }

    @Test
    public void feldolgoz_whenOsztas_thenGiveValidResult() {

        Calculator calculator = Mockito.mock(Calculator.class);
        when(calculator.divide(10, 2)).thenReturn(5.);

        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(10);
        inputValues.setOperandus2(2);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.NincsHiba));
        Assert.assertThat(eredmeny.getEredmeny(), is(5.));
    }

    @Test
    public void feldolgoz_whenOsztasWithNullOperandus_thenGiveErrorString() {

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setMuvelet("/");
        inputValues.setOperandus1(10);
        inputValues.setOperandus2(0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.NullavalValoOsztas));
    }

    @Test
    public void feldolgoz_whenOperandusIsEmpty_thenGiveErrorString() {

        Calculator calculator = Mockito.mock(Calculator.class);
        KeresFeldolgozo keresFeldolgozo = new KeresFeldolgozo(calculator);

        InputValues inputValues = new InputValues();
        inputValues.setOperandus1(0.0);
        inputValues.setOperandus2(0.0);

        OutputValues eredmeny = keresFeldolgozo.feldolgoz(inputValues);

        Assert.assertThat(eredmeny.getHibaszoveg(), is(Hibaszoveg.HibasAdat));
    }
}