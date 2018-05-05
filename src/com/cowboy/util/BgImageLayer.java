package com.cowboy.util;

import java.awt.*;

/**
 * This class represents a background image layer.
 *
 * @author Abdul Aziz
 */
public class BgImageLayer {
    Image image;
    int x;
    int y;

    /**
     * Constructs a BgImageLayer object.
     *
     * @param image The image to be used for this layer
     * @param x The x-coordinates where it to should be drawn
     * @param y The y-coordinates where it to should be drawn
     * @param z The distance of the image
     */
    public BgImageLayer(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    /**
     * Method for updating the layer.
     */
    public void update(int speed){
        x -= speed;
        if(x <= -1000) {
        	x += 3000;
        }
    }

    /**
     * Method for drawing the layer.
     *
     * @param g The Graphics objects needed to draw
     */
    public void draw(Graphics g) {
    	g.drawImage(image, x, y, null);
    }
}