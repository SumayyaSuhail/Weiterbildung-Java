package de.uebung.wasmausmacht;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MausImHaus extends JFrame {

    private JButton klickMich = new JButton("Klick Mich");
    private JLabel uhrZeit = new JLabel("xx:xx:xx");
    private JButton schluss = new JButton("Schluss");
    private JLabel platz = new JLabel("Spater wird es spannend");
    private JLabel mausListener = new JLabel("Bewegung: ");
    private JLabel mausMotionListener = new JLabel("Bewegung: ");
    private JLabel mausWheelListener = new JLabel("Bewegung: ");

    public MausImHaus(){
        super("Schönes Fenster");
        setSize(350,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        add(klickMich);
        add(uhrZeit);
        add(schluss);
        add(platz);
        add(mausListener);
        add(mausMotionListener);
        add(mausWheelListener);

        verwendenInnerMausListener();
        verwendenLokaleMausListener();
        verwendenLambdaMausListener();
    }

    /**
     * Local Class that implements MouseWheelListener
     * displays how many times the mouse wheel was used.
     */
    private void verwendenLokaleMausListener() {
        class LokaleMausHandler implements MouseWheelListener {
            int moved = 1;
            @Override
            public void mouseWheelMoved(MouseWheelEvent event) {
                mausWheelListener.setText("Mouse Wheel Moved : " + moved++);
            }
        }
        addMouseWheelListener(new LokaleMausHandler());
    }

    private int moved = 0;
    /** Tried and Failed
     * Add attributes outside the method to invoke in lambda
     */
    private void verwendenLambdaMausListener(){
//        int moved = 0;
        addMouseWheelListener(event -> mausWheelListener.setText("Mouse Wheel Moved : " + moved++));
    }

    /**
     * Anonymous Class that implements MouseMotionListener
     * displays if the mouse was dragged or moved on the Components.
     */
    private void verwendenAnonymeMausListener() {
        addMouseMotionListener(new MouseMotionListener(){
            public void mouseDragged(MouseEvent event) {
                mausMotionListener.setText("Maus Dragged on Component " + event.getComponent().getClass().getSimpleName());
            }
            public void mouseMoved(MouseEvent event) {
                mausMotionListener.setText("Maus Moved on Component " + event.getComponent().getClass().getSimpleName());
            }
        });
    }

    /**
     * Inner class that implements MouseListener
     * displays if the mouse was Clicked, Pressed,Released, Entered or Exited the Components.
     */
    public class InnerMausHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent event) {
            bewegungZeigen("Clicked", event);
        }

        @Override
        public void mousePressed(MouseEvent event) {
            bewegungZeigen("Pressed", event);
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            bewegungZeigen("Released", event);
        }

        @Override
        public void mouseEntered(MouseEvent event) {
            bewegungZeigen("Entered", event);
        }

        @Override
        public void mouseExited(MouseEvent event) {
            bewegungZeigen("Exited", event);
        }

        private void bewegungZeigen(String text, MouseEvent event) {
            mausListener.setText("Maus " + text + "on Component " + event.getComponent().getClass().getSimpleName());
        }
    }

    /**
     * Method to add inner Class mouse Handler to mouselistener
     */
    public void verwendenInnerMausListener(){
        MouseListener meinHandler = new InnerMausHandler();
        addMouseListener(meinHandler);
    }
}
