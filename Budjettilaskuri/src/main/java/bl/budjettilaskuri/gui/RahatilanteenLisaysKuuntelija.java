package bl.budjettilaskuri.gui;

import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Currency;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class RahatilanteenLisaysKuuntelija implements ActionListener {

    private Rahatilanne rahatilanne;
    private JTextField seliteKentta;
    private JFormattedTextField summaKentta;

    public RahatilanteenLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JFormattedTextField summaKentta) {
        this.rahatilanne = rahatilanne;
        this.seliteKentta = seliteKentta;
        this.summaKentta = summaKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        double summa = ((Number)summaKentta.getValue().doubleValue());
//        Rahatapahtuma rahatapahtuma = new Rahatapahtuma(seliteKentta.getText(), summa);

    }

}
