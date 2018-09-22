package com.Snake.com.Snake.graphics;

import com.Snake.com.Snake.entities.BodyPart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JPanel implements Runnable {

    private static final int WIDTH = 600, HEIGHT = 600;
    private Thread thread;
    private boolean running = false;

    private BodyPart b;
    private ArrayList<BodyPart> snake;

    private int xCoor = 10, yCoor = 10;
    private int size = 5;
    private int ticks = 0;

    private boolean right = true, left = false, up = false, down = false;

    public Screen(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        snake = new ArrayList<BodyPart>();

        start();
    }

    public void tick(){
        if(snake.size() == 0){
            b = new BodyPart(xCoor,yCoor,10);
            snake.add(b);
        }

        ticks++;

        if(ticks > 250000){
            if(right) xCoor++;
            if(left) xCoor--;
            if(up) yCoor--;
            if(down) yCoor++;

            ticks = 0;

            b = new BodyPart(xCoor, yCoor, 10);
            snake.add(b);
        }
    }

    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);

        for(int i = 0; i < WIDTH/10; i++){
            g.drawLine(i*10,0,i*10, HEIGHT);
        }

        for(int i = 0; i < HEIGHT/10;i++){
            g.drawLine(0,i*10,WIDTH,i*10);
        }


        for(int i = 0; i < snake.size();i++){
            snake.get(i).draw(g);
        }
    }

    public void start(){
        running = true;
        thread = new Thread(this, "Game loop");
        thread.start();
    }

    public void stop(){

    }

    public void run(){
        while(running){
            tick();
            repaint();
        }

    }
}
