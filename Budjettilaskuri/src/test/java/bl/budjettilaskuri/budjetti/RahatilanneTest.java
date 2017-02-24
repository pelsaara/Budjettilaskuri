package bl.budjettilaskuri.budjetti;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RahatilanneTest {

    Rahatilanne tilanne;

    @Before
    public void setUp() {
        this.tilanne = new Rahatilanne();
    }

    @Test
    public void lisaaTuloToimii() {
        tilanne.lisaaTulo("palkka", 800);
        assertEquals(800, tilanne.tulot());
    }

    @Test
    public void lisaaTuloEiToimiVaarillaSyotteilla() {
        tilanne.lisaaTulo("palkka", (-800));
        tilanne.lisaaTulo("palkkajatukijalainajaelaritjaosingot", (800));
        assertEquals(0, tilanne.tulot());
    }

    @Test
    public void lisaaMenoToimii() {
        tilanne.lisaaMeno("vuokra", 425);
        assertEquals(425, tilanne.menot());
    }

    @Test
    public void lisaaMenoEiToimiVaarillaSyotteilla() {
        tilanne.lisaaMeno("vuokra", (-660));
        tilanne.lisaaMeno("vuokraruokasähkövakuutukset", 700);
        assertEquals(0, tilanne.menot());
    }

    @Test
    public void laskeKuukausiBudjettiToimii() {
        tilanne.lisaaTulo("palkka", 600);
        tilanne.lisaaMeno("vuokra", 200);
        assertEquals(((600 - 200) / 1), tilanne.laskeKuukausiBudjetti(), 0.005);
    }

    @Test
    public void laskeViikkoBudjettiToimii() {
        tilanne.lisaaTulo("palkka", 600);
        tilanne.lisaaMeno("vuokra", 200);
        assertEquals(((600 - 200) / 4.0), tilanne.laskeViikkoBudjetti(), 0.005);
    }

    @Test
    public void laskePaivaBudjettiToimii() {
        tilanne.lisaaTulo("palkka", 600);
        tilanne.lisaaMeno("vuokra", 200);
        assertEquals(((600 - 200) / 30.0), tilanne.laskePaivaBudjetti(), 0.005);
    }
}
