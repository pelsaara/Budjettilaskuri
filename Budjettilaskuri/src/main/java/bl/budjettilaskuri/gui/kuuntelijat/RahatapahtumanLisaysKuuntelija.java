package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class RahatapahtumanLisaysKuuntelija implements ActionListener {

    Rahatilanne rahatilanne;
    JTextField seliteKentta;
    JTextField summaKentta;
    JTextArea tapahtumaKentta;
    Tulostin tulostin;

    public RahatapahtumanLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta, JTextArea tapahtumaKentta, Tulostin tulostin) {
        this.rahatilanne = rahatilanne;
        this.seliteKentta = seliteKentta;
        this.summaKentta = summaKentta;
        this.tapahtumaKentta = tapahtumaKentta;
        this.tulostin = tulostin;

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

}
