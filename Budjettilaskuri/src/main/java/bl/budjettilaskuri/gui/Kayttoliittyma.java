package bl.budjettilaskuri.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
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
        container.add(luoValikko(), BorderLayout.SOUTH);

        
    }

    private JPanel luoTekstiKentat() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Selite: "));
        panel.add(new JTextField());
        panel.add(new JLabel("Summa: "));
        panel.add(new JTextField());
        panel.add(new JButton("Lisää tulo"));
        panel.add(new JButton("Lisää meno"));
        return panel;
    }

    private JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JButton("Laske budjetti"));
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
