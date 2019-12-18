package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Timer;

public class TitleScreen implements Screen
{
WhosJoeMain game;
private CharSequence flashText;
private BitmapFont font;

    public TitleScreen(WhosJoeMain game)
    {
        this.game = game;
        font = new BitmapFont();
        font.getData().setScale(2);

        Timer flashTimer = new Timer();
        Timer.Task flashTask = new Timer.Task()
        {
            @Override
            public void run()
            {
                flashText = "";

                Timer flash2Timer = new Timer();
                Timer.Task flash2Task = new Timer.Task(){
                    @Override
                    public void run() {
                        flashText = "Press any key to begin Joe.";

                    }
                };
                flash2Timer.scheduleTask(flash2Task,1);
            }//end method run
        };//end task initialization
       flashTimer.scheduleTask(flashTask,1,2);
    }//end method titleScreen

    @Override
    public void show()
    {
        flashText = "Press any key to begin Joe.";
        font.setColor(Color.BLACK);
    }//end method show

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1,1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        font.draw(game.batch, flashText, 30, Gdx.graphics.getHeight()/2-100);
        font.draw(game.batch, "Who's Joe?", 30, Gdx.graphics.getHeight()/2+100);

        if(Gdx.input.isKeyPressed(Input.Keys.ANY_KEY))
        {
            game.startGame();
        }//end if keyPress

        game.batch.end();
    }//end render

    @Override
    public void resize(int width, int height)
    {
    //Nothing to resize
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
}//end class TitleScreen
