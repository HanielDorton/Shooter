package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;


public class BackgroundImage extends Graphic{
	
	private float speed;
		
	public BackgroundImage(String imageFile, int x, int y, float speed) {
		this.texture = new Texture(Gdx.files.internal(imageFile));
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.speed = speed;
		
	}
	
	public void update() {
		y-=speed;
		if (y == -960) y = 960;
	}

}
