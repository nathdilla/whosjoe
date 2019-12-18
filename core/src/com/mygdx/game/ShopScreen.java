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

public class ShopScreen implements Screen
{

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

    private CharSequence instructionShop = "Press c to close shop.";

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
    }//end constructor method ShopScreen

    @Override
    public void show()
    {
        font = new BitmapFont();
        font.setColor(Color.BLACK);

    }//end method show

    @Override
    public void render(float delta)
    {
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
        font.getData().setScale(1);
        font.draw(game.batch, instructionShop, 0, Gdx.graphics.getHeight() - 60);


        if(Gdx.input.isKeyPressed(Input.Keys.C))
        {
            game.closeShop();
        }//end if keyPressed is C

        if(Gdx.input.getX() < xHoe + BUTTON_WIDTH && Gdx.input.getX() > xHoe && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            //System.out.println("HOE");
            shopDisplay = "Buy a new hoe.";
            if(Gdx.input.isTouched()){

                if (game.hasTool == false)
                {
                    System.out.println("now true");
                    game.hasTool = true;
                    game.balance--;
                }//end if hasTool is false

            }//end if click activity
        }//end new hoe hitbox
        if(Gdx.input.getX() < xWater + BUTTON_WIDTH && Gdx.input.getX() > xWater && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy some more water.";
            //System.out.println("water");
            if(Gdx.input.isTouched())
            {
                if (game.hasWater == false)
                {
                    game.hasWater = true;
                    game.balance--;
                }//end if hasWater is false
            }//end if click activity
        }//end new water hitbox
        if(Gdx.input.getX() < xRose + BUTTON_WIDTH && Gdx.input.getX() > xRose && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a rose seed.";
            //System.out.println("rose");
            if(Gdx.input.isTouched())
            {
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "rose";
                    game.balance--;
                }//end if hasSeed is false
            }//end if click activity
        }//end new Rose hitbox
        if(Gdx.input.getX() < xDaisy + BUTTON_WIDTH && Gdx.input.getX() > xDaisy && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a daisy seed.";
            //System.out.println("daisy");
            if(Gdx.input.isTouched())
            {
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "daisy";
                    game.balance--;
                }//end if hasSeed is false
            }//end if click activity
        }//end new Daisy hitbox
        if(Gdx.input.getX() < xTulip + BUTTON_WIDTH && Gdx.input.getX() > xTulip && BUTTON_Y - Gdx.input.getY() <  BUTTON_HEIGHT * 2 && BUTTON_Y - Gdx.input.getY() > BUTTON_HEIGHT)
        //if(Gdx.input.getX() < Gdx.graphics.getWidth() - BUTTON_WIDTH && Gdx.input.getX() > Gdx.graphics.getWidth() - BUTTON_WIDTH)
        {
            shopDisplay = "Buy a tulip seed.";
            //System.out.println("tulip");
            if(Gdx.input.isTouched())
            {
                if (game.hasSeed == false)
                {
                    game.hasSeed = true;
                    game.seedType = "tulip";
                    game.balance--;
                }//end if hasSeed is false
            }//end if clickActivity
        }//end new tulip hitbox
        game.batch.end();
    }//end new tulip hitbox

    @Override
    public void resize(int width, int height)
    {
    //nothing to resize
    }//end method resize

    @Override
    public void pause()
    {
    //nothing to pause
    }//end method pause

    @Override
    public void resume()
    {
    //nothing to resume
    }//end method resume

    @Override
    public void hide()
    {
    //nothing to hide
    }//end method hide

    @Override
    public void dispose()
    {
    //nothing to dispose
    }//end method dispose
}//end class ShopScreen
