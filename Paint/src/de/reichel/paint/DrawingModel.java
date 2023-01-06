package de.reichel.paint;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class DrawingModel {
    
    LinkedList<DrawingModel> Picture = new LinkedList<DrawingModel>();
    
    public void draw(Graphics2D g) {
        for(DrawingModel element: Picture) {
            element.draw(g);
        }
    }
    public void addElement(DrawingModel element) {
        Picture.add(element);
    }
    public boolean isempty() {
        return Picture.isEmpty();
    }
}
