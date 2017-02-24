package bl.budjettilaskuri.main;

import bl.budjettilaskuri.gui.Kayttoliittyma;
import bl.budjettilaskuri.budjetti.Rahatilanne;
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

        //Graafinen käyttöliittymä
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(new Rahatilanne());
        SwingUtilities.invokeLater(kayttoliittyma);

    }

}
