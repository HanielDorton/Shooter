
package com.haniel.Shooter;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.Particle;
import com.haniel.Shooter.projectiles.Projectile;

public class GameScreen implements Screen {
    final MyGdxGame game;
   // Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<MyGraphics> graphics = new ArrayList<MyGraphics>();
    private List<Projectile> playerProjectiles = new ArrayList<Projectile>();
    private List<Particle> particles = new ArrayList<Particle>();
    long lastDropTime;
    public int damageReceived;
    public int enemiesDestroyed;
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
        add(new Player());
        
    }
    
    
    public void add(Entity e) {
    	entities.add(e);
    	e.init(this);
    }
    
    public void add(MyGraphics g) {
    	graphics.add(g);
    	g.init(this);
    }
    public void add(Projectile p) {
    	playerProjectiles.add(p);
    	p.init(this);
    }
    public void add(Particle p) {
    	particles.add(p);
    	p.init(this);
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
        game.font.draw(game.batch, "Time: " + level.levelTime, 0, screenHeight);
        game.font.draw(game.batch, "Damage Received: " + damageReceived, 0, screenHeight - 20);
        game.font.draw(game.batch, "EnemiesDestroyed: " + enemiesDestroyed, 0, screenHeight - 40);
        for (Entity entity : entities) {
        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY());
        }
        for (Projectile projectile : playerProjectiles) {
        	game.batch.draw(projectile.getTexture(), projectile.getX(), projectile.getY());
        }
        for (Particle particle : particles) {
        	game.batch.draw(particle.getTexture(), (float) particle.getX(), (float) particle.getY());
        }
	
        game.batch.end();

        for (int i = 0; i < entities.size(); i++) {
        	Entity e = entities.get(i);
        	e.update();
        	if (!(e instanceof Player)){
        		for (int p = 0; p <playerProjectiles.size(); p++) {
              		if (e.getRectangle().overlaps(playerProjectiles.get(p).getRectangle())) {
	        			e.damage(playerProjectiles.get(p).getDamage());
	        			playerProjectiles.get(p).remove();
	        		}
        		}
        		if (e.isRemoved()) {
            		entities.remove(e);
            	}
        	} else {
        		for (int j = 0; j < entities.size(); j++){
        			if (!(entities.get(j) instanceof Player)) {
        				if (e.getRectangle().overlaps(entities.get(j).getRectangle())) {
        					damageReceived++;
        				}
        				
        			}
        		}
        		
        		
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
        for (int i = 0; i < particles.size(); i++) {
        	particles.get(i).update();
        	if (particles.get(i).isRemoved()) {
        		particles.remove(particles.get(i));
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

