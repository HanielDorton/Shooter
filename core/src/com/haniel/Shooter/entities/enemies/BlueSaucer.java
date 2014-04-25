package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BlueSaucer extends Enemy{
	
	protected double firingRate = 1;
	protected double firingAngle = 3;

	public BlueSaucer(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 40;
		this.width = 120;
		this.height = 62;
		this.texture = blueSaucerTexture;		
		this.health = 100;
		this.xOffset = 15;
		this.yOffset = 1;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + 5;
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	for (int i = 1; i < 9; i ++) {
	    		weapon.shoot(x + (16 * i), y + yOffset + 5, firingAngle - (i * -.375));
	    	}
        }
    }
	
	public void update(){
		super.update();
		///add engine particle effects here
		for (int i = 0; i < 60; i++)
			level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 10));
	}
	
	public void particles() {
		if( health < 0) {
			for (int xx = xOffset; x < width; x ++) {
				for (int yy = yOffset; y < height; y ++) {
					for (int n = 0; n < 10; n++ ){
						level.add(new BlueParticle((int) x + xx,(int) y + yy, 400));
					}
				}
					
			}

			matches2.play();
		} else {
			for (int i = 0; i < 40; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 30));
		}
		
	}

}
