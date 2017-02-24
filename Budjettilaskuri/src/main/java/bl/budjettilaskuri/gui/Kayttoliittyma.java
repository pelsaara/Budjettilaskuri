package bl.budjettilaskuri.gui;

import bl.budjettilaskuri.gui.kuuntelijat.BudjetinLaskuKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.MenonLisaysKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.TulonLisaysKuuntelija;
import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.gui.kuuntelijat.BudjetinTulostusKuuntelija;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private final Rahatilanne rahatilanne;
    private final Tulostin tulostin;

    public Kayttoliittyma(Rahatilanne rahatilanne) {
        this.rahatilanne = rahatilanne;
        this.tulostin = new Tulostin();
    }

    @Override
    public void run() {
        frame = new JFrame("Budjettilaskuri");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoLaskuri(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoLaskuri(Container paneeli) {
        BoxLayout boxi = new BoxLayout(paneeli, BoxLayout.Y_AXIS);
        paneeli.setLayout(boxi);

        JPanel tuloMenoPaneeli = new JPanel(new GridLayout(4, 2));

        JTextField seliteKentta = new JTextField();

        JTextField summaKentta = new JTextField();

        JTextArea tulot = new JTextArea();
        tulot.setEditable(false);
        tulot.setVisible(true);
        JScrollPane scroll1 = new JScrollPane(tulot);

        JTextArea menot = new JTextArea(12, 1);
        menot.setEditable(false);
        menot.setVisible(true);
        JScrollPane scroll2 = new JScrollPane(menot);

        JButton tulo = new JButton("Lisää tulo");
        tulo.addActionListener(new TulonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta, tulot, tulostin));

        JButton meno = new JButton("Lisää meno");
        meno.addActionListener(new MenonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta, menot, tulostin));

        tuloMenoPaneeli.add(new JLabel("Selite: "));
        tuloMenoPaneeli.add(seliteKentta);
        tuloMenoPaneeli.add(new JLabel("Summa: "));
        tuloMenoPaneeli.add(summaKentta);
        tuloMenoPaneeli.add(tulo);
        tuloMenoPaneeli.add(meno);
        JPanel tulostusTekstiPaneeli = new JPanel(new GridLayout(1, 2));
        tulostusTekstiPaneeli.add(new JLabel("Tulot:"));
        tulostusTekstiPaneeli.add(new JLabel("Menot:"));
        JPanel tulostusPaneeli = new JPanel(new GridLayout(1, 2));

        tulostusPaneeli.add(scroll1);
        tulostusPaneeli.add(scroll2);

        JTextArea budjettiKentta = new JTextArea(1, 3);
        budjettiKentta.setEditable(false);
        budjettiKentta.setVisible(true);

        JPanel budjettiPaneeli = new JPanel(new GridLayout(1, 2));
        JButton budjettiNappi = new JButton("Laske Budjetti");
        budjettiNappi.addActionListener(new BudjetinLaskuKuuntelija(this.rahatilanne, budjettiKentta, tulostin));

        JButton tulostusNappi = new JButton("Tulosta budjetti tiedostoon");
        tulostusNappi.addActionListener(new BudjetinTulostusKuuntelija(this.tulostin, this.rahatilanne));
        budjettiPaneeli.add(budjettiNappi);
        budjettiPaneeli.add(tulostusNappi);

        paneeli.add(tuloMenoPaneeli);
        paneeli.add(tulostusTekstiPaneeli);
        paneeli.add(tulostusPaneeli);
        paneeli.add(budjettiPaneeli);
        paneeli.add(budjettiKentta);

    }

    public JFrame getFrame() {
        return frame;
    }
}
