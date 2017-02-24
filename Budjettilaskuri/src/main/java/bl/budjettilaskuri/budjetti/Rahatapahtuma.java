package bl.budjettilaskuri.budjetti;

/**
 * Luokka kuvaa rahatapahtuma-oliota, jolla on (euro)määrä ja selite.
 */
public class Rahatapahtuma {

    private String selite;
    private int maara;

    /**
     * Konstruktori asettaa Rahatapahtumalle ehtojen mukaisen parametrina saadun
     * selitteen ja määrä, muuten null.
     *
     * @param maara mielivaltainen luku joka tahdotaan asettaa määräksi
     * @param selite mielivaltainen nimike joka tahdotaan asettaa selitteeksi
     */
    public Rahatapahtuma(String selite, int maara) {
        if (maara >= 0) {
            this.maara = maara;
        }
        if (selite.length() < 26) {
            this.selite = selite;
        }
    }

    public int getMaara() {
        return maara;
    }

    /**
     * Metodi asettaa parametrina saadun int-arvon oliomuuttujaan jos arvo on
     * suurempi tai yhtä suuri kuin nolla.
     *
     * @param maara mielivaltainen luku joka tahdotaan asettaa määräksi
     */
    public void setMaara(int maara) {
        if (maara >= 0) {
            this.maara = maara;
        }
    }

    public String getNimi() {
        return selite;
    }

    /**
     * Metodi asettaa parametrina saadun Stringin oliomuuttujaan jos sanan
     * pituus on alle 26 merkkiä.
     *
     * @param nimi mielivaltainen nimike joka tahdotaan asettaa selitteeksi
     */
    public void setNimi(String nimi) {
        if (nimi.length() < 26) {
            this.selite = nimi;
        }
    }

    /**
     * Metodi palauttaa olion String-muodon.
     *
     * @return String, joka sisältää selitteen ja määrän
     */
    @Override
    public String toString() {
        return (selite + ": " + maara);
    }

}
