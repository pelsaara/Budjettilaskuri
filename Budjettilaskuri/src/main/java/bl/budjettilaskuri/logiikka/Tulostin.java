package bl.budjettilaskuri.logiikka;

import java.util.ArrayList;

public class Tulostin {

    public void tulostaLista(ArrayList<Rahatapahtuma> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            System.out.println(lista.get(i).toString());
        }
    }

    public void tulostaRahatilanne(Rahatilanne rt) {
        System.out.println("Tulot: ");
        tulostaLista(rt.getTulot());
        System.out.println("");
        System.out.println("Menot: ");
        tulostaLista(rt.getMenot());
    }
}
