package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;

public class CheckpointReached extends MyGraphics{	
	
	public CheckpointReached(int x, int y, float speed) {
		super(x, y, speed);
		this.speed = 120;
		this.texture = checkpointReachedTexture;
	}
	
	public void update() {
		y-=speed * Gdx.graphics.getDeltaTime();
		if (y < -500) remove();
	}
}

