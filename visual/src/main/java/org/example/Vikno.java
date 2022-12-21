package org.example;

import javax.swing.*;
import java.awt.*;

public class Vikno extends JFrame {
    public JLabel leb1;
    public JTextField text1;

    public Vikno(){
        setLayout(new FlowLayout());
        leb1 = new JLabel("AZAZA");
        text1 = new JTextField();
        text1.setBorder(BorderFactory.createEmptyBorder());
        text1.setColumns(70);
        add(leb1);

    }
    public void setLeb1(String word){
        String actualText = "SOSY";
        leb1.setText(actualText);
        this.add(leb1);
    }
}
