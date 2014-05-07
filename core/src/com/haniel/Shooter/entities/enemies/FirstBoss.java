package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.OrangeParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlackSphereGun;

public class FirstBoss extends Enemy{
	
	private float firingRate = 2;
	private int firstFiringAngle = 3;
	private double secondLastShot = 0;

	public FirstBoss(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 40;
		this.width = 600;
		this.height = 200;
		this.texture = firstBossTexture;		
		this.health = 300;
		this.rectangle = new Rectangle((float)x, (float)y , width, height);
		this.weapon = new BlackSphereGun(level, false);
		this.lastShot = level.getTime() + 8;
	}
	
	public void shoot() {
		if (health < 60) firingRate = 1.5f;
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	for (int i = 1; i < 9; i ++) {
	    		weapon.shoot(x + (width / 2), y, firstFiringAngle - (i * -.375));
	    	
	    	}
        }
	    if (health < 250) {
	    	if ((level.getTime() - secondLastShot) > firingRate) {
	        	double angle = level.getAngletoPlayersMiddle(x + 51, y);
		       	weapon.shoot(x + 51, y , angle);
		       	weapon.shoot(x + 51, y, angle + .2);
		       	weapon.shoot(x + 51, y, angle - .2);
		       	angle = level.getAngletoPlayersMiddle(x + 549, y);
		       	weapon.shoot(x + 549, y , angle);
		       	weapon.shoot(x + 549, y, angle + .2);
		       	weapon.shoot(x + 549, y, angle - .2);
		       	secondLastShot =  level.getTime();;
		    }
	    		
	    }
	}
    
	
	public void update() {
		super.update();
		for (int i = 42; i < 58; i++) {
			level.add(new OrangeParticle((int) x + i,(int) y + 3, 15));
		}	
		for (int i = 537; i < 553; i++){
			level.add(new OrangeParticle((int) x + i,(int) y + 3, 15));
		}
	}
	
	
	public void particles() {
		if( health < 0) {
			for (int xx = width / 5; xx < width *.7; xx++) {
				for (int yy = height / 5; yy < height *.7; yy++) {
					level.add(new OrangeParticle(x + xx, y + yy, 30));
				}
			}
			level.setLevelComplete();
			matches2.play();
		} else {

		}
	}
}
