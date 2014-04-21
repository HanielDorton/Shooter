package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.math.Rectangle;

public class Asteroid8 extends Asteroid{
	

	
	public Asteroid8(float x, float y, float moveX, float moveY) {
		super(x, y, moveX, moveY);
		this.xOffset = 1;
		this.yOffset = 1;
		this.width = 7;
		this.height = 7;
		this.health = width / 8;
		this.texture = asteroid8_1;
		this.rectangle = new Rectangle(x + 1, y + 1, width, height);
		
	}
	
}
	

