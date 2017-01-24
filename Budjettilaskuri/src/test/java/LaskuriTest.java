

import bl.budjettilaskuri.logiikka.Laskuri;
import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskuriTest {
        Laskuri laskuri;
    
        
    @Before
    public void setUp() {
        laskuri = new Laskuri();
    }
    
    @Test 
    public void laskeSummaToimii(){
        ArrayList<Rahatapahtuma> testi = new ArrayList<>();
        testi.add(new Rahatapahtuma("eka", 1));
        testi.add(new Rahatapahtuma("toka", 2));
        assertEquals(3.0, laskuri.laskeSumma(testi), 0.005);
    }
            
}
