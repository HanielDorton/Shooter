package com.haniel.Shooter.entities;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.util.Coord;

public class Enemy1 extends Entity{

	//int xa = 0;
	//int ya = 0;
	
	public Enemy1(int x, int y) {
		this.x = x;
		this.y = y;
		this.xOffset = 4;
		this.yOffset = 20;
		this.position = 0;
		this.speed = 80;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;
		this.rectangle = new Rectangle(x + xOffset, y + yOffset, width * 0.8f, height / 2);
		this.health =3;
	}
	public void update() {
		pattern((int) x, (int) y, Coord.circleTop);
        if (y < 0 - this.height) remove(); 
        if (health < 0) remove();
        rectangle.setPosition(x + xOffset, y + yOffset);
	}
	
	public void particles() {
		if( health < 0) {
			for (int i = 0; i <500; i++)
				gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 30));
				gameScreen.add(new BlueParticle((int) x,(int) y + height / 2, 30));
				gameScreen.add(new BlueParticle((int) x + width / 2,(int) y, 30));
				gameScreen.add(new BlueParticle((int) x + width,(int) y + height, 30));
			gameScreen.enemiesDestroyed++;
			matches2.play();
		} else {
			for (int i = 0; i < 40; i++)
				gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 20));
		}
		
	}
}

	

