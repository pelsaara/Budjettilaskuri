
import bl.budjettilaskuri.logiikka.Rahatilanne;
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
        tilanne.lisaaTulo("palkka", 800.0);
        assertEquals(800.0, tilanne.tulot(), 0.005);
    }

    @Test
    public void lisaaTuloEiToimiVaarillaSyotteilla() {
        tilanne.lisaaTulo("palkka", (-800.0));
        tilanne.lisaaTulo("palkkajatukijalainajaelaritjaosingot", (800.0));
        assertEquals(0.0, tilanne.tulot(), 0.005);
    }

    @Test
    public void lisaaMenoToimii() {
        tilanne.lisaaMeno("vuokra", 425.0);
        assertEquals(425.0, tilanne.menot(), 0.005);
    }

    @Test
    public void lisaaMenoEiToimiVaarillaSyotteilla() {
        tilanne.lisaaMeno("vuokra", (-660.0));
        tilanne.lisaaMeno("vuokraruokasähkövakuutukset", 700.0);
        assertEquals(0.0, tilanne.menot(), 0.005);
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
