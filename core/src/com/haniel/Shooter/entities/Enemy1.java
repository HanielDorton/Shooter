package com.haniel.Shooter.entities;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

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
		this.lastShot = 0;
	}
	public void update() {
		pattern((int) x, (int) y, Coord.circleTop);
        if (y < 0 - this.height) remove(); 
        if (health < 0) remove();
        rectangle.setPosition(x + xOffset, y + yOffset);
	    if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    	weapon.shoot(x + width / 2, y, 0);
	    	//weapon.shoot(x + width + xOffset, y, 0);
	    	lastShot = level.getTime();
	    }
	}
	
	
	public void particles() {
		if( health < 0) {
			for (int i = 0; i <500; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 15));
				level.add(new BlueParticle((int) x,(int) y + height / 2, 15));
				level.add(new BlueParticle((int) x + width / 2,(int) y, 15));
				level.add(new BlueParticle((int) x + width,(int) y + height, 15));
			matches2.play();
		} else {
			for (int i = 0; i < 40; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 15));
		}
		
	}
	
	public void init(Level level) {
		this.level = level;
		this.weapon = new BlueSphereGun(level);
		
	}
}

	

