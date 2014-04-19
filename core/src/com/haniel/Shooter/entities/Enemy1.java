package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;

public class Enemy1 extends Entity{

	//int xa = 0;
	//int ya = 0;
	
	public Enemy1(int x, int y) {
		this.x = x;
		this.y = y;
		this.speed = 100;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;
		this.rectangle = new Rectangle(x + 4, y + 20, width * 0.75f, height / 2);
	}
	public void update(GameScreen g) {
		//time++;
		//if (time % 100== 0) {
		//}
        y -= speed * Gdx.graphics.getDeltaTime();
        
        if (y < 0 - this.height) remove(); 
        rectangle.setPosition(x + 4, y + 20);
	}

}
