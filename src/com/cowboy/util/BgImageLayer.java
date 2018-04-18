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
    int z;

    //TODO: #22 - Update the background layer speed
    public static int LAYER_SPEED = 10;

    /**
     * Constructs a BgImageLayer object.
     *
     * @param image The image to be used for this layer
     * @param x The x-coordinates where it to should be drawn
     * @param y The y-coordinates where it to should be drawn
     * @param z The distance of the image
     */
    public BgImageLayer(Image image, int x, int y, int z) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Method for updating the layer.
     */
    public void update(){
        x -= LAYER_SPEED;
    }

    /**
     * Method for drawing the layer.
     *
     * @param g The Graphics objects needed to draw
     */
    public void draw(Graphics g) {
        //TODO: #23 - Draw only background layer that user sees
        for(int i = 0; i < 10; i++){
            g.drawImage(image, x/z + 720*i, y, null);
        }
    }
}