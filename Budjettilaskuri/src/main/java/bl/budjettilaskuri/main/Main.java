package bl.budjettilaskuri.main;

import bl.budjettilaskuri.gui.Kayttoliittyma;
import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Rahatilanne r = new Rahatilanne();
        r.lisaaTulo("opintotuki", 504);
        r.lisaaTulo("opintolaina", 400);
        r.lisaaMeno("vuokra", 425);
        r.lisaaMeno("ruoka ja vakuutukset", 175);
        r.lisaaMeno("unisport", 10);
        r.lisaaMeno("Unicafe", 60);
        r.lisaaMeno("Bussikortti", 39);
        r.lisaaMeno("puhelinlasku", 21.70);

        System.out.println("Kuukauden budjetti on: " + r.laskeKuukausiBudjetti());
        System.out.println("Viikon budjetti on: " + r.laskeViikkoBudjetti());
        System.out.println("Päivän budjetti on: " + r.laskePaivaBudjetti());

        String nimi = "vuokra";
        double maara = 850.0;
        Rahatapahtuma raha = new Rahatapahtuma(nimi, maara);
        System.out.println(raha);
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);


    }

}
