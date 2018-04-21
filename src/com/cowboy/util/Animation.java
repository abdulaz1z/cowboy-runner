package com.cowboy.util;

/**
 *This class resprent an animation.
 * @author  James Cho, modified by Donelys Familia.
 */
public class Animation {
    //collection of frames
    private Frame[] frames;
    //end times for each frames
    private double[] frameEndTimes;

    private int currentFrameIndex = 0;
    private double totalDuration = 0;
    private double currentTime = 0;

    /**
     * Constructor for animation class. This constructor is will count and compute the amount
     * time each frames has and its duration.
     * 
     * @param frames This constructor can accept any number of Frame objects.
     */
    public Animation(Frame... frames) {
        this.frames = frames;
        frameEndTimes = new double[frames.length];
        for (int i = 0; i < frames.length; i++) {
            Frame f = frames[i];
            totalDuration += f.getDuration();
            frameEndTimes[i] = totalDuration;
        }
    }

    /**
     * Method for updating this animation using the delta value from the game loop, so that the
     * animation’s currentTime variable increases every frame by the correct number of seconds.
     *
     * @param increment The number of seconds current time should increment by.
     */
    public synchronized void update(float increment) {
        currentTime += increment;
        if (currentTime > totalDuration) {
            //Reached end of animation. Start from beginning again.
            wrapAnimation();
        }
        //Updating current frame index to the right one based on the current time
        while (currentTime > frameEndTimes[currentFrameIndex]) {
            currentFrameIndex++;
        }
    }

    /**
     * Helper method to reset the animation.
     */
    private synchronized void wrapAnimation() {
        currentFrameIndex = 0;
        currentTime %= totalDuration;   //TODO: replace with if statements
    }

    /**
     * This method is going to draw the current frame on the screen
     *
     * @param g The Painter objects needed to draw (Like Graphics object).
     * @param x The x-coordinate for where the image should be drawn (top-left).
     * @param y The y-coordinate for where the image should be drawn (top-left).
     */
    public synchronized void render(Painter g, int x, int y) {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y);
    }

    /**
     * This method is goiing to draw the current frame on the screen
     *
     * @param g The Painter objects needed to draw (Like Graphics object).
     * @param x The x-coordinate for where the image should be drawn (top-left).
     * @param y The y-coordinate for where the image should be drawn (top-left).
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public synchronized void render(Painter g, int x, int y, int width, int height) {
        g.drawImage(frames[currentFrameIndex].getImage(), x, y, width, height);
    }
}