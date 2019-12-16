package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;

public class ShopScreen implements Screen {

    //private static final int

    WhosJoeMain game;

    Texture newHoe;
    Texture newWater;
    Texture newRose;
    Texture newDaisy;
    Texture newTulip;
//    Texture shopDisplayHoe;
//    Texture shopDisplayWater;
//    Texture shopDisplayRose;
//    Texture shopDisplayDaisy;
//    Texture shopDisplayTulip;
    private BitmapFont font;
    private CharSequence balanceDisplay = "BALANCE: ";
    private CharSequence happinessDisplay = "HAPPINESS: ";
    private CharSequence shopDisplay = "";

    private static final int BUTTON_WIDTH = Gdx.graphics.getWidth() /7;
    private static final int BUTTON_HEIGHT = Gdx.graphics.getHeight() /2;
    private static final int BUTTON_X = Gdx.graphics.getHeight();
    private static final int BUTTON_Y = Gdx.graphics.getHeight() - 100;

    public ShopScreen(WhosJoeMain game)
    {
        this.game = game;
        newHoe = new Texture("hoe.png");
        newWater = new Texture("water.png");
        newRose = new Texture("seedRose.png");
        newDaisy = new Texture("seedDaisy.png");
        newTulip = new Texture("seedTulip.png");
//        shopDisplayHoe = new Texture("shopWord1.png");
//        shopDisplayWater = new Texture("shopWord2.png");
//        shopDisplayRose = new Texture("shopWord3.png");
//        shopDisplayDaisy = new Texture("shopWord4.png");
//        shopDisplayTulip = new Texture("shopWord5.png");
    }

    @Override
    public void show() {
        font = new BitmapFont();
        font.setColor(Color.BLACK);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(newHoe, (Gdx.graphics.getWidth() /7), BUTTON_Y);
        game.batch.draw(newWater, (Gdx.graphics.getWidth() /7) * 2, BUTTON_Y);
        game.batch.draw(newRose, (Gdx.graphics.getWidth() /7) * 3, BUTTON_Y);
        game.batch.draw(newDaisy, (Gdx.graphics.getWidth() /7) * 4, BUTTON_Y);
        game.batch.draw(newTulip, (Gdx.graphics.getWidth() /7) * 5, BUTTON_Y);

        int xHoe =  (Gdx.graphics.getWidth() / 7) - BUTTON_WIDTH / 2;
        int xWater =  (Gdx.graphics.getWidth() / 7) * 2 - BUTTON_WIDTH / 2;
        int xRose =  (Gdx.graphics.getWidth() / 7) * 3- BUTTON_WIDTH / 2;
        int xDaisy =  (Gdx.graphics.getWidth() / 7) * 4 - BUTTON_WIDTH / 2;
        int xTulip =  (Gdx.graphics.getWidth() / 7) * 5- BUTTON_WIDTH / 2;

        font.getData().setScale(1);
        font.draw(game.batch, balanceDisplay + "" + game.balance, 30, 30);
        font.draw(game.batch, happinessDisplay + "" + game.happiness, 200, 30);
        font.getData().setScale(4);
        font.draw(game.batch, shopDisplay, 0, Gdx.graphics.getHeight()/2);


        if(Gdx.input.isKeyPressed(Input.Keys.C))
        {
            game.closeShop();
        }

        if(Gdx.input.getX() < xHoe + BUTTON_WIDTH && Gdx.input.getX() > xHoe && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            //System.out.println("HOE");
            shopDisplay = "Buy a new hoe.";
            if(Gdx.input.isTouched()){
                if (game.hasTool == false)
                {
                    game.hasTool = true;
                    game.balance--;
                }
            }
        }
        if(Gdx.input.getX() < xWater + BUTTON_WIDTH && Gdx.input.getX() > xWater && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy some more water.";
            //System.out.println("water");
            if(Gdx.input.isTouched()){
                if (game.hasWater == false)
                {
                    game.hasWater = true;
                    game.balance--;
                }
            }
        }
        if(Gdx.input.getX() < xRose + BUTTON_WIDTH && Gdx.input.getX() > xRose && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a rose seed.";
            //System.out.println("rose");
            if(Gdx.input.isTouched()){
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "rose";
                    game.balance--;
                }
            }
        }
        if(Gdx.input.getX() < xDaisy + BUTTON_WIDTH && Gdx.input.getX() > xDaisy && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a daisy seed.";
            //System.out.println("daisy");
            if(Gdx.input.isTouched()){
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "daisy";
                    game.balance--;
                }
            }
        }
        if(Gdx.input.getX() < xTulip + BUTTON_WIDTH && Gdx.input.getX() > xTulip && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a tulip seed.";
            //System.out.println("tulip");
            if(Gdx.input.isTouched()){
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "tulip";
                    game.balance--;
                }
            }
        }
        game.batch.end();
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
    public void dispose() {

    }

}
