package bl.budjettilaskuri.logiikka;

import java.util.ArrayList;

public class Laskuri {

    public double laskeSumma(ArrayList<Rahatapahtuma> rahat) {
        double summa = 0.0;
        for (int i = 0; i < rahat.size(); i++) {
            summa += rahat.get(i).getMaara();
        }
        return summa;
    }

    public double laskeTulojenJaMenojenErotus(ArrayList<Rahatapahtuma> tulot, ArrayList<Rahatapahtuma> menot) {
        return (laskeSumma(tulot) - laskeSumma(menot));
    }

    public double laskeBudjetti(ArrayList<Rahatapahtuma> tulot, ArrayList<Rahatapahtuma> menot, int jakaja) {
        if (jakaja < 0) {
            return 0.0;
        }
        return (laskeTulojenJaMenojenErotus(tulot, menot) / jakaja);
    }

}
