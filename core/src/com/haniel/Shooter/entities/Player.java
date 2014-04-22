package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.OrangeParticle;
import com.haniel.Shooter.particles.WhiteParticle;
import com.haniel.Shooter.projectiles.BasicGun;
import com.haniel.Shooter.projectiles.Projectile;


public class Player extends Entity{
	
	private double lastShot;
	Sound gunSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"));
	Texture player_forward = new Texture(Gdx.files.internal("entities/player.png"));
	Texture player_left = new Texture(Gdx.files.internal("entities/player_left.png"));
	Texture player_right = new Texture(Gdx.files.internal("entities/player_right.png"));
    private boolean shooting = false;;
	
	public Player() {
		this.x = 400;
		this.y = 20;
		this.width = 21;
		this.height = 15;
		this.xOffset = 4;
		this.yOffset = 7;
		this.texture = player_forward;
		this.rectangle = new Rectangle(x + xOffset, y + yOffset, width, height);
		this.speed = 60;
		this.time = 0;
		this.lastShot= 0;
		this.health = 1;
	}
	public void update() {
		time += Gdx.graphics.getDeltaTime();
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
	     
			
			// Keyboard Movement not used:
		if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) {
	        x -= speed * Gdx.graphics.getDeltaTime();
			this.texture = player_left;
	        
		}
	    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
	    	x += speed * Gdx.graphics.getDeltaTime();
	    	this.texture = player_right;
	    }
	    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
	    	y += speed * Gdx.graphics.getDeltaTime();
			this.texture = player_forward;
	    }
	    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S)) {
	        y -= speed * Gdx.graphics.getDeltaTime();
			this.texture = player_forward;
	    }
	    */
		

		
	    if (shooting) shoot();

		
	
	    if (x < 0) x = 0;
	    if (x > gameScreen.getWidth() - 30) x = 800 - 30;
	    if (y < 0) y = 0;
	    if (y > gameScreen.getHeight() - 30) y = 480 - 30;
	    rectangle.setPosition(x + xOffset, y + yOffset);
	    

	    for (int i =0; i < 4; i++) {
			gameScreen.add(new OrangeParticle(x + 9 + i, y, 2, -1, -30));
			gameScreen.add(new OrangeParticle(x + 16 + i, y, 2, 1 , -30));
	    }
	}
	
	public void movePlayer(int mouseX, int mouseY) {
		move(speed * mouseX, speed * mouseY);
		//Gdx.input.setCursorPosition(x, 480 - y);
		
		/*
			if (x  < mouseX) {
				move(speed, 0);
			}
			if (x  > mouseX) {
				move(-speed, 0);
			}
			if (y  < mouseY) {
				move(0, speed);
			}
			if (y  > mouseY) {
				move(0, -speed);
			}*/
	}
	
	public void startShooting() {
		shooting = true;
	}
	public void stopShooting() {
		shooting = false;
	}

	public void shoot() {
		if (time - lastShot > Projectile.basicGunFiringRate) {
			gunSound.play();
			lastShot = time;
			gameScreen.add(new BasicGun(x - 1, y, 0));
			gameScreen.add(new BasicGun(x + 26, y, 0));
			for (int i =0; i < 5; i++) {
				gameScreen.add(new WhiteParticle(x - 1, y + 12, 1, 0, 10));
				gameScreen.add(new WhiteParticle(x + 26, y + 12, 1, 0 , 10));
				
			}
		}
	}
	public float getHealth() {
		return health;
	}
}
