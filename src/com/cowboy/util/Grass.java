package com.cowboy.util;

import java.awt.Graphics;

import com.cowboy.resource.Resource;

public class Grass {
    private static final int NUM_LAYERS = 3;
    private static final int GRASS_LAYER_SPEED = 3;
    
    private static BgImageLayer[] bgGrassLayers;

    /**
     * Construct a background object.
     */
    public Grass() {
        bgGrassLayers = new BgImageLayer[NUM_LAYERS];

        for (int i = 0; i < NUM_LAYERS; i++){
            bgGrassLayers[i] = new BgImageLayer(Resource.backgroundGrass, i * 1000, 0);
        }
    }

    public void update(){
    	for (int i = 0; i < NUM_LAYERS; i++){
            bgGrassLayers[i].update(GRASS_LAYER_SPEED);
        }
    }

    public void draw(Graphics g){
        for (int i = 0; i < NUM_LAYERS; i++){
        	bgGrassLayers[i].draw(g);
        }

    }
}