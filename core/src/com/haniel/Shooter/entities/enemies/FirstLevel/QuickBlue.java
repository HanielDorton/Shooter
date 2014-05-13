package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
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
		this.sprite = new Sprite(quickBlueTexture);		
		this.health = 0;
		this.xOffset = 3;
		this.yOffset = 4;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + random.nextInt(2);
	}
	
	protected void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	double angle = level.getAngletoPlayersMiddle(x + xOffset, y + yOffset);
		       	weapon.shoot(x + xOffset, y + yOffset, angle);
		       	weapon.shoot(x + xOffset, y + yOffset, angle + .2);
		       	weapon.shoot(x + xOffset, y + yOffset, angle - .2);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
        	}
	    }
    }
}