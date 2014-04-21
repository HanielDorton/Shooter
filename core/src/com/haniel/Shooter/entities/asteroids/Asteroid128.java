package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.math.Rectangle;

public class Asteroid128 extends Asteroid{
	
	public Asteroid128(float x, float y, float moveX, float moveY) {
		super(x, y, moveX, moveY);
		this.xOffset = 3;
		this.yOffset = 3;
		this.width = 122;
		this.height = 122;
		this.health = width / 8;
		this.texture = asteroid128_1;
		this.rectangle = new Rectangle(x + xOffset, y + yOffset, width, height);
		
	}
	
	public void remove() {
		if (!(y < 0 - this.height || y > gameScreen.getHeight() + this.height ||
	        x < 0 - this.width || x > gameScreen.getWidth() + this.width)) {
        	gameScreen.add(new Asteroid32(x + 30, y + 30, -20, -30));
        	gameScreen.add(new Asteroid32(x + 100, y + 100, 20, 20));
        	gameScreen.add(new Asteroid32(x + 30, y + 100, -20, 30));
        	gameScreen.add(new Asteroid32(x + 100, y + 30, +20, -20));
		}
		removed = true;
		
	}

}
