package de.reichel.paint;

import java.awt.*;

public class ViewPaintCanvas extends Canvas{
    Point lastPoint = new Point(0,0);
    Point newPoint = new Point(0,0);
    Graphics2D graph2d;
    DrawingModel Picture = new DrawingModel();
    
    ViewPaintCanvas(){
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        graph2d = (Graphics2D) g;
        //graph2d.setColor(Color.black);
        //graph2d.fillRect(0, 0, getWidth(), getHeight());
        graph2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if(!Picture.isempty()){
            Picture.draw(graph2d);
        }
        graph2d.setColor(Color.white);
    }
}
