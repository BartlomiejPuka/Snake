package com.Snake.com.Snake.entities;

import java.awt.*;

public class BodyPart {
    private int xCoor, yCoor, width, height;

    public BodyPart(int xCoor,int yCoor,int tileSize){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
        this.width = tileSize;
        this.height = tileSize;

    }

    public void tick(){

    }

    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillRect(xCoor * width,yCoor *height, width, height);
        g.setColor(Color.WHITE);
        g.fillRect(xCoor * width+2,yCoor *height+2, width-4, height-4);
    }
}
