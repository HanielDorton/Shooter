package com.haniel.Shooter.entities.asteroids;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.particles.BrownParticle;

public class Asteroid extends Entity{
	
	protected static final Texture asteroid8_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid8_1.png"));
			
	protected static final Texture asteroid32_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid32_1.png"));
			
	protected static final Texture asteroid128_1 = new Texture(Gdx.files.internal("textures/asteroids/asteroid128_1.png"));
	
	protected float moveX, moveY;
	
	public Asteroid(float x, float y, float moveX, float moveY) {
		this.x = x;
		this.y = y;
		this.moveX = moveX * random.nextFloat();
		this.moveY = moveY * random.nextFloat();
		
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
	
	public void update() {
		move(moveX, moveY);
        rectangle.setPosition(x + xOffset, y + yOffset);
        if (y < 0 - this.height || y > gameScreen.getHeight() + this.height ||
        	x < 0 - this.width || x > gameScreen.getWidth() + this.width) remove();
        else if (health < 0) remove();
        this.moveY *= 1 + (.1 * Gdx.graphics.getDeltaTime());
	}
	
	public void particles() {
		if( health < 0) {
			for (int i = 0; i < 10 * width; i++)
				gameScreen.add(new BrownParticle((int) x + width / 2,(int) y + height / 2, 30));
				gameScreen.add(new BrownParticle((int) x,(int) y + height / 2, 30));
				gameScreen.add(new BrownParticle((int) x + width / 2,(int) y, 30));
				gameScreen.add(new BrownParticle((int) x + width,(int) y + height, 30));
			gameScreen.enemiesDestroyed++;
			matches2.play();
		} else {
			//for (int i = 0; i < width; i++)
				//gameScreen.add(new BrownParticle((int) x + width / 2,(int) y + height / 2, 20));
		}
		
	}
}

