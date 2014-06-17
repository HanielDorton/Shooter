package com.haniel.Shooter.graphics;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Star extends MyGraphics{
	private Random rand = new Random();
	private float speed;
	
	public Star(int y, int color) {
		super(y);
		this.x = rand.nextInt(800) + 1;
		this.speed = (rand.nextFloat() * 10) + 5;
		this.texture = getTexture(color);
		this.sprite = new Sprite(texture);

	}
	
	private Texture getTexture(int c) {
		switch (c) {
			case 1: {
				return whiteStarTexture;
			}
			case 2: {
				return yellowStarTexture;
			}
			case 3: {
				return orangeStarTexture;
			}
			default: {
				return starTexture;
			}
		
		}
		
	}
	
	
	//stars automatically reappear at random spot at top instead of being removed by remove();
	public void update() {
		this.y -= speed * Gdx.graphics.getDeltaTime();
		if (y < 0) {
			this.y = 480;
			this.x = rand.nextInt(800) + 1;
		}
	}
	public void changeSpeed(int sped) {
		this.speed += sped;
	}
	

	


}
