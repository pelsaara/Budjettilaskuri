package bl.budjettilaskuri.logiikka;

import java.util.ArrayList;

public class Rahatilanne {

    private Laskuri laskuri;
    private ArrayList<Rahatapahtuma> tulot;
    private ArrayList<Rahatapahtuma> menot;

    public Rahatilanne() {
        this.laskuri = new Laskuri();
        this.tulot = new ArrayList<>();
        this.menot = new ArrayList<>();
    }

    public void lisaaTulo(String nimi, double maara) {
        if (nimi.length() < 26 && maara >= 0.0) {
            tulot.add(new Rahatapahtuma(nimi, maara));
        }
    }

    public void lisaaMeno(String nimi, double maara) {
        if (nimi.length() < 26 && maara >= 0.0) {
            menot.add(new Rahatapahtuma(nimi, maara));
        }
    }

    public double laskeKuukausiBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 1);
    }

    public double laskeViikkoBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 4);
    }

    public double laskePaivaBudjetti() {
        return laskuri.laskeBudjetti(tulot, menot, 30);
    }

    public double tulot() {
        return laskuri.laskeSumma(tulot);
    }

    public double menot() {
        return laskuri.laskeSumma(menot);
    }

}
