package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class GameOverScreen implements Screen
{
    WhosJoeMain game;
    private BitmapFont font;
    public GameOverScreen(WhosJoeMain game)
    {
        this.game = game;
    }//end constructor method GameOverScreen


    @Override
    public void show()
    {
        font = new BitmapFont();
        font.getData().setScale(2);
        font.setColor(Color.BLACK);
    }//end method show

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1,1,1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        font.draw(game.batch, "Game Over.", 0, Gdx.graphics.getHeight()/2 + 100);

        game.batch.end();
    }//end method render

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
}
