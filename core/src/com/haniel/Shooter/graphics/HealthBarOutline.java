package com.haniel.Shooter.graphics;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class HealthBarOutline extends MyGraphics{
	public HealthBarOutline(int y) {
		super(y);
		this.x = 150;
		this.y = 455;
		this.texture = healthBarOutlineTexture;
		this.sprite = new Sprite(texture);
		
	}

}
