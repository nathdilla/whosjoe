package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;


public class PlantInventory implements changePlants
{
    public ArrayList<Plant> plants = new ArrayList<Plant>();


    @Override
    public void addPlant(Plant newPlant)
    {
        plants.add(newPlant);
    }//end method addPlant

    @Override
    public void removePlant(Plant thisPlant)
    {
        plants.remove(thisPlant);
    }//end method removePlant
}//end class PlantInventory
