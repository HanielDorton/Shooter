package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class QuickBlue extends Enemy{
	
	protected final static double firingRate = .5;

	public QuickBlue(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 300;
		this.width = 24;
		this.height = 8;
		this.texture = quickBlueTexture;		
		this.health = 0;
		this.xOffset = 3;
		this.yOffset = 4;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + random.nextInt(2);
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	double angle = level.getAngletoPlayersMiddle(x + xOffset, y + yOffset);
	       	weapon.shoot(x + xOffset, y + yOffset, angle);
	       	weapon.shoot(x + xOffset, y + yOffset, angle + .2);
	       	weapon.shoot(x + xOffset, y + yOffset, angle - .2);
	    }
    }
}