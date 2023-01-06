package de.reichel.paint;

public class Main {
    
    public static void main (String[] args) {
        try {
            CreateAndShowGUI();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void CreateAndShowGUI() throws Exception{
        new View();
    }
}
