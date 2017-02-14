package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatapahtuma;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class RahatapahtumanLisaysKuuntelija implements ActionListener {

    Rahatilanne rahatilanne;
    JTextField seliteKentta;
    JTextField summaKentta;
    JTextArea tapahtumaKentta;

    public RahatapahtumanLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta, JTextArea tapahtumaKentta) {
        this.rahatilanne = rahatilanne;
        this.seliteKentta = seliteKentta;
        this.summaKentta = summaKentta;
        this.tapahtumaKentta = tapahtumaKentta;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        

    }

}
