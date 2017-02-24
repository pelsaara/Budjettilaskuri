package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MenonLisaysKuuntelija extends RahatapahtumanLisaysKuuntelija {

    public MenonLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta, JTextArea tapahtumaKentta, Tulostin tulostin) {
        super(rahatilanne, seliteKentta, summaKentta, tapahtumaKentta, tulostin);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int summa = 0;
        String selite = "";
        try {
            summa = Integer.parseInt(summaKentta.getText());
            selite = seliteKentta.getText();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (summa > 0 && selite.length() <= 26 && selite.length() > 0) {
            rahatilanne.lisaaMeno(seliteKentta.getText(), summa);
            seliteKentta.setText("");
            summaKentta.setText("");
            tapahtumaKentta.setText("Menot: \n" + tulostin.tulostaLista(rahatilanne.getMenot()));
        }

    }

}
