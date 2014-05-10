
package com.haniel.Shooter;
 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.entities.asteroids.Asteroid;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.level.LevelFirst;
import com.haniel.Shooter.projectiles.Projectile;
import com.haniel.Shooter.util.MyInputProcessor;

public class GameScreen implements Screen {
    final MyGdxGame game;
    OrthographicCamera camera;

    long lastDropTime;
    public double gameTime = 0;
    Level level = new LevelFirst(this);
    private static int screenWidth = 800;
    private static int screenHeight = 480;
    public Player player = new Player(level);
    public MyInputProcessor inputProcessor = new MyInputProcessor(player);
    private int checkPoint = 0; //4290 for ufo's // 9190 for secondcheckpoint//13990 for boss
    private int deathTimer;
    private boolean paused = false;
    private double levelComplete = -10;
    private int numContinues = 0;
    Pixmap mouse;
    private ShapeRenderer shapeRenderer = new ShapeRenderer();

    public GameScreen(final MyGdxGame gam) {
    	if (checkPoint > 0) level.setLevelTime(checkPoint);
        this.game = gam;        
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
    
    


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        
        if (paused) {
        	
        }
        else if (deathTimer == level.getLevelTime()) {
        	game.font.draw(game.batch, "Death.", screenWidth / 2 + 10, screenHeight / 2);
        	game.font.draw(game.batch, "Hit 'Space' to continue.", screenWidth / 2, screenHeight / 2 - 20);
            if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            	numContinues++;
            	levelComplete = -10;
            	deathTimer = -10;
            	player.setX(400);
            	player.setY(20);
            	level.setLevelTime(checkPoint);
   	        	clearLevel();
   	        	level.add(player);
   	        	level.stopMusic();
   	        	player.resetEngines();
            }
        } else if (levelComplete == level.getLevelTime()){
	        	
	        	game.font.draw(game.batch, "Level Complete", 350, 300);
	        	game.font.draw(game.batch, "Continues: " + numContinues, 350, 250);
	        	game.font.draw(game.batch, "Your score: " + getScore(numContinues), 350, 200);
	        	
	    } else {

	        for (MyGraphics graphic : level.graphics) {
	        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
	        }
	        for (ParticleEffect p : level.particleEffects) {
	        	p.draw(game.batch, delta);
	        	if (p.isComplete()) {
	        	level.particleEffects.removeValue(p, true);
	        		p.dispose();	        		
	        	}
	        }
	        for (PooledEffect p : level.effects) {
	        	p.draw(game.batch, delta);
	        	if (p.isComplete()) {
	        		p.free();
	        		level.effects.removeValue(p, true);
	        	}
	        }
	        for (Projectile projectile : level.projectiles) {
	        	game.batch.draw(projectile.getTexture(), (float) projectile.getX(), (float) projectile.getY());
	        }
	        for (Entity entity : level.entities) {
	        	game.batch.draw(entity.getTexture(), (float) entity.getX(), (float) entity.getY());
	        }
	        for (Asteroid asteroid : level.asteroids) {
	        	game.batch.draw(asteroid.getTexture(), (float) asteroid.getX(), (float) asteroid.getY());
	        }
	        //game.font.draw(game.batch, "Time: " + level.getLevelTime(), 0, screenHeight);
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
        // this lets each level (not each checkpoint) start 2.9 secs before screen shows
        // and says name of level.
        if (level.getLevelTime() < 290) {
        	Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            game.batch.begin();
            game.font.draw(game.batch, "Level One: Despair", 350, 300);
            game.batch.end();
            player.setX(400);
            player.setY(20);
        }
        
    }
    
    private String getScore(int numContinues) {
    	String score = "";
    	if (numContinues == 0) score = "A++";
    	else if (numContinues < 3) score = "A";
    	else if (numContinues < 6) score = "B";
    	else if (numContinues < 9) score = "C";
    	else if (numContinues < 12) score = "D";
    	else score = "F";
    	return score;
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
       	level.asteroids.clear();
       	for (int i = 0; i < level.particleEffects.size; i++)
       		level.particleEffects.get(i).dispose();
       	level.particleEffects.clear();
       	for (int i = level.effects.size - 1; i >= 0; i--)
       	    level.effects.get(i).free();
       	level.effects.clear();    	
    }
    
    public int getCheckPoint() {
    	return checkPoint;
    }
    public void setCheckPoint(int newCheckPoint) {
    	this.checkPoint = newCheckPoint;
    }
    
    public void setLevelComplete() {
    	this.levelComplete = level.getLevelTime() + 800;
    }

}

