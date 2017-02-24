/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl.budjettilaskuri.logiikka;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author pelsaara
 */
public class TiedostoTulostin {

    public File tulostaTiedosto(String polku, Tulostin tulostin, Rahatilanne rt) {
        BufferedWriter kirjoitin = null;
        try {
            File tiedosto = new File(polku);

            if (!tiedosto.exists()) {
                tiedosto.createNewFile();
            }

            System.out.println(tiedosto.getCanonicalPath());

            kirjoitin = new BufferedWriter(new FileWriter(tiedosto));
            kirjoitin.write(tulostin.tulostaRahatilanne(rt));
            return tiedosto;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                kirjoitin.close();

            } catch (Exception e) {
            }
        }

        return null;
    }
}
