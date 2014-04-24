package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.math.Rectangle;

public class Asteroid128 extends Asteroid{
	
	public Asteroid128(double x, double y, float moveX, float moveY) {
		super(x, y, moveX, moveY);
		this.xOffset = 6;
		this.yOffset = 6;
		this.width = 114;
		this.height = 114;
		this.health = width / 8;
		this.texture = asteroid128_1;
		this.rectangle = new Rectangle((float)x + xOffset,(float) y + yOffset, width, height);
		
	}
	
	public void remove() {
		if (!(y < 0 - this.height || y > level.getHeight() + this.height ||
	        x < 0 - this.width || x > level.getWidth() + this.width)) {
        	level.add(new Asteroid32(x + 30, y + 30, -20, -30));
        	level.add(new Asteroid32(x + 100, y + 100, 20, 20));
        	level.add(new Asteroid32(x + 30, y + 100, -20, 30));
        	level.add(new Asteroid32(x + 100, y + 30, 20, -20));
		}
		removed = true;
		
	}

}
