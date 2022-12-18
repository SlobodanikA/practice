package org.example;

import javax.swing.*;

public class OceanWindow {
    Vikno window;
    public OceanWindow(){
        window = new Vikno();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Мое окно");
        window.setSize(350,150);
        window.setVisible(true);
        window.setResizable(false);
    }
}
