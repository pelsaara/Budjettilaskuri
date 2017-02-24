package bl.budjettilaskuri.gui.kuuntelijat;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.logiikka.TiedostoTulostin;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

public class BudjetinTulostusKuuntelija implements ActionListener {

    private final Tulostin tulostin;
    private final TiedostoTulostin tiedostoTulostin;
    private final Rahatilanne r;

    public BudjetinTulostusKuuntelija(Tulostin t, Rahatilanne r) {
        this.tulostin = t;
        this.tiedostoTulostin = new TiedostoTulostin();
        this.r = r;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame parentFrame = new JFrame();

        JFileChooser tiedostonValitsin = new JFileChooser();
        tiedostonValitsin.setDialogTitle("Tallenna tekstitiedosto");

        int userSelection = tiedostonValitsin.showSaveDialog(parentFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File bTiedosto;
            String polku = tiedostonValitsin.getSelectedFile().getAbsolutePath();
            bTiedosto = tiedostoTulostin.tulostaRahatilanneTiedostoon(polku, tulostin, r);
        }
    }

}
