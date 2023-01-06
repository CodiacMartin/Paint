package de.reichel.paint;

import java.awt.*;

public class BrushAdjustment extends Panel {
    Choice colorChoice;
    Label lineWidthLabel = new Label("Linien stärke:");
    TextField lineWidth;
    
    BrushAdjustment(View f){
        colorChoice = new Choice();
        for(String s : Constants.Colors) {
            colorChoice.add(s);
        }
        lineWidth = new TextField("10.3");
        
        add(colorChoice);
        add(lineWidthLabel);
        add(lineWidth);
    }
};
