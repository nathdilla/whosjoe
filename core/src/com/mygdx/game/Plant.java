package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import javafx.geometry.Pos;

import javax.swing.text.Position;
import java.util.ArrayList;


public class Plant
{
    private String type;
    private int age;
    private int hydration;
    public Sprite sprite;
    public Texture texture;
    public ArrayList<Plant> plants = new ArrayList<Plant>();
    public float[][] Position;
    private boolean isAgeing;
    private int numberOfPlants;

    public Plant(String type, int age, int hydration, Sprite sprite, Texture currentTexture, float[][] Position, final WhosJoeMain game)
    {
        this.age = age;
        this.type = type;
        this.hydration = hydration;
        this.sprite = sprite;
        this.texture = currentTexture;
        this.Position = Position;
        //plants.add();

        numberOfPlants++;

        Timer timer = new Timer();
        Timer.Task task = new Timer.Task() {
            @Override
            public void run() {
                game.happiness++;
            }
        };
        timer.scheduleTask(task, 0, 30 / numberOfPlants);
    }//end constructor method Plant
    public Texture nextFace()
    {
        if (age < 2)
        {
            age++;
            this.texture = new Texture((type + (age + 1)) + ".png");
            isAgeing = false;
        }//end if age is less than 2
            return texture;

    }//end method nextFace
    public Sprite getSprite(Sprite sprite)
    {
        return sprite;
    }//end method getSprite
    public float[][] getPosition()
    {
        return Position;
    }//end method getPosition

    public Texture getTexture()
    {
        return texture;
    }//end method getTexture
    public void updatePosition(int x,int y, int incrementX, int incrementY)
    {
        float[][] Position = new float[x + incrementX][y+ incrementY];
        this.Position = Position;
    }//end method updatePosition
    public void age(int wait)
    {
        if(isAgeing == false)
        {
            isAgeing = true;
            Timer timer = new Timer();
            Task task = new Task()
            {
                @Override
                public void run()
                {
                    System.out.println("age");
                    nextFace();
                    System.out.println("new age " + age);
                }//end method run
            };//end task initialization
            timer.scheduleTask(task, wait);
        }//end if isAgeing is false
    }//end method age
}//end class Plant
