package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.haniel.Shooter.entities.Entity;

public class Asteroid extends Entity{
	
	protected static final Texture asteroid8_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid8_2.png"));
			
	protected static final Texture asteroid32_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid32_2.png"));
			
	protected static final Texture asteroid128_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid128_2.png"));
	
	protected float moveX, moveY;
	
	public Asteroid(double x, double y, float moveX, float moveY) {
		this.x = x;
		this.y = y;
		this.moveX = moveX * (random.nextFloat() + .4f);
		this.moveY = moveY * (random.nextFloat() + .4f);
		
	}
	
	public void bump(float x, float y) {
		//moveX *= .1;
		//moveY *= .1;
		moveX = x;
		moveY = y;
	}
	
	public float getMoveX() {
		return moveX;
	}
	
	public float getMoveY() {
		return moveY;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public void update() {
		move(moveX, moveY);
        rectangle.setPosition((float)x + xOffset,(float) y + yOffset);
        if (y < 0 - this.height || y > level.getHeight() + this.height ||
        	x < 0 - this.width || x > level.getWidth() + this.width) remove();
        else if (health < 0) remove();
        this.moveY -=  .5 * Gdx.graphics.getDeltaTime();
	}
	
	public void particles() {
		if( health < 0) {
			matches2.play();
		} 		
	}
}

