package bl.budjettilaskuri.logiikka;

import java.util.ArrayList;

/**
 * Luokka muodostaa listoista tulostettavan kokonaisuuden.
 */
public class Tulostin {

    /**
     * Metodi lisää listan alkiot String-muuttujaan.
     *
     * @param lista Rahatapahtumia sisältävä lista, jonka alkiot lisätään
     * String-muuttujaan
     *
     * @return Listan alkiot sisältävä String-muuttuja
     */
    public String tulostaLista(ArrayList<Rahatapahtuma> lista) {
        String tulostus = "";
        for (int i = 0; i < lista.size(); i++) {
            tulostus += (lista.get(i) + "\n");
        }
        return tulostus;
    }

    /**
     * Metodi lisää Rahatilanteen tulo- ja meno ArrayListit String-muuttujaan.
     *
     * @param rt Rahatilanne, jonka tulo- ja menolistat muutetaan tulostettavaan
     * muotoon
     *
     * @return Listojen alkiot sisältävä tulostettava String
     */
    public String tulostaRahatilanne(Rahatilanne rt) {
        String tulostus = "";
        tulostus += ("Tulot: \n");
        tulostus += tulostaLista(rt.getTulot());
        tulostus += "\n";
        tulostus += ("Menot: \n");
        tulostus += tulostaLista(rt.getMenot());
        return tulostus;
    }
}
