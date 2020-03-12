package Sumo_mania;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        //create the window
        JFrame window = new JFrame();
        window.setTitle("Sumo Mania!");
        window.setSize(640, 480);
        window.setVisible(true);
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        //add the image to the window
        Sprite splashScreen = new Sprite();
        window.add(splashScreen);

    }
}
