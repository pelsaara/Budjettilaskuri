package bl.budjettilaskuri.main;

import bl.budjettilaskuri.gui.Kayttoliittyma;
import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        //Testidataa
        Rahatilanne r = new Rahatilanne();
        r.lisaaTulo("opintotuki", 504);
        r.lisaaTulo("opintolaina", 400);
        r.lisaaMeno("vuokra", 425);
        r.lisaaMeno("ruoka ja vakuutukset", 175);
        r.lisaaMeno("unisport", 10);
        r.lisaaMeno("Unicafe", 60);
        r.lisaaMeno("Bussikortti", 39);
        r.lisaaMeno("puhelinlasku", 22);

        System.out.println("Kuukauden budjetti on: " + r.laskeKuukausiBudjetti());
        System.out.println("Viikon budjetti on: " + r.laskeViikkoBudjetti());
        System.out.println("Päivän budjetti on: " + r.laskePaivaBudjetti());
        System.out.println("");
        Tulostin tulostin = new Tulostin();
        System.out.println(tulostin.tulostaRahatilanne(r));
        System.out.println("");

        String nimi = "vuokra";
        int maara = 850;
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        System.out.println(raha);
        
        //Graafinen käyttöliittymä
        Rahatilanne uusi = new Rahatilanne();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(uusi);
        SwingUtilities.invokeLater(kayttoliittyma);
        

    }

}
