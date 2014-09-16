
package com.haniel.Shooter;
 

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.graphics.HealthBar;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.level.Level1;
import com.haniel.Shooter.level.Level2;
import com.haniel.Shooter.level.Level3;
import com.haniel.Shooter.level.Level4;
import com.haniel.Shooter.level.Level5;
import com.haniel.Shooter.util.GameState;
import com.haniel.Shooter.util.MyInputProcessor;

public class GameScreen implements Screen {
    final MyGdxGame game;
    public OrthographicCamera camera;

    public double gameTime = 0;
    Level level;
    private static int screenWidth = 800;
    private static int screenHeight = 480;
    public Player player; 
    public MyInputProcessor inputProcessor;
    private int deathTimer, time, minutes;
    private boolean paused = false;
    private double levelComplete = -10;
    private GameState gameState;
    private int tempScore = 0;
    Pixmap mouse;
    private String timeString, minuteString;


    public GameScreen(final MyGdxGame gam, GameState gameState) {    	
        this.game = gam;
    	this.gameState = gameState;
    	level = getLevel();
    	if (gameState.checkPoint > 0) level.setLevelTime(gameState.getCheckpoint());
    	player = new Player(level);
    	inputProcessor = new MyInputProcessor(player);
        level.runLevel(this);
        Gdx.input.setInputProcessor(inputProcessor);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        tempScore =gameState.tempScore;
        //set cursor to blank image since it is fixed to the middle of the screen.
        mouse = new Pixmap(Gdx.files.internal("textures/mouseX.png"));
        Gdx.input.setCursorImage(mouse, 0, 0);
        level.add(player);
        player.init(this);        
    }

    public void render(float delta) {
    	if (!paused) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	}
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        
        if (paused) {
        game.font.draw(game.batch, "Game Paused", 350, 300);
        game.font.draw(game.batch, "Press Space to Continue", 350, 250);
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
        	paused = false;
        	level.resumeMusic();
        }
        }
        else if (deathTimer == level.getLevelTime()) {
        	Gdx.input.setCursorImage(null, 0, 0);
        	game.setScreen(new DeathScreen(game, gameState, level));
            dispose();	
        } else if (levelComplete == level.getLevelTime()){	    
        	Gdx.input.setCursorImage(null, 0, 0);
        	gameState.numLevel++;
        	gameState.checkPoint = 0;
        	game.setScreen(new LevelCompleteScreen(game, gameState, level));
        	dispose();
 	    } else {
	    	//draw and update level
	        for (MyGraphics graphic : level.graphics) {	     
	        	if (graphic instanceof HealthBar) {
	        		game.batch.draw(graphic.getSprite(), graphic.getX(), graphic.getY(),
		        			graphic.getWidth(), graphic.getHeight());
	        		
	        	}
	        	else {
		        	if (graphic.rotates()) {
	
			        	Sprite temp = graphic.getSprite();
			        	game.batch.draw(temp, (float) graphic.getX(), (float) graphic.getY(), 
			        			graphic.getOriginX(), graphic.getOriginY(), 
			        			temp.getRegionWidth(), temp.getRegionHeight(),
			        			 1f, 1f, temp.getRotation());
		        	}
		        	else {
		        		game.batch.draw(graphic.getSprite(), graphic.getX(), graphic.getY());
		        	}
	        	}
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
	        for (Entity entity : level.entities) {
	        	if (entity.rotates()) {

		        	Sprite temp = entity.getSprite();
		        	game.batch.draw(temp, (float) entity.getX(), (float) entity.getY(), 
		        			entity.getOriginX(), entity.getOriginY(), 
		        			temp.getRegionWidth(), temp.getRegionHeight(),
		        			 1f, 1f, temp.getRotation(), false);
	        	}
	        	else {
	        		game.batch.draw(entity.getSprite(), (float) entity.getX(), (float) entity.getY());
	        	}
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
	        game.font.draw(game.batch, "Stage: " + level.getName(), 5, screenHeight - 5);
	        time = level.getLevelTime() / 100;
	        if (time >= 60){
	        	minutes = time / 60;
	        	time = time % 60;
	        }
	        if (minutes == 0) minuteString = "";
	        else minuteString = minutes + ":";
	        if (time < 10) timeString = "0";
	        else timeString = "";
	        game.font.draw(game.batch, "Time: " + minuteString + timeString + time, 5, screenHeight - 25);
	        
	        
	        if (tempScore > gameState.tempScore) tempScore--;
	        else if (tempScore < gameState.tempScore) tempScore++;
	        game.font.draw(game.batch, "Score: " + tempScore, 5, screenHeight - 45);

	        
	        level.update();
	        
	        gameTime += Gdx.graphics.getDeltaTime();
	        if (gameTime > .1) {
	        	level.runLevel(this);
	        	gameTime -= .1;
	        }
	        	        
	        if (player.getHealth() < 1) {
	        	deathTimer = level.getLevelTime() + 300;    
	        	gameState.score -= 50;
	        	if (gameState.score < 0) gameState.score = 0;
	        	gameState.tempScore = gameState.score;
	        	player.particles();
	        	player.setHealth();	 
	        	level.entities.remove(player);       	
	        }
	        if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
	        	paused = true;
	        	level.pauseMusic();
	        }
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
       	level.specialBossArray.clear();
    }
    
    public int getCheckPoint() {
    	return gameState.getCheckpoint();
    	
    }
    public void setCheckPoint(int newCheckPoint) {
    	gameState.checkPoint++;
    	gameState.score = gameState.tempScore;
    }
    
    public void setLevelComplete() {
    	this.levelComplete = level.getLevelTime() + 800;
    	gameState.score = gameState.tempScore;
    }
    
    private Level getLevel() {
    	Level level;
		switch (gameState.numLevel) {
		case 2: {
			level = new Level2(this); 
			break;
		}
		case 3: {
			level = new Level3(this);
			break;
		}
		case 4: {
			level = new Level4(this);
			break;
		}
		case 5: {
			level = new Level5(this);
			break;
		}
		default: {
			level = new Level1(this);
			break;
		}
		}
		return level;
	}
    public void scorePoints(int points) {
    	gameState.tempScore += points;
    }
    


}

