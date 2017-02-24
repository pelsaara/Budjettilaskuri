package bl.budjettilaskuri.gui;

import bl.budjettilaskuri.gui.kuuntelijat.BudjetinLaskuKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.MenonLisaysKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.TulonLisaysKuuntelija;
import bl.budjettilaskuri.budjetti.Rahatilanne;
import bl.budjettilaskuri.gui.kuuntelijat.BudjetinTulostusKuuntelija;
import bl.budjettilaskuri.logiikka.Tulostin;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoTekstiKentat());
        container.add(luoBudjettiValikko(), BorderLayout.SOUTH);
    }

    private JPanel luoTekstiKentat() {
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField seliteKentta = new JTextField();
        JTextField summaKentta = new JTextField();

        panel.add(new JLabel("Selite: "));
        panel.add(seliteKentta);
        panel.add(new JLabel("Summa: "));
        panel.add(summaKentta);
        JTextArea tulot = new JTextArea();
        JTextArea menot = new JTextArea();
        tulot.setEditable(false);
        menot.setEditable(false);
        JButton tulo = new JButton("Lisää tulo");
        tulo.addActionListener(new TulonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta, tulot, tulostin));

        JButton meno = new JButton("Lisää meno");
        meno.addActionListener(new MenonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta, menot, tulostin));

        panel.add(tulo);
        panel.add(meno);

        panel.add(tulot);
        panel.add(menot);

        return panel;
    }

//    private JPanel budjetinTulostusTiedostoon() {
//        JPanel panel = new JPanel(new GridLayout(1, 2));
//        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        JButton tulostusNappi = new JButton("Tulosta budjetti tiedostoon");
//        tulostusNappi.addActionListener(new BudjetinTulostusKuuntelija(this.tulostin, this.rahatilanne));
//        panel.add(tulostusNappi);
//        return panel;
//    }

    private JPanel luoBudjettiValikko() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton budjettiNappi = new JButton("Laske Budjetti");
        JTextArea tekstiKentta = new JTextArea();

        budjettiNappi.addActionListener(new BudjetinLaskuKuuntelija(this.rahatilanne, tekstiKentta, tulostin));

        panel.add(budjettiNappi);
        panel.add(tekstiKentta);
        JButton tulostusNappi = new JButton("Tulosta budjetti tiedostoon");
        tulostusNappi.addActionListener(new BudjetinTulostusKuuntelija(this.tulostin, this.rahatilanne));
        panel.add(tulostusNappi);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
