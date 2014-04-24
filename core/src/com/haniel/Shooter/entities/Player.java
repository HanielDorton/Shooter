package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.OrangeParticle;
import com.haniel.Shooter.weapons.BasicGun;


public class Player extends Entity{
	
	Texture player_forward = new Texture(Gdx.files.internal("entities/player.png"));
	Texture player_left = new Texture(Gdx.files.internal("entities/player_left.png"));
	Texture player_right = new Texture(Gdx.files.internal("entities/player_right.png"));
    private boolean shooting = false;;
    private int maxSpeed;
    private int keyboardSpeed;
    private GameScreen gameScreen;
    

	
	public Player(Level level) {
		this.level = level;
		this.x = 400;
		this.y = 20;
		this.width = 21;
		this.height = 15;
		this.xOffset = 4;
		this.yOffset = 7;
		this.texture = player_forward;
		this.rectangle = new Rectangle((float) x + xOffset, (float) y + yOffset, width, height);
		this.speed = 30;
		this.keyboardSpeed = 8;
		this.maxSpeed = 40;
		this.lastShot= 0;
		this.health = 1;
		this.weapon = new BasicGun(level, true);
	}
	public void update() {
		/*	
		if (Gdx.input.isTouched()) {
		        //touchPos = new Vector3();GameScreen g
		        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		}
	
		if (touchPos.x < x)
	        x -= 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.x > x)
	        x += 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.y < y)
	        y += 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.y > y)
	        y -= 200 * Gdx.graphics.getDeltaTime();
	     */

		if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) {
			movePlayer(-keyboardSpeed , 0);
			
	        
		}
	    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
	    	movePlayer(keyboardSpeed , 0);
	    	
	    }
	    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
	    	movePlayer(0, keyboardSpeed );
			
	    }
	    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S)) {
	    	movePlayer(0, -keyboardSpeed );
			
	    }
	    
		/*
		 * this.texture = player_left;
		 * this.texture = player_right;
		 * this.texture = player_forward;
		 * this.texture = player_forward;
		 */

		
	    if (shooting ||  Gdx.input.isKeyPressed(Keys.ENTER)) {
	    	if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y+10);
	    		weapon.shoot(x - 1, y, angle);
	    		angle = getAngleTo(x, y, x, y+10);
	    		weapon.shoot(x + width + xOffset, y, angle);
	    		lastShot = level.getTime();
	    		weapon.playSound();
	    	}
	    }
	
	    if (x < 0) x = 0;
	    if (x > gameScreen.getWidth() - (width + xOffset * 2)) x = gameScreen.getWidth() - (width + xOffset * 2);
	    if (y < 0) y = 0;
	    if (y > gameScreen.getHeight() - (height + yOffset * 2)) y = gameScreen.getHeight() - (height + yOffset *2);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    
	    //these are the engine particles
	    for (int i =0; i < 4; i++) {
			level.add(new OrangeParticle(x + 9 + i, y, 2, -1, -30));
			level.add(new OrangeParticle(x + 16 + i, y, 2, 1 , -30));
	    }
	}
	
	public void movePlayer(int moveX, int moveY) {
		if (Math.abs(moveX) > maxSpeed) moveX = (maxSpeed * myAbs(moveX));
		if (Math.abs(moveY) > maxSpeed) moveY = (maxSpeed * myAbs(moveY));
		move(speed * moveX, speed * moveY);	
	}
	
	public void startShooting() {
		shooting = true;
	}
	public void stopShooting() {
		shooting = false;
	}

	public void particles() {
		//for when you get hit / die?
	}
	
	public float getHealth() {
		return health;
	}
	
	public void changeLevel(Level level) {
		this.level = level;
		//need to change level for weapon here too!!
	}
	public void init(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
}
