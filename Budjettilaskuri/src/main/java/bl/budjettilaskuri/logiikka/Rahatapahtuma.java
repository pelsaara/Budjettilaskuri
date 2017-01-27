package bl.budjettilaskuri.logiikka;

public class Rahatapahtuma {

    private String nimi;
    private double maara;

    public Rahatapahtuma(String n, double m) {
        if (m >= 0) {
            this.maara = m;
        }
        if (n.length() < 26) {
            this.nimi = n;
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
        return nimi;
    }

    public void setNimi(String nimi) {
        if (nimi.length() < 26) {
            this.nimi = nimi;
        }
    }

    @Override
    public String toString() {
        return (nimi + ": " + maara);
    }

}
