package de.reichel.paint;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Field;

public class BrushToolController implements ActionListener, MouseListener, MouseMotionListener, ItemListener {
    View Fenster;
    Point newPoint = new Point(0,0);
    Line currentLine;
    BrushAdjustment Parameter;
    Color Farbe = Color.WHITE;
    float staerke = 5.5f;
    
    BrushToolController(View f){
        Fenster = f;
        Parameter = new BrushAdjustment(Fenster);
        Parameter.colorChoice.setBackground(Color.WHITE);
        Parameter.colorChoice.addItemListener(this);
        Parameter.lineWidth.setText(Float.toString(staerke));
        Parameter.lineWidth.addActionListener(this);
        Parameter.setVisible(false);
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(newPoint.distance(e.getX(),e.getY())>1) {
            newPoint.setLocation(e.getX(),e.getY());
            currentLine.addPoint(newPoint.x,newPoint.y);
            Fenster.workfield.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        newPoint = new Point(e.getX(),e.getY());
        currentLine = new Line(newPoint, Farbe, staerke);
        Fenster.workfield.Picture.addElement(currentLine);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()=="Brush") {
            for(MouseListener i : Fenster.workfield.getMouseListeners())
                Fenster.workfield.removeMouseListener(i);
            for(MouseMotionListener i : Fenster.workfield.getMouseMotionListeners())
                Fenster.workfield.removeMouseMotionListener(i);
            System.out.println("Der Pinsel wurde ausgewählt.");
            Fenster.workfield.addMouseListener(this);
            Fenster.workfield.addMouseMotionListener(this);
            Fenster.remove(Fenster.adjustments);
            Fenster.adjustments=Parameter;
            Fenster.add(Parameter, BorderLayout.SOUTH);
            Parameter.setVisible(true);
            Fenster.pack();
        }else if(e.getSource()==Parameter.lineWidth) {
            staerke = Float.valueOf(Parameter.lineWidth.getText());
            System.out.println("Linienstärke geändert auf: "+Parameter.lineWidth.getText());
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource().getClass().getName().contains("java.awt.Choice")) {
            Choice choice = (Choice)e.getSource();
            try {
                Field field = Class.forName("java.awt.Color").getField(choice.getSelectedItem());
                Color color = (Color)field.get(null);
                choice.setBackground(color);
                Farbe=color;
            } catch (Exception ex) {
                Farbe = Color.WHITE; // Not defined
                System.out.println(ex.getMessage());
            }
        }
        
    }
}
