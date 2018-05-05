package com.cowboy.util;

import java.awt.Graphics;
import java.awt.Image;

import com.cowboy.resource.Resource;

public class Background {
    private static final int NUM_LAYERS = 3;
    private static final int THIRD_LAYER_SPEED = 2;
    private static final int SECOND_LAYER_SPEED = 6;
    private static final int FIRST_LAYER_SPEED = 4;
    private static final int GRASS_LAYER_SPEED = 4;

    private static BgImageLayer[] bgFirstLayers;
    private static BgImageLayer[] bgSecondLayers;
    private static BgImageLayer[] bgThirdLayers;
    
    private static BgImageLayer[] bgGrassLayers;

    /**
     * Construct a background object.
     */
    public Background() {
        bgFirstLayers = new BgImageLayer[NUM_LAYERS];
        bgSecondLayers = new BgImageLayer[NUM_LAYERS];
        bgThirdLayers = new BgImageLayer[NUM_LAYERS];
        bgGrassLayers = new BgImageLayer[NUM_LAYERS];

        for (int i = 0; i < NUM_LAYERS; i++){
        	bgThirdLayers[i] = new BgImageLayer(Resource.bgLayer3, i * 1000, 0);
            bgSecondLayers[i] = new BgImageLayer(Resource.bgLayer2, i * 1000, 0);
            bgFirstLayers[i] = new BgImageLayer(Resource.bgLayer1, i * 1000, 0);
            bgGrassLayers[i] = new BgImageLayer(Resource.backgroundGrass, i * 1000, 0);
        }
    }

    public void update(){
    	for (int i = 0; i < NUM_LAYERS; i++){
    		bgThirdLayers[i].update(THIRD_LAYER_SPEED);
            bgSecondLayers[i].update(SECOND_LAYER_SPEED);
            bgFirstLayers[i].update(FIRST_LAYER_SPEED);
            bgGrassLayers[i].update(GRASS_LAYER_SPEED);
        }
    }

    public void draw(Graphics g){
		g.drawImage(Resource.gameBackground, 0, 0, null);

        for (int i = 0; i < NUM_LAYERS; i++){
            bgThirdLayers[i].draw(g);
        }
        
        for (int i = 0; i < NUM_LAYERS; i++){
            bgFirstLayers[i].draw(g);
        }

        for (int i = 0; i < NUM_LAYERS; i++){
            bgSecondLayers[i].draw(g);
        }
        
        for (int i = 0; i < NUM_LAYERS; i++){
        	bgGrassLayers[i].draw(g);
        }

    }
}