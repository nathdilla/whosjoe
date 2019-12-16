package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.MainGameScreen;

//Let the class extend from game
public class WhosJoeMain extends Game {
        //Delete everything in it and leave a create() with a single line
    public SpriteBatch batch;
    //public String tool = "hoe";
    public boolean hasTool = true;
    public boolean hasWater = true;
    public boolean hasSeed = true;
    public String seedType = "rose";
    public int balance = 5;
    public int happiness;

    public PlantInventory plantInventory = new PlantInventory();

    private MainGameScreen gameScreen;
    private ShopScreen shopScreen;
        @Override
        public void create()
        {
            batch = new SpriteBatch();
            gameScreen = new MainGameScreen(this);
            shopScreen = new ShopScreen(this);
            this.setScreen(gameScreen);
        }
        public void openShop()
        {
            this.setScreen(shopScreen);
        }
        public void closeShop()
        {
            this.setScreen(gameScreen);
        }
@Override
    public void render()
    {
        super.render();
    }
}