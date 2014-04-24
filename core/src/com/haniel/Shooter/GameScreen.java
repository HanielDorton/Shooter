
package com.haniel.Shooter;
 

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.entities.asteroids.Asteroid;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.level.LevelFirst;
import com.haniel.Shooter.particles.Particle;
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
    


    public GameScreen(final MyGdxGame gam) {
        this.game = gam;        
        level.runLevel(this);
        Gdx.input.setInputProcessor(inputProcessor);

        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));


        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        
        Pixmap mouse = new Pixmap(Gdx.files.internal("textures/mouseX.png"));
        Gdx.input.setCursorImage(mouse, 0, 0);
        
        //Background

        
        //Player
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
        for (MyGraphics graphic : level.graphics) {
        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
        }      
        for (Particle particle : level.particles) {
        	game.batch.draw(particle.getTexture(), (float) particle.getX(), (float) particle.getY());
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
        game.font.draw(game.batch, "Time: " + level.getLevelTime(), 0, screenHeight);
        game.font.draw(game.batch, "Damage Received: " + (1-(player.getHealth())), 0, screenHeight - 20);
        game.batch.end();
        
        level.update();
        
        gameTime += Gdx.graphics.getDeltaTime();
        if (gameTime > .1) {
        	level.runLevel(this);
        	gameTime -= .1;
        }
        
        //every once in a while check things are getting removed correctly:
        //System.out.println(level.projectiles.size());

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
        // start the playback of the background music
        // when the screen is shown
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
        //dropSound.dispose();
        //rainMusic.dispose();
    }

}

