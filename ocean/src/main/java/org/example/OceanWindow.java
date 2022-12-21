package org.example;

import javax.swing.*;

public class OceanWindow {
    public Vikno window;
    public OceanWindow(){
        window = new Vikno();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Мое окно");
        window.setSize(900,700);
        window.setVisible(true);
        window.setResizable(false);
    }
    public void OneIterationOutput(Ocean l){
        for (int row = 0; row < l.getNumRows(); row++) {
            for (int col = 0; col < l.getNumCols(); col++) {
                JLabel image = new JLabel(l.getCellImage(row,col));
                window.add(image);
            }
        }
    }
}
