package com.cowboy.resource;

import com.cowboy.util.Animation;
import com.cowboy.util.Frame;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * This class will handle loading all the images, animation and audios from the assets folder.
 */
public class Resource {
    public static final String IMAGES_FOLDER = "images/";
    public static final double FRAME_DURATION = 60;
    
    //for InitState
    public static Image background;
    public static Image backgroundGrass;
    public static Animation loadingAnimation;
    
    //for PlayState
    public static Image gameBackground;
    public static Image bgLayer1;
    public static Image bgLayer2;
    public static Image bgLayer3;
    
    public static Animation playerRun;
    public static Animation playerJump;
    public static Animation playerSlide;
    public static Animation playerDead;
    
    public static Image crate;


    /**
     * Method for loading all the assets.
     */
    public static void load(){
        //initialize all assets here
    	background = loadImage("Background.png");
    	backgroundGrass = loadImage("BackgroundGrass.png");
    	loadingAnimation = loadAnimation("LoadScreen_", 9, ".png");
    	
    	gameBackground = loadImage("gameBackground.png");
    	bgLayer1 = loadImage("bg_layer_1.png");
    	bgLayer2 = loadImage("bg_layer_2.png");
    	bgLayer3 = loadImage("bg_layer_3.png");
    	gameBackground = loadImage("gameBackground.png");
    	gameBackground = loadImage("gameBackground.png");
    	playerRun = loadAnimation("player_run_", 10, ".png");
    	playerJump = loadAnimation("player_jump_", 10, ".png");
    	playerSlide = loadAnimation("player_slide_", 10, ".png");
    	playerDead = loadAnimation("player_dead_", 10, ".png");
    	
    	crate = loadImage("Crate.png");
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
    public static int getHighScore() throws FileNotFoundException{
    	BufferedReader reader = new BufferedReader(new FileReader(new File("highscore.txt")));
    	int highscore = 0;
        try {
        	String line = reader.readLine();
        	highscore = Integer.parseInt(line.trim());
        	reader.close();
        } catch (IOException e) {
        }
        return highscore;
    }
    public static void saveHighScore(int currentScore) throws FileNotFoundException{
    	BufferedReader reader = new BufferedReader(new FileReader(new File("highscore.txt")));
    	int highscore = 0;
        try {
        	String line = reader.readLine();
        	highscore = Integer.parseInt(line.trim());
        	reader.close();
        } catch (IOException e) {
        }
        if(currentScore > highscore){
        	highscore = currentScore;
        }
        try {
        	BufferedWriter output = new BufferedWriter(new FileWriter(new File("highscore.txt")));
        	output.write(""+highscore);
        	output.close();
        } catch (IOException e) {
        }
    }
    public void playSound(String fileName) throws IOException{
    	try {
			InputStream input = new FileInputStream(fileName);
			AudioStream audio = new AudioStream(input);
			AudioPlayer.player.start(audio);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
