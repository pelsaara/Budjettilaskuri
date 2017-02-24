package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class BudjetinLaskuKuuntelija implements ActionListener {

    private final Rahatilanne rahatilanne;
    private final JTextArea tekstiKentta;
    private final Tulostin tulostin;

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
