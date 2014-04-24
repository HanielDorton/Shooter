package com.haniel.Shooter.entities.Enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BlueSaucer extends Enemy{
	
	protected final static double firingRate = .5;

	public BlueSaucer(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 30;
		this.width = 120;
		this.height = 62;
		this.texture = blueSaucerTexture;		
		this.health = 50;
		this.xOffset = 15;
		this.yOffset = 1;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height / 2);
		this.weapon = new BlueSphereGun(level, false);
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	       	double angle = level.getAngletoPlayersMiddle(x + width / 2, y + height / 2 - 5);
	       	weapon.shoot(x + width / 2, y + height / 2 - 5, angle);
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
			
			/*
			for (int i = 0; i <500; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 50));
				level.add(new BlueParticle((int) x,(int) y + height / 2, 50));
				level.add(new BlueParticle((int) x + width / 2,(int) y, 50));
				level.add(new BlueParticle((int) x + width,(int) y + height, 50));
				level.add(new BlueParticle((int) x,(int) y + yOffset, 50));
				level.add(new BlueParticle((int) x + xOffset,(int) y, 50));
				level.add(new BlueParticle((int) x,(int) y + yOffset + width, 50));
				level.add(new BlueParticle((int) x + xOffset,(int) y + yOffset + width, 50));
*/
			matches2.play();
		} else {
			for (int i = 0; i < 40; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 30));
		}
		
	}

}
