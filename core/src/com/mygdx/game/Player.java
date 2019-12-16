//package com.mygdx.game;
//
//import com.badlogic.gdx.*;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.Sprite;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//
//public class Player extends ApplicationAdapter implements InputProcessor {
//    private SpriteBatch batch;
//    private Texture idle;
//    private Texture walkA;
//    private Texture walkB;
//    private Texture plantZero;
//    public Sprite mySprite;
//    public Sprite myPlant;
//    public PlantInventory plantInventory;
//    public String tool = "water";
//    public boolean hasTool = true;
//    public boolean hasWater = true;
//    private int X;
//    private int Y;
//    private int alpha = 0;
//
//    @Override
//    public void create () {
//        batch = new SpriteBatch();
//        idle = new Texture("joe.png");
//        //walkA = new Texture("joeWalkA.png");
//        //walkB = new Texture("joeWalkB.png");
//        plantZero = new Texture("littlePlant.png");
//        mySprite = new Sprite(idle, idle.getWidth(), idle.getHeight());
//        myPlant = new Sprite(plantZero, plantZero.getWidth()/2, plantZero.getHeight()/2);
//
//        plantInventory = new PlantInventory();
//
//        Gdx.input.setInputProcessor(this);
//
//        mySprite.setPosition(0,0);
//
//    }
//
//    @Override
//    public void render () {
//
//
//        Gdx.gl.glClearColor(1,1,1, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(mySprite, X, Y);
//
//        for (int i = 0; i < plantInventory.plants.size(); i++)
//        {
//            batch.draw(plantInventory.plants.get(i).getTexture(),plantInventory.plants.get(i).Position.length, plantInventory.plants.get(i).Position[0].length);
//        }
//        batch.end();
//    }
//
//    @Override
//    public void dispose () {
//        batch.dispose();
//        idle.dispose();
//    }
//
//    @Override
//    public boolean keyDown(int keycode) {
//        System.out.println("Char Position: " + X +" " + Y);
//        if (keycode == Input.Keys.LEFT)
//        {
//            X-=10;
//            mySprite.setX(X);
//        }
//        if ((keycode == Input.Keys.RIGHT))
//        {
//            X+=10;
//            mySprite.setX(X);
//        }
//        if ((keycode == Input.Keys.DOWN))
//        {
//
//            Y-=10;
//            mySprite.setY(Y);
//        }
//        if ((keycode == Input.Keys.UP))
//        {
//            Y+=10;
//            mySprite.setY(Y);
//        }
//        if ((keycode == Input.Keys.SPACE))
//        {
//            if (mySprite.getX() > 50 && mySprite.getY() > 100) {
//                if (plantInventory.plants.size() < 10) {
//                    float[][] Position = new float[(int) mySprite.getX() - 50][(int) mySprite.getY() - 100];
//                    plantZero = new Texture("littlePlant.png");
//                    Sprite createPlant = new Sprite(plantZero, plantZero.getWidth() / 2, plantZero.getHeight() / 2);
//                    createPlant.setPosition(Position.length, Position[0].length);
//                    System.out.println("New Plant Created at: " + Position.length + " " + Position[0].length);
//                    Plant newPlant = new Plant("rose", 0, 100, createPlant, plantZero, Position);
//                    plantInventory.addPlant(newPlant);
//                }
//            }
//        }
//        if ((keycode == Input.Keys.Z))
//        {
//            tool = "water";
//        }
//        if ((keycode == Input.Keys.X))
//        {
//            tool = "hoe";
//        }
//        if ((keycode == Input.Keys.C))
//        {
//            tool = "shop";
//        }
//        return false;
//    }
//
//    @Override
//    public boolean keyUp(int keycode) {
//        return false;
//    }
//
//    @Override
//    public boolean keyTyped(char character) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        System.out.println("Mouse: " + screenX + "," + Math.abs(((screenY * -1) + 460)));
//        Sprite object = click(new float[screenX][Math.abs(((screenY * -1) + 460))]);
//        if(object != null)
//        {
//            object.setAlpha(0);
//        }
//        return false;
//    }
//
//    @Override
//    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
//        return false;
//    }
//
//    @Override
//    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        return false;
//    }
//
//    @Override
//    public boolean mouseMoved(int screenX, int screenY) {
//        return false;
//    }
//
//    @Override
//    public boolean scrolled(int amount) {
//        return false;
//    }
//
//    public PlantInventory getPlantInventory() {
//        return plantInventory;
//    }
//    private Sprite click(float[][] mousePos)
//    {
//        int rangeX = 100;
//        int rangeY = 100;
//        if (tool == "hoe" || tool == "water") {
//            int comparedX;
//            int comparedY;
//            int distance;
//            for (int i = 0; i < plantInventory.plants.size(); i++) {
//                comparedX = (int) (plantInventory.plants.get(i).Position.length + 80);
//                comparedY = (int) (plantInventory.plants.get(i).Position[0].length + 30);
//                //System.out.println("checking for plant " + i);
//                System.out.println("Checking..: " + comparedX + " " + comparedY);
//
//                // if(mousePos[0].length - 200 < comparedY && comparedY < mousePos[0].length + 200)
//                // {
//                // System.out.println("object detected");
//                // return plantInventory.plants.get(i).sprite;
//                // }
//                distance = ((int) Math.sqrt(Math.pow(mousePos[0].length - comparedY, 2) + Math.pow(mousePos.length - comparedX, 2)));
//                System.out.println("distance: " + distance);
//                if (distance < 50) {
//                    System.out.println("object detected " + distance);
//                    plantInventory.plants.get(i).age(5);
//
//                    return plantInventory.plants.get(i).sprite;
//                }
//            }
//        }
//        if(tool == "shop")
//        {
//
//        }
//        return null;
//    }
//}