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

    public void lisaaTulo(String n, double m) {
        tulot.add(new Rahatapahtuma(n, m));
    }

    public void lisaaMeno(String n, double m) {
        menot.add(new Rahatapahtuma(n, m));
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

}
