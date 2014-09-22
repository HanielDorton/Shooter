package com.haniel.Shooter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.haniel.Shooter.util.ActionResolver;

public class MyGdxGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public ActionResolver actionResolver;
    
    public MyGdxGame(ActionResolver actionResolve){
    	this.actionResolver = actionResolve;
    }
    
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        this.setScreen(new LoadingScreen(this, actionResolver));

    }

    public void render() {
        super.render();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}