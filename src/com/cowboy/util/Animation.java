package com.cowboy.util;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *  This class represent A collection of Frames, images and the amount of time they will be displayed
 *
 * @author Donelys Familia
 */
public class Animation {

     Image[] frame;
     int currentFrameIndex = 0;
     int delay;
     int totalDuration;

    /**
     *
     * @param file take the name of the file
     * @param count it takes the number of amount of files
     * @param totalDuration takes the duration it going to take each file
     */

    public Animation(String file, int count, int totalDuration){

        frame = new Image[count];

        for(int i =0; i < count; i++){
            frame[i] = Toolkit.getDefaultToolkit().getImage(file+i+".png")
        }

        this.totalDuration = totalDuration;
        delay =totalDuration;

    }

    /**
     *
     * @return this method is going to return the first frame in the array
     */
    public Image[] currentFrame() {
        return frame[0];

    }

    /**
     *
     * @return this method is going to return the nextframe.
     */

    public Image[] nextFrame() {
        if(delay == 0){
            currentFrameIndex ++;
            if ((currentFrameIndex == image.length){
                currentFrameIndex = 1;

            }
            delay = totalDuration;

        }else {
            delay --;
        }
        return frame[currentFrameIndex];
    }
}
