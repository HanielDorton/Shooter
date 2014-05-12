package com.haniel.Shooter.level;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.utils.Array;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.entities.asteroids.Asteroid;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.projectiles.Projectile;
import com.haniel.Shooter.weapons.Weapon;


public class Level {
	protected Random random = new Random();	
	private double time;
	protected Music backgroundMusic;
	protected int levelTime;
	protected float gTime,  weaponTime = 0;
	protected GameScreen gameScreen;
    public List<MyGraphics> graphics = new LinkedList<MyGraphics>();
    public List<Entity> entities = new ArrayList<Entity>();
    public List<Asteroid> asteroids = new ArrayList<Asteroid>();
    public List<Projectile> projectiles = new ArrayList<Projectile>();
    public Array<ParticleEffect> particleEffects= new Array<ParticleEffect>();
    public Array<ParticleEffect> overlayedParticleEffects = new Array<ParticleEffect>();
    
    
    // each level will have certain particle effects that can be pooled
    // these are the ones that come up multiple times, otherwise just send particle effects to regular array
    // remember particle effects whether pooled or not are updated automatically when drawn so you won't find
    // an update method here unlike the other object lists
    
    public Array<PooledEffect> effects = new Array<PooledEffect>();
    public ParticleEffectPool playerBulletEffectPool;
    ParticleEffect smallExplosionEffect = new ParticleEffect();
	public ParticleEffectPool smallExplosionEffectPool;
    ParticleEffect smallEngineEffect = new ParticleEffect();
	public ParticleEffectPool smallEngineEffectPool;	
	ParticleEffect enemyBulletEffect = new ParticleEffect();
	public ParticleEffectPool enemyBulletEffectPool;
	
	//array for enemy weapon sounds so only a few get played
	public LinkedList<Weapon> weaponSounds = new LinkedList<Weapon>(); 
	
	public Level(GameScreen gameScreen) {
		this.gameScreen = gameScreen; 
		ParticleEffect playerBulletEffect = new ParticleEffect();
		playerBulletEffect.load(Gdx.files.internal("particles/PlayerBullet.p"), Gdx.files.internal("particles/"));
		playerBulletEffectPool  = new ParticleEffectPool(playerBulletEffect, 10, 30);
	}

	public void runLevel(GameScreen g) {
	}
	
	public void update() {
		gTime = Gdx.graphics.getDeltaTime();
		time += gTime;
		weaponTime += gTime;
        updateGraphics();
        updateEntities();     
        updateProjectiles();
        
        if (weaponTime > .3) {
        	if (weaponSounds.size() > 0) {
        		weaponTime = 0;
	        	Iterator<Weapon> iter = weaponSounds.iterator();    
		        while(iter.hasNext()) {
		        	Weapon w = iter.next();
		        	w.playSound();
		        	iter.remove();
		        }
        	}
        }
	}
	
    private void updateGraphics() {
    	Iterator<MyGraphics> iter = graphics.iterator();
        while(iter.hasNext()) {
        	MyGraphics g = iter.next();
        	g.update();
        	if (g.isRemoved()) {
        		iter.remove();
        	}
        }
		
	}

	private void updateEntities() {
    	Iterator<Entity> entityIterator = entities.iterator();
    	while (entityIterator.hasNext()) {
    		Entity e = entityIterator.next();
        	e.update();
        	if (e instanceof Player){
        		for (int j = 0; j < entities.size(); j++){
        			if (!(entities.get(j) instanceof Player)) {
        				if (e.getRectangle().overlaps(entities.get(j).getRectangle())) {
        					e.damage(1);
        				}
        				
        			}
        		}
        	}
            Iterator<Projectile> projectileIter = projectiles.iterator();
            while (projectileIter.hasNext()) {
            	Projectile p = projectileIter.next();
    			if(e instanceof Player) {
    				if (!(p.fromPlayer())) {
    					if (e.getRectangle().overlaps(p.getRectangle())) {
    						e.damage(p.getDamage());
    						p.remove();
    					}
    				}
    			} else {
    				if (p.fromPlayer()) {
    					if (e.getRectangle().overlaps(p.getRectangle())) {              			
		        			e.damage(p.getDamage());
		        			p.remove();
    					}
	        		}
    				if (!(e instanceof Player) &&  e.isRemoved()) {
    					entityIterator.remove();
    					break;
    				}
    			}
        	}  
        }
		
	}

	private void updateProjectiles() {
        Iterator<Projectile> iter = projectiles.iterator();
        while (iter.hasNext()) {
        	Projectile p = iter.next();
        	p.update();
            if (p.isRemoved()) {
                iter.remove();
            }
        }		
	}
    /*
    private void updateAsteroids() {
    	//not currently used and need to update to use proper iterators
    	//Cycle through asteroids, updating, removing, and checking if they overlap any playe projectiles
        for (int i = 0; i < asteroids.size(); i++) {
        	Asteroid a = asteroids.get(i);
    		for (int p = 0; p <projectiles.size(); p++) {
          		if (a.getRectangle().overlaps(projectiles.get(p).getRectangle())) {
        			a.damage(projectiles.get(p).getDamage());
        			projectiles.get(p).remove();
          		} 
    		}
    		
    		// this moves the asteroid then check if any overlapping;
    		//if there is overlapping it changes the direction and resets the asteroid back to its original position
    		//if there wasn't then the original move made stays
    		double originalX = a.getX();
    		double originalY = a.getY();
    		//Gdx.input.setInputProcessor(inputProcessor);
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
    			a.getRectangle().setPosition((float) originalX, (float) originalY);
    			
    		}
        }
    	
    }*/

	public void add(MyGraphics g) {
    	graphics.add(g);
    	g.init(this);
    }
    
    public void add(Entity e) {
    	e.init(this);
    	entities.add(e);
    }    
    
    public void add(Projectile p) {
    	projectiles.add(p);
    	p.init(this);
    }
    
    public void add(Asteroid a) {
    	asteroids.add(a);
    	a.init(this);
    }
    
	protected void addStarsCheckpoint(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(random.nextInt(480)));
        	} 
	}
	
	protected void addStars(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(480));
        	} 
	}
	
	public int getLevelTime() {
		return levelTime;
	}
	public void setLevelTime(int newLevelTime) {
		levelTime = newLevelTime;
	}
	
	public int getHeight() {
		return gameScreen.getHeight();
	}
	public int getWidth(){
		return gameScreen.getWidth();
	}
	
	public double getTime() {
		return time;
	}
	
	public void stopMusic() {
		backgroundMusic.stop();
	}
	
	public void setLevelComplete() {
		gameScreen.setLevelComplete();
	}
	
	public double getAngletoPlayersMiddle(double x,double y) {
		double playerX = gameScreen.player.getMidX();// - 20;
		double playerY = gameScreen.player.getMidY();
		return (Math.atan2(playerY - y, playerX - x));
	}
	
	public void dispose() {
		backgroundMusic.dispose();
	}

}
