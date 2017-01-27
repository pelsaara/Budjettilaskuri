package bl.budjettilaskuri.logiikka;


import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RahatapahtumaTest {

    Rahatapahtuma testiRaha;

    @Before
    public void setUp() {
        this.testiRaha = new Rahatapahtuma("puhelinlasku", 21.0);
    }

    @Test
    public void rahatapahtumanLuontiOnnistuu() {
        String nimi = "vuokra";
        double maara = 850.0;
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        assertEquals("vuokra: 850.0", raha.toString());
    }

    @Test
    public void rahatapahtumanLuontiEiOnnistuVaarillaSyotteilla() {
        String nimi = "vuokrajaruokajatelevisiojapuhelinlasku";
        double maara = (-69.0);
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        assertEquals("null: 0.0", raha.toString());
    }

    @Test
    public void rahatapahtumanGetteritToimivat() {
        assertEquals(21.0, testiRaha.getMaara(), 0.005);
        assertEquals("puhelinlasku", testiRaha.getNimi());
    }

    @Test
    public void rahatapahtumanSetteritToimivat() {
        testiRaha.setMaara(29.9);
        testiRaha.setNimi("laajakaista");
        assertEquals("laajakaista: 29.9", testiRaha.toString());
    }

    @Test
    public void rahatapahtumanSetteritEivätToimiVaarillaSyotteilla() {
        testiRaha.setMaara(-23.0);
        testiRaha.setNimi("kaikkimenotjatulotjabudjettijaplööh");
        assertEquals("puhelinlasku: 21.0", testiRaha.toString());
    }
}
