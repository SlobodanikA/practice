package org.example;

import javax.swing.*;
import java.awt.*;

public class Vikno extends JFrame {
    private JLabel leb1;
    private JButton btnAddText;
    public Vikno(){
        setLayout(new FlowLayout());
        leb1 = new JLabel("");
        add(leb1);
        btnAddText = new JButton("Додати цей текст");
        add(btnAddText);
    }
}
