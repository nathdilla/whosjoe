package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.MainGameScreen;

//Let the class extend from game
public class WhosJoeMain extends Game {
        //Delete everything in it and leave a create() with a single line
    public SpriteBatch batch;
        @Override
        public void create()
        {
            batch = new SpriteBatch();
            this.setScreen(new MainGameScreen(this));
        }
@Override
    public void render()
    {
        super.render();
    }
}