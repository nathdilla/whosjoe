package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.Timer;

//Let the class extend from game
public class WhosJoeMain extends Game
{
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
    private TitleScreen titleScreen;
    private GameOverScreen endScreen;
    public Sound sound;
        @Override
        public void create()
        {
            batch = new SpriteBatch();
            //sound = Gdx.audio.newSound(FileHandle.tempFile("walking.wav"));
            //long id = sound.play();
            titleScreen = new TitleScreen(this);
            this.setScreen(titleScreen);

        }//end method create

        public void startGame()
        {
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
            Timer.Task taskDeduct = new Timer.Task()
            {
                @Override
                public void run()
                {
                    if (balance < 0)
                    {
                        happiness--;
                        if (happiness < -10)
                        {
                            endGame();
                        }//end if check happines
                    }//end if check balance
                }//end method run
            };//end initialization
            happinessDeduct.scheduleTask(taskDeduct, 0, 1 + Math.abs(happiness));
        }//end method start game

        public void endGame()
        {
            endScreen = new GameOverScreen(this);
            this.setScreen(endScreen);

            Timer timer = new Timer();
            Timer.Task task = new Timer.Task() {
                @Override
                public void run() {
                    Gdx.app.exit();
                }
            };
            timer.scheduleTask(task,5);
        }//end method endGame

        public void openShop()
        {
            this.setScreen(shopScreen);
        }//end method openShop
        public void closeShop()
        {
            this.setScreen(gameScreen);
        }//end method closeShop
@Override
    public void render()
    {
        super.render();
    }//end method render
}//end class WhosJoeMain