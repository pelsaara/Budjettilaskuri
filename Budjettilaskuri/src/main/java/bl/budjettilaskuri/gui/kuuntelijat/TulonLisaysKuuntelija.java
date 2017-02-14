package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.logiikka.Rahatilanne;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TulonLisaysKuuntelija extends RahatapahtumanLisaysKuuntelija {
    
    public TulonLisaysKuuntelija(Rahatilanne rahatilanne, JTextField seliteKentta, JTextField summaKentta, JTextArea tapahtumaKentta) {
        super(rahatilanne, seliteKentta, summaKentta, tapahtumaKentta);
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
        if (summa >= 0 && selite.length() <= 26) {
            rahatilanne.lisaaTulo(seliteKentta.getText(), summa);
            seliteKentta.setText(null);
            summaKentta.setText(null);
            Tulostin tulostin = new Tulostin();
            tapahtumaKentta.setText("Tulot: \n" + tulostin.tulostaLista(rahatilanne.getTulot()));
        }
        
    }
    
}
