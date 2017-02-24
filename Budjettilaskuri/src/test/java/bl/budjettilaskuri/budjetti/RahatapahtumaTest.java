package bl.budjettilaskuri.budjetti;


import bl.budjettilaskuri.budjetti.Rahatapahtuma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RahatapahtumaTest {

    Rahatapahtuma testiRaha;

    @Before
    public void setUp() {
        this.testiRaha = new Rahatapahtuma("puhelinlasku", 21);
    }

    @Test
    public void rahatapahtumanLuontiOnnistuu() {
        String nimi = "vuokra";
        int maara = 850;
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        assertEquals("vuokra: 850", raha.toString());
    }

    @Test
    public void rahatapahtumanLuontiEiOnnistuVaarillaSyotteilla() {
        String nimi = "vuokrajaruokajatelevisiojapuhelinlasku";
        int maara = (-69);
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        assertEquals("null: 0", raha.toString());
    }

    @Test
    public void rahatapahtumanGetteritToimivat() {
        assertEquals(21, testiRaha.getMaara());
        assertEquals("puhelinlasku", testiRaha.getNimi());
    }

    @Test
    public void rahatapahtumanSetteritToimivat() {
        testiRaha.setMaara(29);
        testiRaha.setNimi("laajakaista");
        assertEquals("laajakaista: 29", testiRaha.toString());
    }

    @Test
    public void rahatapahtumanSetteritEivätToimiVaarillaSyotteilla() {
        testiRaha.setMaara(-23);
        testiRaha.setNimi("kaikkimenotjatulotjabudjettijaplööh");
        assertEquals("puhelinlasku: 21", testiRaha.toString());
    }
}
