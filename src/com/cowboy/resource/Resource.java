package com.cowboy.resource;

import com.cowboy.util.Animation;
//import com.cowboy.util.Animation;
import com.cowboy.util.Frame;

import java.awt.*;

/**
 * This class will handle loading all the images, animation and audios from the assets folder.
 */
public class Resource {
    public static final String IMAGES_FOLDER = "images/";
    public static final double FRAME_DURATION = .1f;
    
    public static Image welcome;

    /**
     * Method for loading all the assets.
     */
    public static void load(){
        //initialize all assets here
    	welcome = loadImage("welcome.png");
    }

    /**
     * Method for loading an image.
     *
     * @param fileName Image to be loaded
     * @return An image
     */
    public static Image loadImage(String fileName){
        Image image = Toolkit.getDefaultToolkit().getImage(IMAGES_FOLDER + fileName);
        return image;
    }

    /**
     * Method for loading an animation.
     *
     * @param fileName Starting file name of animation
     * @param numOfFrames Number of frames
     * @param fileExtension Type of file
     * @return An animation
     */
    public static Animation loadAnimation(String fileName, int numOfFrames, String fileExtension){
        Frame[] frames = new Frame[numOfFrames];
        Image image;

        for (int i = 0; i < numOfFrames; i++){
            image = loadImage(fileName + i + fileExtension);
            frames[i] = new Frame(image, FRAME_DURATION);
        }
        return new Animation(frames);
    }
}
