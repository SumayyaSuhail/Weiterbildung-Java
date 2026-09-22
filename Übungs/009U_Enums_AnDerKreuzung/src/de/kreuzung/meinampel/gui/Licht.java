package de.kreuzung.meinampel.gui;

import javax.swing.*;
import java.awt.*;

public class Licht  extends JPanel {

    private final AmpelMitGUI ampel;

    public Licht(AmpelMitGUI ampel) {
        this.ampel = ampel;
        setOpaque(true);
        setBackground(new Color(240, 240, 240));
        setPreferredSize(new Dimension(220, 520));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        // Layout: Rand + Innenfläche
        int margin = Math.max(12, Math.min(w, h) / 18);
        int boxX = margin;
        int boxY = margin;
        int boxW = w - 2 * margin;
        int boxH = h - 2 * margin;

        // Gehäuse zeichnen (abgerundetes Rechteck)
        int arc = Math.max(20, Math.min(boxW, boxH) / 10);
        g2.setColor(new Color(35, 35, 35));
        g2.fillRoundRect(boxX, boxY, boxW, boxH, arc, arc);

        // Innenabstand im Gehäuse
        int innerPad = Math.max(14, boxW / 12);
        int innerX = boxX + innerPad;
        int innerY = boxY + innerPad;
        int innerW = boxW - 2 * innerPad;
        int innerH = boxH - 2 * innerPad;

        // Kreisgrößen: 3 Lampen mit gleichen Abständen
        int gap = Math.max(12, innerH / 20);
        int diameter = Math.min(innerW, (innerH - 2 * gap) / 3);

        int cx = innerX + (innerW - diameter) / 2;
        int y1 = innerY;
        int y2 = innerY + diameter + gap;
        int y3 = innerY + 2 * (diameter + gap);

        // Farben "aus"
        Color aus = new Color(60, 60, 60);
        Color rand = new Color(15, 15, 15);

        AmpelPhase z = ampel.getZustand();

        // Rot
        drawLamp(g2, cx, y1, diameter, z.isRotAn() ? Color.RED : aus, rand);
        // Gelb
        drawLamp(g2, cx, y2, diameter, z.isGelbAn() ? Color.YELLOW : aus, rand);
        // Grün
        drawLamp(g2, cx, y3, diameter, z.isGruenAn() ? Color.GREEN : aus, rand);
    }


    private void drawLamp(Graphics2D g2, int x, int y, int d, Color fill, Color border) {
        g2.setColor(fill);
        g2.fillOval(x, y, d, d);

        g2.setColor(border);
        g2.drawOval(x, y, d, d);

        // kleiner "Glanz" oben links (optional, bleibt schlicht)
        int shine = Math.max(6, d / 6);
        g2.setColor(new Color(255, 255, 255, 60));
        g2.fillOval(x + d / 6, y + d / 6, shine, shine);
    }
}

