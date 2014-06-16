package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;

public class BackgroundPlanet extends MyGraphics {
	public BackgroundPlanet(String imageFile, int x, int y, float speed, int height) {
		super(imageFile, x, y, speed);
		this.height = height;
	}
	
	public void update() {
		this.y -= speed * Gdx.graphics.getDeltaTime();;
		if (y + height < 0) remove();
	}
}
