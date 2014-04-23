package com.haniel.Shooter.graphics;

public class BackgroundPlanet extends MyGraphics {
	public BackgroundPlanet(String imageFile, int x, int y, float speed, int height) {
		super(imageFile, x, y, speed);
		this.height = height;
	}
	
	public void update() {
		this.y -= speed;
		if (y + height < 0) remove();
	}
}
