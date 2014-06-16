package com.haniel.Shooter.entities.enemies.Level1;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.level.Level;

public class ImprovedBlueSaucer extends BlueSaucer{
	
	protected final static double secondFiringRate = 1.7;
	private double lastShotSecondGun;
	
	public ImprovedBlueSaucer(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);
		this.firingRate = .5;
		this.lastShotSecondGun = level.getTime() + 5;
		this.health = 150;
	}
	
	protected void shoot() {
        if ((level.getTime() - lastShotSecondGun) > secondFiringRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
        		super.shoot();
        		lastShotSecondGun = level.getTime();
		    	double angleSecond = level.getAngletoPlayersMiddle(x + xOffset + (width / 2), y + 44);
		       	weapon.shoot(x + xOffset + (width / 2), y + 44, angleSecond);
        	}
	    }
		
	}

}
