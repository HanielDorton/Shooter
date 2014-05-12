package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueLineGun;
import com.haniel.Shooter.weapons.Weapon;

public class ImprovedBlueEnemy extends BasicBlueEnemy{
	
	private Weapon weapon2;
	protected final static double firingRate2 = 1.5;
			
	public ImprovedBlueEnemy(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.weapon2 = new BlueLineGun(level, false);
		this.lastShot2 = level.getTime() - random.nextInt(3);
	}
	protected void shoot() {
		//super.shoot();
        if ((level.getTime() - lastShot2) > firingRate2) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot2 = level.getTime();
		    	double angle = getAngleTo(x, y+10, x, y-10);
		    	weapon2.shoot(x + 9, y + 10, angle);
		    	weapon2.shoot(x + 52, y + 10, angle);
        	}
        }
	}
}
