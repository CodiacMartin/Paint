package de.reichel.paint;

import java.util.LinkedList;
import java.awt.*;
import java.util.Iterator;

public class Line extends DrawingModel {
LinkedList<Point> currentLine;
Color Farbe;
float staerke;

public Line(Point p,Color c,float s) {
	Farbe = c;
	staerke = s;
	currentLine = new LinkedList<Point>();
	currentLine.add(p.getLocation());
}
public void addPoint(int x, int y) {
    currentLine.add(new Point(x,y));
}
@Override
public void draw(Graphics2D g) {
	Point first;
	g.setColor(Farbe);
	g.setStroke(new BasicStroke(staerke));
	Iterator<Point> IterLine = currentLine.iterator();
	if(IterLine.hasNext())
		first = IterLine.next().getLocation();
	else
		first = new Point(0,0);
	
	while(IterLine.hasNext()) {
		Point second = IterLine.next();
		g.drawLine(first.x, first.y, second.x, second.y);
		first = second.getLocation();
	};
	
}

}
