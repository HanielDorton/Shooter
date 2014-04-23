package com.haniel.Shooter.graphics;

public class BackgroundImage extends MyGraphics{	
		
	public BackgroundImage(String imageFile, int x, int y, float speed) {
		super(imageFile, x, y, speed);
	}
	
	public void update() {
		y-=speed;
		if (y == -960) y = 960;
	}

}
