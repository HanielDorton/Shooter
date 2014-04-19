
package com.haniel.Shooter;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.math.Vector3;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.Projectile;

public class GameScreen implements Screen {
    final MyGdxGame game;
   // Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<MyGraphics> graphics = new ArrayList<MyGraphics>();
    private List<Projectile> playerProjectiles = new ArrayList<Projectile>();
    long lastDropTime;
    int shipsDestroyed;
    Random rand = new Random();
    public double gameTime = 0;
    Level level = new Level();
    public static int screenWidth = 800;
    public static int screenHeight = 480;

    public GameScreen(final MyGdxGame gam) {
        this.game = gam;

        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        
        //Background
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
        
        graphics.add(new BackgroundImage("textures/black_planet.png", 0, 0, .4f));
        
        //Player
        entities.add(new Player());
        
    }
    
    
    public void add(Entity e) {
    	entities.add(e);
    }
    
    public void add(MyGraphics g) {
    	graphics.add(g);
    }
    public void add(Projectile p) {
    	playerProjectiles.add(p);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        
        for (MyGraphics graphic : graphics) {
        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
        }
        game.font.draw(game.batch, "Ships Destroyed: " + shipsDestroyed, 0, screenHeight);
        for (Entity entity : entities) {
        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY());
        }
        for (Projectile projectile : playerProjectiles) {
        	game.batch.draw(projectile.getTexture(), projectile.getX(), projectile.getY());
        }
        
        game.batch.end();
        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we increase the 
        // value our drops counter and add a sound effect.
        /*
        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0)
                iter.remove();
            if (raindrop.overlaps(bucket)) {
                dropsGathered++;
               // dropSound.play();
                iter.remove();
            }
*/
        for (int i = 0; i < entities.size(); i++) {
        	Entity e = entities.get(i);
        	e.update(this);
        	for (int p = 0; p <playerProjectiles.size(); p++) {
        		if (!(e instanceof Player)){
	        		if (e.getRectangle().overlaps(playerProjectiles.get(p).getRectangle())) {
	        			e.remove();
	        			playerProjectiles.get(p).remove();
	        		}
        		}
        	}
        	if (e.isRemoved()) {
        		entities.remove(e);
        	}
        }
        
        for (int i = 0; i < graphics.size(); i++) {
        	graphics.get(i).update();
        	if (graphics.get(i).isRemoved()) {
        		if (graphics.get(i) instanceof Star) graphics.add(new Star(480));
        		graphics.remove(graphics.get(i));
        	}
        }
        for (int i = 0; i < playerProjectiles.size(); i++) {
        	playerProjectiles.get(i).update();
        	if (playerProjectiles.get(i).isRemoved()) {
        		playerProjectiles.remove(playerProjectiles.get(i));
        	}
        }
        
        gameTime += Gdx.graphics.getDeltaTime();
        if (gameTime > 1) {
        	level.update(this);
        	gameTime--;
        }
        

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        rainMusic.play();
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
        rainMusic.dispose();
    }

}

