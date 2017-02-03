package bl.budjettilaskuri.gui;

import bl.budjettilaskuri.gui.kuuntelijat.BudjetinLaskuKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.MenonLisaysKuuntelija;
import bl.budjettilaskuri.gui.kuuntelijat.TulonLisaysKuuntelija;
import bl.budjettilaskuri.logiikka.Rahatilanne;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Rahatilanne rahatilanne;

    public Kayttoliittyma(Rahatilanne rahatilanne) {
        this.rahatilanne = rahatilanne;
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
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField seliteKentta = new JTextField();
        JTextField summaKentta = new JTextField();

        panel.add(new JLabel("Selite: "));
        panel.add(seliteKentta);
        panel.add(new JLabel("Summa: "));
        panel.add(summaKentta);

        JButton tulo = new JButton("Lisää tulo");
        tulo.addActionListener(new TulonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta));

        JButton meno = new JButton("Lisää meno");
        meno.addActionListener(new MenonLisaysKuuntelija(rahatilanne, seliteKentta, summaKentta));

        panel.add(tulo);
        panel.add(meno);

        return panel;
    }

    private JPanel luoBudjettiValikko() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton budjettiNappi = new JButton("Laske Budjetti");
        JTextArea tekstiKentta = new JTextArea();

        budjettiNappi.addActionListener(new BudjetinLaskuKuuntelija(this.rahatilanne, tekstiKentta));

        panel.add(budjettiNappi);
        panel.add(tekstiKentta);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
