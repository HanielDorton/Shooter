package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;

public class BackgroundImage extends MyGraphics{	
		
	public BackgroundImage(String imageFile, int x, int y, float speed) {
		super(imageFile, x, y, speed);
	}
	
	public void update() {
		this.y-= speed * Gdx.graphics.getDeltaTime();
	}
	public void remove() {
		removed = true;
	}
}
