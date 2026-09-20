package de.kommandozentrale.strategiespiel;

import javax.swing.*;
import java.awt.*;

/**
 * Erstellt die Benutzeroberfläche für ein neues Strategiespiel
 */
public class ErstesFenster extends JFrame {

    private JLabel oben = erstelleLabel("KOMMANDOZENTRALE");
    private JLabel links = erstelleLabel("EINHEITEN");
    private JLabel inDerMitte = erstelleLabel("KARTE");
    private JLabel unten = erstelleLabel("Ausgewählte Einheit");
    private JLabel rechts = erstelleLabel("BEFEHLE");

    private JPanel rechtsPanel = erstelleBefehlsPanel();


    public ErstesFenster(){
        super("KOMMANDOZENTRALE");
        setSize(800,600);
        setMinimumSize(new Dimension(600,500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(1,1));
        links.setPreferredSize(new Dimension(120, 0));
        rechts.setPreferredSize(new Dimension(0,30));

        oben.setPreferredSize(new Dimension(0, 40));
        oben.setFont(new Font("Arial", Font.BOLD, 22));

        unten.setPreferredSize(new Dimension(0, 20));

        add(oben, BorderLayout.PAGE_START);
        add(links, BorderLayout.LINE_START);
        add(rechtsPanel, BorderLayout.LINE_END);
        add(inDerMitte, BorderLayout.CENTER);
        add(unten, BorderLayout.PAGE_END);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
    }

    /**
     * Formats Label
     * @return Jlabel
     */
    public JLabel erstelleLabel(String text){
        JLabel label = new JLabel(text, SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);
        label.setOpaque(true);
        label.setForeground(Color.LIGHT_GRAY);
        label.setBackground(new Color(45,55,65));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setFont(new Font("Arial", Font.BOLD, 13));
        return label;
    }

    /**
     * Formats panel of Befehle
     * @return JPanel after formatting
     */
    private JPanel erstelleBefehlsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(45, 55, 65));
        panel.add(rechts, BorderLayout.PAGE_START);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));// 4 rows, 1 column
        buttonPanel.setBackground(Color.decode("#5A5A5A"));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JButton bewegen = erstelleButtons("Bewegen");
        JButton erkunden = erstelleButtons("Erkunden");
        JButton bauen = erstelleButtons("Bauen");
        JButton warten = erstelleButtons("Warten");

        buttonPanel.add(bewegen);
        buttonPanel.add(erkunden);
        buttonPanel.add(bauen);
        buttonPanel.add(warten);

        panel.add(buttonPanel, BorderLayout.CENTER); // buttons go in the middle

        return panel;
    }

    /**
     * Formats Button
     * @param text name of the Button
     * @return JButton after formatting
     */
    private JButton erstelleButtons(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.LIGHT_GRAY);
        button.setForeground(new Color(45,55,65));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        return button;
    }
}
