package bl.budjettilaskuri.logiikka;

import bl.budjettilaskuri.budjetti.Rahatapahtuma;
import java.util.ArrayList;

/**
 * Luokka suorittaa haluttuja laskutoimituksia budjetin laskemista varten.
 */
public class Laskuri {

    /**
     * Metodi laskee sille annetun ArrayListin summien yhteismäärän.
     *
     * @param rahat Rahatapahtumia sisältävä ArrayList, joka laskee
     * Rahatapahtumien määrät yhteen
     * @return Rahatapahtumien yhteenlaskettu summa
     */
    public int laskeSumma(ArrayList<Rahatapahtuma> rahat) {
        int summa = 0;
        for (int i = 0; i < rahat.size(); i++) {
            summa += rahat.get(i).getMaara();
        }
        return summa;
    }

    /**
     * Metodi laskee kahden sille annetun ArrayListin summien erotuksen.
     *
     * @param tulot Tulot sisältävä ArrayList, jonka yhteenlasketusta summasta
     * vähennetään menot
     * @param menot Menot sisältävä ArrayList, jonka yhteenlaskettu summa
     * vähennetään tuloista
     *
     * @return Tulojen ja menojen erotus
     */
    public int laskeTulojenJaMenojenErotus(ArrayList<Rahatapahtuma> tulot, ArrayList<Rahatapahtuma> menot) {
        return (laskeSumma(tulot) - laskeSumma(menot));
    }

    /**
     * Metodi laskee kahden sille annetun ArrayListin summien erotuksen ja jakaa
     * sen halutulla jakajalla.
     *
     * @param tulot Tulot sisältävä ArrayList, jonka yhteenlasketusta summasta
     * vähennetään menot
     * @param menot Menot sisältävä ArrayList, jonka yhteenlaskettu summa
     * vähennetään tuloista
     * @param jakaja Haluttu jakaja
     *
     * @return Tulojen ja menojen erotus jaettuna halutulla arvolla
     */
    public double laskeBudjetti(ArrayList<Rahatapahtuma> tulot, ArrayList<Rahatapahtuma> menot, int jakaja) {
        if (jakaja <= 0) {
            return 0.0;
        }
        return (laskeTulojenJaMenojenErotus(tulot, menot) / (double) jakaja);
    }

}
