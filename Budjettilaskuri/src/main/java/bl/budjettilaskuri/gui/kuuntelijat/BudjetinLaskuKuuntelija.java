package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


public class BudjetinLaskuKuuntelija implements ActionListener {

    private Rahatilanne rahatilanne;
    private JTextArea tekstiKentta;
    private Tulostin tulostin;

    public BudjetinLaskuKuuntelija(Rahatilanne rahatilanne, JTextArea tekstikentta, Tulostin tulostin) {
        this.rahatilanne = rahatilanne;
        this.tekstiKentta = tekstikentta;
        this.tulostin = tulostin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tekstiKentta.setText(tulostin.tulostaBudjetti(rahatilanne));
        

    }

}
