package bl.budjettilaskuri.logiikka;

public class Rahatapahtuma {

    private String selite;
    private double maara;

    public Rahatapahtuma(String selite, double maara) {
        if (maara >= 0) {
            this.maara = maara;
        }
        if (selite.length() < 26) {
            this.selite = selite;
        }
    }

    public double getMaara() {
        return maara;
    }

    public void setMaara(double maara) {
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

    @Override
    public String toString() {
        return (selite + ": " + maara);
    }

}
