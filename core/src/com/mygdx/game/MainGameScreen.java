package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class MainGameScreen extends ApplicationAdapter implements Screen, InputProcessor {

    WhosJoeMain Game;
    //private SpriteBatch batch;
    private Texture idle;
    private Texture walkA = new Texture("JoeWalkA.png");
    private Texture walkB = new Texture("JoeWalkB.png");
    private Texture jump = new Texture("JoeJump.png");
    private Texture plantZero;
    public Texture hoeDisplay;
    public Texture waterDisplay;
    public Texture seedDisplay;
    private BitmapFont font;
    private CharSequence balanceDisplay = "BALANCE: ";
    private CharSequence happinessDisplay = "HAPPINESS: ";
    private CharSequence alertMessage = "";
    private Texture cursor;
    private boolean isWalkingLeft = true;

    public Sprite mySprite;
    public Sprite myPlant;
    public PlantInventory plantInventory;
    public String tool;
    public boolean hasTool;
    public boolean hasWater;
    public boolean hasSeed;
    public String seedType;
    public int balance;
    public int happiness;
    private int X;
    private int Y;
    private int alpha = 0;





    public MainGameScreen(WhosJoeMain Game)
    {
        this.Game = Game;
        //this.tool = Game.tool;
        this.hasWater = Game.hasWater;
        this.hasSeed = Game.hasSeed;
        this.seedType = Game.seedType;
        this.balance = Game.balance;
        this.happiness = Game.happiness;
        this.plantInventory = Game.plantInventory;
    }
    @Override
    public void show() {
        idle = new Texture("Joe.png");
               // batch = new SpriteBatch();
        //idle = new Texture("joe.png");
        //walkA = new Texture("joeWalkA.png");
        //walkB = new Texture("joeWalkB.png");
        plantZero = new Texture("littlePlant.png");
        mySprite = new Sprite(idle, idle.getWidth(), idle.getHeight());
        myPlant = new Sprite(plantZero, plantZero.getWidth()/2, plantZero.getHeight()/2);

        hoeDisplay = new Texture("hoe.png");
        waterDisplay = new Texture("water.png");
        seedDisplay = new Texture("seedRose.png");

        cursor = new Texture("water.png");

        font = new BitmapFont();
        font.setColor(Color.BLACK);

        //plantInventory = new PlantInventory();

        Gdx.input.setInputProcessor(this);

        mySprite.setPosition(0,0);
    }

    @Override
    public void render(float delta) {
        //this.render();
        Gdx.gl.glClearColor(1,1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Game.batch.begin();
        Game.batch.draw(mySprite, X,Y);

        font.getData().setScale(1);
        font.draw(Game.batch, balanceDisplay + "" + Game.balance, 30, 30);
        font.draw(Game.batch, happinessDisplay + "" + Game.happiness, 200, 30);

        font.getData().setScale(2);
        font.draw(Game.batch, alertMessage, 0, Gdx.graphics.getHeight()/2);

        Game.batch.draw(cursor, Gdx.input.getX() - 30, Math.abs(((Gdx.input.getY() * -1) + 490)), 20, 20);

        if(Game.hasTool == true) {
            Game.batch.draw(hoeDisplay, 400, 10, 30, 30);
        }
        if(Game.hasWater == true) {
            Game.batch.draw(waterDisplay, 450, 10, 30, 30);
        }
        if(Game.hasSeed == true) {
            seedDisplay = new Texture("seed" + Game.seedType.substring(0,1).toUpperCase() + Game.seedType.substring(1) + ".png");
            Game.batch.draw(seedDisplay, 505, 10, 30, 30);
        }

        for (int i = 0; i < plantInventory.plants.size(); i++)
        {
            Game.batch.draw(plantInventory.plants.get(i).getTexture(),plantInventory.plants.get(i).Position.length, plantInventory.plants.get(i).Position[0].length);
        }
        Game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }




    @Override
    public void dispose () {
        Game.batch.dispose();
        idle.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("Char Position: " + X +" " + Y);
        if (keycode == Input.Keys.LEFT)
        {
            X-=10;
            mySprite.setX(X);
            if (isWalkingLeft == true)
            {
                isWalkingLeft = false;
                mySprite.setTexture(walkA);
            }
            else
            {
                isWalkingLeft = true;
                mySprite.setTexture(walkB);
            }
        }
        if ((keycode == Input.Keys.RIGHT))
        {
            X+=10;
            mySprite.setX(X);
            if (isWalkingLeft == true)
            {
                isWalkingLeft = false;
                mySprite.setTexture(walkA);
            }
            else
            {
                isWalkingLeft = true;
                mySprite.setTexture(walkB);
            }
        }
        if ((keycode == Input.Keys.DOWN))
        {

            Y-=10;
            mySprite.setY(Y);
            if (isWalkingLeft == true)
            {
                isWalkingLeft = false;
                mySprite.setTexture(walkA);
            }
            else
            {
                isWalkingLeft = true;
                mySprite.setTexture(walkB);
            }
        }
        if ((keycode == Input.Keys.UP))
        {
            Y+=10;
            mySprite.setY(Y);
            if (isWalkingLeft == true)
            {
                isWalkingLeft = false;
                mySprite.setTexture(walkA);
            }
            else
            {
                isWalkingLeft = true;
                mySprite.setTexture(walkB);
            }
        }
        if ((keycode == Input.Keys.SPACE))
        {
            mySprite.setTexture(jump);
            Timer JumpTimer = new Timer();
            Timer.Task JumpTask = new Timer.Task() {
                @Override
                public void run() {
                    mySprite.setTexture(idle);
                }
            };
            JumpTimer.scheduleTask(JumpTask, 1);
            if (mySprite.getX() > 50 && mySprite.getY() > 100) {
                if (plantInventory.plants.size() < 10) {
                    if(Game.hasSeed == true && Game.hasTool == true) {
                        Game.hasSeed = false;
                        Game.hasTool = false;
                        float[][] Position = new float[(int) mySprite.getX()][(int) mySprite.getY() - 100];
                        plantZero = new Texture("littlePlant.png");
                        Sprite createPlant = new Sprite(plantZero, plantZero.getWidth() / 2, plantZero.getHeight() / 2);
                        createPlant.setPosition(Position.length, Position[0].length);
                        System.out.println("New Plant Created at: " + Position.length + " " + Position[0].length);
                        Plant newPlant = new Plant(Game.seedType, 0, 100, createPlant, plantZero, Position);
                        plantInventory.addPlant(newPlant);
                    }
                    else
                    {
                        alertMessage = "You ran out of seed and hoe.";
                        Timer timer = new Timer();
                        Timer.Task task = new Timer.Task() {
                            @Override
                            public void run() {
                                alertMessage = "";
                            }
                        };
                        timer.scheduleTask(task, 2);
                    }
                }
            }
            else
            {
                alertMessage = "You can't plant here.";
                Timer timer = new Timer();
                Timer.Task task = new Timer.Task() {
                    @Override
                    public void run() {
                        alertMessage = "";
                    }
                };
                timer.scheduleTask(task, 2);
            }
        }
        if ((keycode == Input.Keys.Z))
        {
            tool = "water";
        }
        if ((keycode == Input.Keys.X))
        {
            Game.openShop();
        }
        return false;
    }

    public boolean getHasSeed()
    {
        return hasSeed;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("Mouse: " + screenX + "," + Math.abs(((screenY * -1) + 460)));
        Sprite object = click(new float[screenX][Math.abs(((screenY * -1) + 460))]);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public PlantInventory getPlantInventory() {
        return plantInventory;
    }
    private Sprite click(float[][] mousePos)
    {
        int rangeX = 100;
        int rangeY = 100;
        if (Game.hasWater == true) {
            int comparedX;
            int comparedY;
            int distance;
            for (Plant plant : plantInventory.plants) {
                comparedX = (int) (plant.Position.length + 40);
                comparedY = (int) (plant.Position[0].length + 30);
                //System.out.println("checking for plant " + i);
                System.out.println("Checking..: " + comparedX + " " + comparedY);

                // if(mousePos[0].length - 200 < comparedY && comparedY < mousePos[0].length + 200)
                // {
                // System.out.println("object detected");
                // return plantInventory.plants.get(i).sprite;
                // }
                distance = ((int) Math.sqrt(Math.pow(mousePos[0].length - comparedY, 2) + Math.pow(mousePos.length - comparedX, 2)));
                System.out.println("distance: " + distance);
                if (distance < 50) {
                    System.out.println("object detected " + distance);

                        Game.hasWater = false;
                        plant.age(5);

                    return plant.sprite;
                }
            }
        }
        else
        {
            alertMessage = "You ran out of water.";
            Timer timer = new Timer();
            Timer.Task task = new Timer.Task() {
                @Override
                public void run() {
                    alertMessage = "";
                }
            };
            timer.scheduleTask(task, 2);
        }
        return null;
    }
}