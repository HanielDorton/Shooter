package com.haniel.Shooter.graphics;

import java.util.Random;

public class Star extends MyGraphics{
	private Random rand = new Random();
	private float speed;
	
	public Star(int y) {
		super(y);
		this.x = rand.nextInt(800) + 1;
		this.speed = (rand.nextFloat() * 3) + .03f;
		this.texture = starTexture;
	}
	
	public Star(String imageFile, int x, int y, float speed) {
		super(imageFile, x, y, speed);
	}
	
	public void update() {
		this.y -= speed;
		if (y < 0) remove();
	}

}
