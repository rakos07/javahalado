package hu.me;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

public class KapcsolatTest
{

    @Test
    public void kapcsolat_whenSulyTooLow() {

        JarmuLogika jarmuLogika = Mockito.mock(JarmuLogika.class);

        when(jarmuLogika.sulyplusz(300,0)).thenReturn(300);

        Kapcsolat kapcsolat = new Kapcsolat(jarmuLogika);

        InputJarmu inputJarmu = new InputJarmu();
        inputJarmu.setHozzaad(true);
        inputJarmu.setSuly(300);
        inputJarmu.setSulyhozza(0);

        OutputJarmu osszsuly = kapcsolat.feldolgoz(inputJarmu);

        Assert.assertThat(osszsuly.getJarmuhiba(), is(JarmuHiba.Hibaspluszsuly));
    }


}
