package de.reichel.paint;

import java.awt.*;

public class ViewToolPanel extends Panel{
    Button brushToolButton, polyToolButton, circleToolButton, rectToolButton;
    
    ViewToolPanel(View f){
        brushToolButton = new Button("Brush");
        rectToolButton = new Button("Rect");
        circleToolButton = new Button("Circle");
        polyToolButton = new Button("Poly");
        
        brushToolButton.addActionListener(new BrushToolController(f));
        rectToolButton.addActionListener(new RectToolController());
        
        this.setLayout(new GridLayout(4,1));
        this.add(brushToolButton);
        this.add(rectToolButton);
        this.add(circleToolButton);
        this.add(polyToolButton);
    }
}
