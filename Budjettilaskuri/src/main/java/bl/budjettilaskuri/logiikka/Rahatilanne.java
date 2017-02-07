package bl.budjettilaskuri.logiikka;

import java.util.ArrayList;

/**
 * Luokka pitää kirjaa rahatilanteesta kirjaamalla tuloja ja menoja niille
 * osoitettuihin ArrayListeihin.
 */
public class Rahatilanne {

    private Laskuri laskuri;
    private ArrayList<Rahatapahtuma> tulot;
    private ArrayList<Rahatapahtuma> menot;

    public Rahatilanne() {
        this.laskuri = new Laskuri();
        this.tulot = new ArrayList<>();
        this.menot = new ArrayList<>();
    }

    /**
     * Metodi lisää tulon muistiin tuloille tarkoitettuun ArrayListiin.
     *
     * @param selite Käyttäjän antama selite tulolle
     * @param maara Käyttäjän antama summa tulolle
     */
    public void lisaaTulo(String selite, double maara) {
        if (selite.length() < 26 && maara >= 0.0) {
            tulot.add(new Rahatapahtuma(selite, maara));
        }
    }

    /**
     * Metodi lisää menon muistiin menoille tarkoitettuun ArrayListiin.
     *
     * @param selite Käyttäjän antama selite tulolle
     * @param maara Käyttäjän antama summa tulolle
     */
    public void lisaaMeno(String selite, double maara) {
        if (selite.length() < 26 && maara >= 0.0) {
            menot.add(new Rahatapahtuma(selite, maara));
        }
    }

    /**
     * Metodi laskee tulojen ja menojen summan.
     *
     * @return tulojen ja menojen summa
     */
    public double laskeKuukausiBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 1);
    }

    /**
     * Metodi laskee tulojen ja menojen summan jaettuja viikkojen määrällä.
     *
     * @return tulojen ja menojen summa jaettuna viikkojen määrällä
     */
    public double laskeViikkoBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 4);
    }

    /**
     * Metodi laskee tulojen ja menojen summan jaettuna päivien määrällä.
     *
     * @return tulojen ja menojen summa jaettuna päivien määrällä
     */
    public double laskePaivaBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 30);
    }

    /**
     * Metodi palauttee tulojen summan
     *
     * @return tulojen summa
     */
    public double tulot() {
        return laskuri.laskeSumma(tulot);
    }

    /**
     * Metodi palauttee menojen summan
     *
     * @return menojen summa
     */
    public double menot() {
        return laskuri.laskeSumma(menot);
    }

}
