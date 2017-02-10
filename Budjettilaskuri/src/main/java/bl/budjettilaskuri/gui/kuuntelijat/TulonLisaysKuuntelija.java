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
        int summa = 0;
        try {
            summa = Integer.parseInt(summaKentta.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (summa != 0) {
            rahatilanne.lisaaTulo(seliteKentta.getText(), summa);
        } 
        
    }

}
