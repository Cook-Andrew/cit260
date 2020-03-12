package Sumo_mania;

import javax.swing.*;
import java.awt.*;

public class Sprite extends JPanel {
    //variables
    private String fileName = "src/Sumo_mania/splash.png";
    private int x = 0;
    private int y = 0;

    //constructors
    Sprite(){}
    Sprite(String newFileName, int newX, int newY){
        fileName = newFileName;
        x = newX;
        y = newY;
    }

    //methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon splash = new ImageIcon(fileName);
        splash.paintIcon(this, g, x, y);
    }
}
