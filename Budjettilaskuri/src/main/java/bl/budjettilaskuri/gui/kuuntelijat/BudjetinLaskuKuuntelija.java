package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;


public class BudjetinLaskuKuuntelija implements ActionListener {

    private Rahatilanne rahatilanne;
    private JTextArea tekstiKentta;

    public BudjetinLaskuKuuntelija(Rahatilanne rahatilanne, JTextArea tekstikentta) {
        this.rahatilanne = rahatilanne;
        this.tekstiKentta = tekstikentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.tekstiKentta.setText("Kuukausibudjetti: " + this.rahatilanne.laskeKuukausiBudjetti());
        //this.tekstiKentta.setText("Viikkobudjetti: " + this.rahatilanne.laskeViikkoBudjetti());

    }

}
