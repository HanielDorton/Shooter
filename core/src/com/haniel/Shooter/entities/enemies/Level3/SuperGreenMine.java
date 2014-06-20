package com.haniel.Shooter.entities.enemies.Level3;


import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class SuperGreenMine extends GreenMine{
		
		protected double firingRate = .8;
		protected final static double firingAngle = 3;
		
		public SuperGreenMine(double x, double y,  Level level, int p, boolean notFromBoss) {
			super(x, y, level, p, notFromBoss);		
			this.weapon = new SphereGun(level, false, 200);
			this.lastShot =level.getTime() + 1.5 + random.nextInt(3);
		}
		
		protected void shoot() {
			if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
				if ((level.getTime() - lastShot) > firingRate) {
			    	for (int i = 1; i < 18; i ++) {
			    		weapon.shoot(x + 8, y + 8, firingAngle - (i * -.375));
			    	}
			    	if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);
			    	this.health -= 4;
			    	this.particles();

				}
			}
		}

	}


