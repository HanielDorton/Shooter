package com.haniel.Shooter.graphics;

import java.util.Random;

import com.badlogic.gdx.Gdx;

public class Star extends MyGraphics{
	private Random rand = new Random();
	private float speed;
	
	public Star(int y) {
		super(y);
		this.x = rand.nextInt(800) + 1;
		this.speed = (rand.nextFloat() * 100) + 10f;
		this.texture = starTexture;
	}
	
	//stars automatically reappear at random spot at top instead of being removed by remove();
	public void update() {
		this.y -= speed * Gdx.graphics.getDeltaTime();
		if (y < 0) {
			this.y = 480;
			this.x = rand.nextInt(800) + 1;
		}
	}
	


}
