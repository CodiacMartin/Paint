package de.reichel.paint;

import java.awt.*;

public class ViewMenuBar extends MenuBar {
    ViewMenuBar(){
        Menu dateiMenu = new Menu("Datei");
        MenuItem newCanvas = new MenuItem("neues Bild");
        MenuItem erCanvas = new MenuItem("lösche Bild");
        dateiMenu.add(newCanvas);
        dateiMenu.add(erCanvas);
        add(dateiMenu);
        
    }
}
