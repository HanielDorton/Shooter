package com.haniel.Shooter.entities;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.util.Coord;

public class Enemy1 extends Entity{

	//int xa = 0;
	//int ya = 0;
	
	public Enemy1(int x, int y) {
		this.x = x;
		this.y = y;
		this.position = 0;
		this.speed = 2f;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;
		this.rectangle = new Rectangle(x + 4, y + 20, width * 0.8f, height / 2);
		this.health =3;
	}
	public void update() {
		pattern((int) x, (int) y, Coord.circleTop);
        if (y < 0 - this.height) remove(); 
        rectangle.setPosition(x + 4, y + 20);
	}
}
	

