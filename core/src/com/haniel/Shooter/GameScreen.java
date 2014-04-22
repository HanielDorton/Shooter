
package com.haniel.Shooter;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.entities.asteroids.Asteroid;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.Particle;
import com.haniel.Shooter.projectiles.Projectile;
import com.haniel.Shooter.util.MyInputProcessor;

public class GameScreen implements Screen {
    final MyGdxGame game;
   // Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<MyGraphics> graphics = new ArrayList<MyGraphics>();
    private List<Asteroid> asteroids = new ArrayList<Asteroid>();
    private List<Projectile> playerProjectiles = new ArrayList<Projectile>();
    private List<Particle> particles = new ArrayList<Particle>();
    long lastDropTime;
    public int damageReceived;
    public int enemiesDestroyed;
    Random rand = new Random();
    public double gameTime = 0;
    Level level = new Level();
    private static int screenWidth = 800;
    private static int screenHeight = 480;
    public Player player = new Player();
    public MyInputProcessor inputProcessor = new MyInputProcessor(player); 
    


    public GameScreen(final MyGdxGame gam) {
        this.game = gam;        
               
        Gdx.input.setInputProcessor(inputProcessor);

        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);
        
        Pixmap mouse = new Pixmap(Gdx.files.internal("textures/mouseX.png"));
        Gdx.input.setCursorImage(mouse, 0, 0);
        
        //Background
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
        
        graphics.add(new BackgroundImage("textures/black_planet.png", 0, 0, .4f));
        
        //Player
         entities.add(player);
         player.init(this);
        
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
    public void add(Asteroid a) {
    	asteroids.add(a);
    	a.init(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        
        for (MyGraphics graphic : graphics) {
        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
        }
        game.font.draw(game.batch, "Time: " + level.levelTime, 0, screenHeight);
        game.font.draw(game.batch, "Damage Received: " + (1-(player.getHealth())), 0, screenHeight - 20);
        game.font.draw(game.batch, "EnemiesDestroyed: " + enemiesDestroyed, 0, screenHeight - 40);
        for (Particle particle : particles) {
        	game.batch.draw(particle.getTexture(), (float) particle.getX(), (float) particle.getY());
        }
        for (Projectile projectile : playerProjectiles) {
        	game.batch.draw(projectile.getTexture(), projectile.getX(), projectile.getY());
        }
        for (Entity entity : entities) {
        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY());
        }
        for (Asteroid asteroid : asteroids) {
        	game.batch.draw(asteroid.getTexture(), asteroid.getX(), asteroid.getY());
        }

        game.batch.end();
        
        for (int i = 0; i < entities.size(); i++) {
        	Entity e = entities.get(i);
        	e.update();
        	if (!(e instanceof Player)){
        		//check if enemies got damaged by player
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
        		
        		//check if player overlaps or got damaged by an enemy
        		for (int j = 0; j < entities.size(); j++){
        			if (!(entities.get(j) instanceof Player)) {
        				if (e.getRectangle().overlaps(entities.get(j).getRectangle())) {
        					e.damage(1);
        					damageReceived++;
        				}
        				
        			}
        		}
        		
        		
        	}
        	//check if either player or enemies hit asteroid
        	for (int a = 0; a < asteroids.size(); a++) {
        		if (e.getRectangle().overlaps(asteroids.get(a).getRectangle())) {
        			e.damage(1);
        			asteroids.get(a).damage(1);
        			
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
        
        //Cycle through asteroids, updating, removing, and checking if they overlap any playe projectiles
        for (int i = 0; i < asteroids.size(); i++) {
        	Asteroid a = asteroids.get(i);
    		for (int p = 0; p <playerProjectiles.size(); p++) {
          		if (a.getRectangle().overlaps(playerProjectiles.get(p).getRectangle())) {
        			a.damage(playerProjectiles.get(p).getDamage());
        			playerProjectiles.get(p).remove();
          		} 
    		}
    		
    		// this moves the asteroid then check if any overlapping;
    		//if there is overlapping it changes the direction and resets the asteroid back to its original position
    		//if there wasn't then the original move made stays
    		float originalX = a.getX();
    		float originalY = a.getY();
    		Gdx.input.setInputProcessor(inputProcessor);
    		boolean gotBumped = false;
    		a.update();
        	if (a.isRemoved()) {
        		asteroids.remove(a);
        		break;
        	}
    		for (int w = 0; w < asteroids.size(); w++) {
    			if (!(a.equals(asteroids.get(w)))) {
	    			if (a.getRectangle().overlaps(asteroids.get(w).getRectangle())) {
	    				float tempX = a.getMoveX();
	    				float tempY = a.getMoveY();
	    				if (a.getWidth() <= asteroids.get(w).getWidth()) {
	    					a.bump(-a.getMoveX() * .8f, -a.getMoveY() * .8f);
	    					asteroids.get(w).bump(asteroids.get(w).getMoveX() + tempX*.1f, asteroids.get(w).getMoveY() + tempY *.1f);
	    					a.damage(1);
	    					asteroids.get(w).damage(.3);
	    				gotBumped = true;
	    				break;
	    					
	    				} 

	    			}
	    		}
    		} if (gotBumped) {
    			a.setX((int) originalX);
    			a.setY((int) originalY);;
    			a.getRectangle().setPosition(originalX, originalY);
    			
    		}
    		
   		
        }
        
        
        
        gameTime += Gdx.graphics.getDeltaTime();
        if (gameTime > 1) {
        	level.update(this);
        	gameTime--;
        }
        

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

