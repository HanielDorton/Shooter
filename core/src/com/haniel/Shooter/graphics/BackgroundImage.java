package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;

public class BackgroundImage extends MyGraphics{	
		
	public BackgroundImage(String imageFile, int x, int y, float speed) {
		super(imageFile, x, y, speed);
	}
	
	public void update() {
		y-= speed * Gdx.graphics.getDeltaTime(); ;
		if (y == -960) y = 960;
	}

}
