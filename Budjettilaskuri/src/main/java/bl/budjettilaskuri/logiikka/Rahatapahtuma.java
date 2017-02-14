package bl.budjettilaskuri.logiikka;

/**
 * Luokka kuvaa rahatapahtuma-oliota, jolla on (euro)määrä ja selite.
 */
public class Rahatapahtuma {

    private String selite;
    private int maara;

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

    public void setMaara(int maara) {
        if (maara >= 0) {
            this.maara = maara;
        }
    }

    public String getNimi() {
        return selite;
    }

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
