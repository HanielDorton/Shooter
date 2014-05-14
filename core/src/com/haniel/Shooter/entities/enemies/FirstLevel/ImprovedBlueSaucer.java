package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;

public class ImprovedBlueSaucer extends BlueSaucer{
	
	protected final static double secondFiringRate = 1;
	private double lastShotSecondGun;
	
	public ImprovedBlueSaucer(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.firingRate = .5;
		this.lastShotSecondGun = level.getTime() + 5;
		this.health = 50;
	}
	
	protected void shoot() {
		super.shoot();
        if ((level.getTime() - lastShotSecondGun) > secondFiringRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShotSecondGun = level.getTime();
		    	double angleSecond = level.getAngletoPlayersMiddle(x + xOffset + (width / 2), y + yOffset + 5);
		       	weapon.shoot(x + xOffset + (width / 2), y + yOffset + 5, angleSecond);
		       	//if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);
        	}
	    }
		
	}

}
