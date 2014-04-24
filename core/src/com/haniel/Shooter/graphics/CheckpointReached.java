package com.haniel.Shooter.graphics;

public class CheckpointReached extends MyGraphics{	
	
	public CheckpointReached(int x, int y, float speed) {
		super(x, y, speed);
		this.texture = checkpointReachedTexture;
	}
	
	public void update() {
		y-=speed;
		if (y < -500) remove();
	}
}

