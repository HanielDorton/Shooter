package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.math.Rectangle;

public class Asteroid32 extends Asteroid{
	
	public Asteroid32(double x, double y, float moveX, float moveY) {
		super(x, y, moveX, moveY);
		this.xOffset = 4;
		this.yOffset = 4;
		this.width = 24;
		this.height = 24;
		this.health = width / 8;
		this.texture = asteroid32_1;
		this.rectangle = new Rectangle((float)x + xOffset,(float) y + yOffset, width, height);
		
	}
	
	public void remove() {
		if (y > 0) {
        	level.add(new Asteroid8(x + xOffset, y + yOffset, -20, -30));
        	level.add(new Asteroid8(x + xOffset, y + height, -20, 20));
        	level.add(new Asteroid8(x + width, y + yOffset, +20, -30));
        	level.add(new Asteroid8(x + width, y + height, +20, 20));
		}
		removed = true;
		
	}

}