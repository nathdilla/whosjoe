package com.mygdx.game;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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

    public Plant(String type, int age, int hydration, Sprite sprite, Texture currentTexture, float[][] Position)
    {
        this.age = age;
        this.type = type;
        this.hydration = hydration;
        this.sprite = sprite;
        this.texture = currentTexture;
        this.Position = Position;
        //plants.add();
    }
    public Texture nextFace(int age)
    {
        return new Texture("littlePlant");
    }
    public Sprite getSprite(Sprite sprite)
    {
        return sprite;
    }
    public float[][] getPosition()
    {
        return Position;
    }

    public Texture getTexture() {
        return texture;
    }
    public void updatePosition(int x,int y, int incrementX, int incrementY)
    {
        float[][] Position = new float[x + incrementX][y+ incrementY];
        this.Position = Position;
    }
}
