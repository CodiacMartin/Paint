package de.reichel.paint;

import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameController implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Fenster geöffnet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Schließen des Fensters angefordert.");
        Window win = (Window) e.getSource();
        win.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Fenster Geschlossen");
        System.exit(0);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Fenster Iconisiert.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("Fenster Deiconisiert");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Fenster Activiert");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Fenster deaktivert");
    }
}
