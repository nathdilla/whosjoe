package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private Texture idle;
	private Texture walkA;
	private Texture walkB;
	private Texture plantZero;
	public Sprite mySprite;
	public Sprite myPlant;
	public PlantInventory plantInventory;
	private int X;
	private int Y;

	@Override
	public void create () {
		batch = new SpriteBatch();
		idle = new Texture("joe.png");
		walkA = new Texture("joeWalkA.png");
		walkB = new Texture("joeWalkB.png");
		plantZero = new Texture("littlePlant.png");
		mySprite = new Sprite(idle, idle.getWidth(), idle.getHeight());
		myPlant = new Sprite(plantZero, plantZero.getWidth()/2, plantZero.getHeight()/2);

		plantInventory = new PlantInventory();

		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			X--;
			mySprite.setX(X);
		}

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(mySprite, X, Y);

		for (int i = 0; i < plantInventory.plants.size(); i++)
		{
			batch.draw(plantInventory.plants.get(i).getTexture(),plantInventory.plants.get(i).Position.length, plantInventory.plants.get(i).Position[0].length);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		idle.dispose();
	}

    @Override
    public boolean keyDown(int keycode) {
	    if (keycode == Input.Keys.LEFT)
        {
            X-=10;
            mySprite.setX(X);
        }
        if ((keycode == Input.Keys.RIGHT))
        {
            X+=10;
            mySprite.setX(X);
        }
        if ((keycode == Input.Keys.DOWN))
        {

            Y-=10;
            mySprite.setY(Y);
        }
        if ((keycode == Input.Keys.UP))
        {
            Y+=10;
            mySprite.setY(Y);
        }
        if ((keycode == Input.Keys.SPACE))
        {
            if (mySprite.getX() > 50 && mySprite.getY() > 100) {
                float[][] Position = new float[(int) mySprite.getX() - 50][(int) mySprite.getY()-100];
                plantZero = new Texture("littlePlant.png");
                Sprite createPlant = new Sprite(plantZero, plantZero.getWidth() / 2, plantZero.getHeight() / 2);
                Plant newPlant = new Plant("Rose", 0, 100, createPlant, plantZero, Position);
                plantInventory.addPlant(newPlant);
            }
        }
        return false;
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
	    System.out.println(screenX + "," + screenY );
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
}
