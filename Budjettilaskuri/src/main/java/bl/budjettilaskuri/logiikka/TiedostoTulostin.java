package bl.budjettilaskuri.logiikka;

import bl.budjettilaskuri.budjetti.Rahatilanne;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * Luokka tulostaa halutut tiedot tiedostoon.
 */
public class TiedostoTulostin {

    /**
     * Metodi luo tiedoston, johon halutun rahatilanteen tiedot tulostetaan.
     *
     * @param polku Tiedoston haluttu polku (sijainti ja nimi) tallennusta
     * varten
     * @param tulostin Tulostin-luokan olio jonka metodilla muodostetaan
     * tiedostoon kirjoitettava teksti
     * @param rt Rahatilanne, jonka tiedot halutaan tulostaa
     *
     * @return File-tyyppinen muuttuja, johon kirjoitettu rahatilanne.
     */
    public File tulostaRahatilanneTiedostoon(String polku, Tulostin tulostin, Rahatilanne rt) {
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
