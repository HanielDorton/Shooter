package com.haniel.Shooter.entities.Enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.util.Coord;

public class BasicBlueEnemy extends Enemy{

	public BasicBlueEnemy(double x, double y, List<Coord> pattern) {
		super(x, y, pattern);
		this.speed = 100;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width * 0.8f, height / 2);
		this.health =3;
		this.xOffset = 4;
		this.yOffset = 20;
	}
	

}
