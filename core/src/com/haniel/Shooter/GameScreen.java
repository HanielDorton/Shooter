
package com.haniel.Shooter;
 

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.level.Level1;
import com.haniel.Shooter.level.Level2;
import com.haniel.Shooter.projectiles.Projectile;
import com.haniel.Shooter.util.GameState;
import com.haniel.Shooter.util.MyInputProcessor;

public class GameScreen implements Screen {
    final MyGdxGame game;
    OrthographicCamera camera;

    public double gameTime = 0;
    Level level;
    private static int screenWidth = 800;
    private static int screenHeight = 480;
    public Player player; 
    public MyInputProcessor inputProcessor;
    private int deathTimer;
    private boolean paused = false;
    private double levelComplete = -10;
    private GameState gameState;
    Pixmap mouse;

    public GameScreen(final MyGdxGame gam, GameState gameState) {    	
        this.game = gam;
    	this.gameState = gameState;
    	level = getLevel();
    	if (gameState.checkPoint > 0) level.setLevelTime(gameState.checkPoint);
    	player = new Player(level);
    	inputProcessor = new MyInputProcessor(player);
        level.runLevel(this);
        Gdx.input.setInputProcessor(inputProcessor);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        
        //set cursor to blank image since it is fixed to the middle of the screen.
        mouse = new Pixmap(Gdx.files.internal("textures/mouseX.png"));
        Gdx.input.setCursorImage(mouse, 0, 0);

        level.add(player);
        player.init(this);        
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        
        if (paused) {
        	
        }
        else if (deathTimer == level.getLevelTime()) {
        	Gdx.input.setCursorImage(null, 0, 0);
        	gameState.numContinues++;
        	game.setScreen(new DeathScreen(game, gameState, level));
            dispose();	
        } else if (levelComplete == level.getLevelTime()){	    
        	Gdx.input.setCursorImage(null, 0, 0);
        	gameState.numLevel++;
        	gameState.checkPoint = 0;
        	game.setScreen(new LevelCompleteScreen(game, gameState, level));
        	dispose();
        	
	        	//game.font.draw(game.batch, "Level Complete", 350, 300);
	        	//game.font.draw(game.batch, "Continues: " + gameState.numContinues, 350, 250);
	        	//game.font.draw(game.batch, "Your score: " + getScore(gameState.numContinues), 350, 200);
	        	
	        	
	    } else {
	    	//draw and update level
	        for (MyGraphics graphic : level.graphics) {
	        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
	        }
	        Iterator<ParticleEffect> iter = level.particleEffects.iterator();
	        while (iter.hasNext()){
	        	ParticleEffect p = iter.next();
	        	p.draw(game.batch, delta);
	        	if (p.isComplete()) {
	        		iter.remove();
	        		p.dispose();	        		
	        	}
	        }
	        Iterator<PooledEffect> pooledIter = level.effects.iterator();
	        while (pooledIter.hasNext()){
	        	PooledEffect pe = pooledIter.next();
	        	pe.draw(game.batch, delta);
	        	if (pe.isComplete()) {
	        		pe.free();
	        		pooledIter.remove();
	        	}
	        }
	        for (Projectile projectile : level.projectiles) {
	        	game.batch.draw(projectile.getTexture(), (float) projectile.getX(), (float) projectile.getY());
	        }
	        for (Entity entity : level.entities) {
	        	game.batch.draw(entity.getSprite(), (float) entity.getX(), (float) entity.getY());
	        }
	        Iterator<ParticleEffect> overlayedIter = level.overlayedParticleEffects.iterator();
	        while (overlayedIter.hasNext()){
	        	ParticleEffect p = overlayedIter.next();
	        	p.draw(game.batch, delta);
	        	if (p.isComplete()) {
	        		overlayedIter.remove();
	        		p.dispose();	        		
	        	}
	        }
	        game.font.draw(game.batch, "Time: " + level.getLevelTime(), 0, screenHeight);
	        //game.font.draw(game.batch, "JaveHeap: " + Gdx.app.getJavaHeap(), 0, screenHeight -20);
	        //game.font.draw(game.batch, "NativeHeap: " +  Gdx.app.getNativeHeap(), 0, screenHeight - 40);
	        level.update();
	        gameTime += Gdx.graphics.getDeltaTime();
	        if (gameTime > .1) {
	        	level.runLevel(this);
	        	gameTime -= .1;
	        }
	        	        
	        if (player.getHealth() < 1) {
	        	deathTimer = level.getLevelTime() + 300;    
	        	player.particles();
	        	player.setHealth();	 
	        	level.entities.remove(player);       	
	        }	        
	        //every once in a while check things are getting removed correctly:
	        //System.out.println(level.effects.size);
        }
        game.batch.end();
    }
    
	public int getWidth() {
    	return screenWidth;
    }
    
    public int getHeight() {
    	return screenHeight;
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    	clearLevel();
    	//level.dispose(); need to call this if exiting;
    	mouse.dispose();
    }
    public void clearLevel() {
    	level.graphics.clear();
       	level.projectiles.clear();
       	level.entities.clear();
       	for (int i = 0; i < level.particleEffects.size; i++)
       		level.particleEffects.get(i).dispose();
       	level.particleEffects.clear();
       	for (int i = level.effects.size - 1; i >= 0; i--)
       	    level.effects.get(i).free();
       	level.effects.clear();    	
    }
    
    public int getCheckPoint() {
    	return gameState.checkPoint;
    	
    }
    public void setCheckPoint(int newCheckPoint) {
    	gameState.checkPoint = newCheckPoint;
    }
    
    public void setLevelComplete() {
    	this.levelComplete = level.getLevelTime() + 800;
    }
    
    private Level getLevel() {
    	Level level;
		switch (gameState.numLevel) {
		case 1: {
			level = new Level2(this); 
			break;
		}
		default: {
			level = new Level1(this);
			break;
		}
		}
		return level;
	}

}

