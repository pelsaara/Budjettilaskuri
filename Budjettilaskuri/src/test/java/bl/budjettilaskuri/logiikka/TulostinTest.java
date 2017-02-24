package bl.budjettilaskuri.logiikka;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TulostinTest {

    Tulostin tulostin;
    Rahatilanne tilanne;

    @Before
    public void setUp() {
        this.tulostin = new Tulostin();
        this.tilanne = new Rahatilanne();
        tilanne.lisaaMeno("vuokra", 800);
        tilanne.lisaaTulo("tuki", 500);
    }

    @Test
    public void tulostaListaToimii() {
        String tuloste = "vuokra: 800\n";
        assertEquals(tuloste, tulostin.tulostaLista(tilanne.getMenot()));
    }

    @Test
    public void tulostaTulotJaMenotToimii() {
        String tuloste = "Tulot: \ntuki: 500\n\nMenot: \nvuokra: 800\n";
        assertEquals(tuloste, tulostin.tulostaTulotJaMenot(tilanne));
    }
    
    @Test 
    public void tulostaBudjettiToimii() {
        tilanne.lisaaTulo("palkka", 600);
        String tuloste = "Kuukausibudjetti: 300,00\nViikkobudjetti: 75,00\nPäiväbudjetti: 10,00";
        assertEquals(tuloste, tulostin.tulostaBudjetti(tilanne));
    }
    
    @Test 
    public void tulostaRahatilanneToimii() {
        tilanne.lisaaTulo("palkka", 600);
        String tuloste = "";
        tuloste = "Tulot: \ntuki: 500\npalkka: 600\n\nMenot: \nvuokra: 800\n";
        tuloste += "\n\n";
        tuloste += "Kuukausibudjetti: 300,00\nViikkobudjetti: 75,00\nPäiväbudjetti: 10,00";
        assertEquals(tuloste, tulostin.tulostaRahatilanne(tilanne));
    }
}
