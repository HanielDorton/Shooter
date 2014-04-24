package com.haniel.Shooter.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.entities.asteroids.Asteroid;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.particles.Particle;
import com.haniel.Shooter.projectiles.Projectile;


public class Level {
	protected Random random = new Random();	
	private double time;
	protected int levelTime;
	protected GameScreen gameScreen;
    public List<MyGraphics> graphics = new ArrayList<MyGraphics>();
    public List<Entity> entities = new ArrayList<Entity>();
    public List<Asteroid> asteroids = new ArrayList<Asteroid>();
    public List<Projectile> projectiles = new ArrayList<Projectile>();
    public List<Particle> particles = new ArrayList<Particle>();

	
	public Level(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	public void runLevel(GameScreen g) {
	}
	
	protected void addStars(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(480));
        	} 
	}
	
	public void update() {
		time += Gdx.graphics.getDeltaTime();
        
		//update all graphics, if stars go past bottom of screen, spawn a new one;
        for (int i = 0; i < graphics.size(); i++) {
        	graphics.get(i).update();
        	if (graphics.get(i).isRemoved()) {
        		if (graphics.get(i) instanceof Star) graphics.add(new Star(480));
        		graphics.remove(graphics.get(i));
        	}
        }
        for (int i = 0; i < entities.size(); i++) {
        	Entity e = entities.get(i);
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
    		for (int p = 0; p <projectiles.size(); p++) {
    			if(e instanceof Player) {
    				if (!(projectiles.get(p).fromPlayer())) {
    					if (e.getRectangle().overlaps(projectiles.get(p).getRectangle())) {
    						e.damage(projectiles.get(p).getDamage());
    						projectiles.get(p).remove();
    					}
    				}
    			} else {
    				if (projectiles.get(p).fromPlayer()) {
    					if (e.getRectangle().overlaps(projectiles.get(p).getRectangle())) {              			
		        			e.damage(projectiles.get(p).getDamage());
		        			projectiles.get(p).remove();
    					}
	        		}
    				if (e.isRemoved()) {
    					entities.remove(e);
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
        

        for (int i = 0; i < projectiles.size(); i++) {
        	projectiles.get(i).update();
        	if (projectiles.get(i).isRemoved()) {
        		projectiles.remove(projectiles.get(i));
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
	}
	
	
	


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
    
    public void add(Particle p) {
    	particles.add(p);
    	p.init(this);
    }
    
    public void add(Asteroid a) {
    	asteroids.add(a);
    	a.init(this);
    }
	public int getLevelTime() {
		return levelTime;
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
	
	public double getAngletoPlayersMiddle(double x,double y) {
		double playerX = gameScreen.player.getMidX();// - 20;
		double playerY = gameScreen.player.getMidY();
		return (Math.atan2(playerY - y, playerX - x));
	}

}
