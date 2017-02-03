package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TulonLisaysKuuntelija extends RahatapahtumanLisaysKuuntelija {

    public TulonLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta) {
        super(rahatilanne, seliteKentta, summaKentta);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double summa = 0.0;
        try {
            summa = Double.parseDouble(summaKentta.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        rahatilanne.lisaaTulo(seliteKentta.getText(), summa);
    }

}
