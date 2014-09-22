package com.haniel.Shooter.entities.enemies.Level1;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class BlueEnemy extends Enemy{

	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	protected double firingRate = 1.5;
	
	public BlueEnemy(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, level);	
		this.path = path;
		this.speed = 40;
		this.width = 45;
		this.height = 44;
		this.sprite = new Sprite(enemy1Texture);	
		this.health = 1;
		this.xOffset = 1;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, 300);
		this.points = 10;
	}
	
	protected void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
	    	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	double angle = getAngleTo(x, y+10, x, y-10);
		    	weapon.shoot(x + 19, y + 20, angle);
		    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
	    }
	}
	}