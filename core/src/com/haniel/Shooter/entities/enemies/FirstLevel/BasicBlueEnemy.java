package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BasicBlueEnemy extends Enemy{
	
	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	protected final static double firingRate = 2;
	//private PooledEffect engine1Effect;

	public BasicBlueEnemy(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = 100;
		this.width = 50;
		this.height = 44;
		this.sprite = new Sprite(enemy1Texture);		
		this.health = 1;
		this.xOffset = 7;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
	}
	protected void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		       	double angle = level.getAngletoPlayersMiddle(x + xOffset + width / 2, y + yOffset + height / 2 - 5);
		       	weapon.shoot(x + xOffset + width / 2, y + yOffset + height / 2 - 5, angle);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
        	}
        }    	
	}
}
