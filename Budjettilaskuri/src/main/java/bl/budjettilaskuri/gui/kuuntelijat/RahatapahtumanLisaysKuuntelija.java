package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public abstract class RahatapahtumanLisaysKuuntelija implements ActionListener {

    Rahatilanne rahatilanne;
    JTextField seliteKentta;
    JTextField summaKentta;

    public RahatapahtumanLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta) {
        this.rahatilanne = rahatilanne;
        this.seliteKentta = seliteKentta;
        this.summaKentta = summaKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double summa = 0.0;
        try {
            summa = Double.parseDouble(summaKentta.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
