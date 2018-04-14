package com.cowboy.util;

import java.awt.*;

/**
 * This class represents a frame in an animation.
 *
 * @author Donelys Familia
 */
public class Frame {
    Image image;
    long duration;

    /**
     * Constructs a frame object.
     *
     * @param image Frame image
     * @param duration Duration of the image 
     */
    public Frame(Image image, long duration) {
        this.image = image;
        this.duration = duration;
    }
}

