package com.haniel.Shooter.graphics;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Star extends Graphic{
	private Random rand = new Random();
	private float speed;
	
	public Star(int y) {
		this.y = y;
		this.x = rand.nextInt(800) + 1;
		this.speed = (rand.nextFloat() * 3) + .01f;
		this.texture = new Texture(Gdx.files.internal("textures/star.png"));
	}
	public void update() {
		this.y -= speed;
		if (y < 0) remove();
	}

}
