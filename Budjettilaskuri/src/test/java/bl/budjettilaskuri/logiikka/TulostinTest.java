package bl.budjettilaskuri.logiikka;

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
    public void tulostaRahatilanneToimii() {
        String tuloste = "Tulot: \ntuki: 500\n\nMenot: \nvuokra: 800\n";
        assertEquals(tuloste, tulostin.tulostaRahatilanne(tilanne));
    }
}
