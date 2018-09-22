package com.Snake;

import com.Snake.com.Snake.graphics.Screen;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);

        init();
    }

    public void init(){
        setLayout(new GridLayout(1,1,0,0));

        Screen screen = new Screen();
        add(screen);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
