package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Enemy_1 extends Entity{
	
	private int time = 0;
	int xa = 0;
	int ya = 0;
	
	public Enemy_1(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = 64;
		this.height = 64;
		this.texture = new Texture(Gdx.files.internal("entities/enemy_1.png"));
		this.rectangle = new Rectangle();
	}
	public void update() {
		time++;
		if (time % 100== 0) {
		}
        y -= 200 * Gdx.graphics.getDeltaTime();
        
        if (y < 0 - this.height) remove(); 
	}

}
