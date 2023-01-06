package de.reichel.paint;

import java.awt.*;

public class View extends Frame {
    ViewPaintCanvas workfield;
    Panel adjustments;
    
    public View() {
        // Frame Parameter
        setTitle(Constants.progName);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        // Panel for Tools
        ViewToolPanel toolsPanel = new ViewToolPanel(this);
        
        // Panel for Tool adjustments
        adjustments = new BrushAdjustment(this);
        
        // Create and Display Window
        setMenuBar(new ViewMenuBar());
        add(toolsPanel, BorderLayout.WEST);
        workfield = new ViewPaintCanvas();
        add(workfield, BorderLayout.CENTER);
        add(adjustments, BorderLayout.SOUTH);
        addWindowListener(new FrameController());
        setVisible(true);
    }
    
    public View getFrame() {
        return this;
    }
}
