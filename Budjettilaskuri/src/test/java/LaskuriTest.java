
import bl.budjettilaskuri.logiikka.Laskuri;
import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskuriTest {

    Laskuri laskuri;
    ArrayList<Rahatapahtuma> tulot;
    ArrayList<Rahatapahtuma> menot;

    @Before
    public void setUp() {
        laskuri = new Laskuri();
        this.tulot = new ArrayList<>();
        this.menot = new ArrayList<>();
        tulot.add(new Rahatapahtuma("palkka", 100));
        tulot.add(new Rahatapahtuma("osingot", 20));
        menot.add(new Rahatapahtuma("vuokra", 80));
        menot.add(new Rahatapahtuma("ruoka", 20));

    }

    @Test
    public void laskeSummaToimii() {
        ArrayList<Rahatapahtuma> testi = new ArrayList<>();
        testi.add(new Rahatapahtuma("eka", 1));
        testi.add(new Rahatapahtuma("toka", 2));
        assertEquals(3.0, laskuri.laskeSumma(testi), 0.005);
    }

    @Test
    public void laskeTulojenJaMenojenErotusToimii() {
        assertEquals(20.0, laskuri.laskeTulojenJaMenojenErotus(tulot, menot), 0.005);
    }

    @Test
    public void laskeBudjettiToimii() {
        assertEquals(4.0, laskuri.laskeBudjetti(tulot, menot, 5), 0.005);
    }

    @Test
    public void laskeBudjettiPalauttaaNollaJosJakajaNegatiivinen() {
        assertEquals(0.0, laskuri.laskeBudjetti(tulot, menot, (-5)), 0.005);
    }

}
