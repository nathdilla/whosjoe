package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.Timer;
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
                Timer timer = new Timer();
                Timer.Task task = new Timer.Task() {
                    @Override
                    public void run() {
                         balance++;
                    }
                };
                timer.scheduleTask(task, 5, 60);
            final Timer happinessDeduct = new Timer();
            Timer.Task taskDeduct = new Timer.Task() {
                @Override
                public void run() {
                    if (balance < 0)
                    happiness = happiness + (1 * happiness);
                }
            };
            happinessDeduct.scheduleTask(taskDeduct, 0, Math.abs(happiness));
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