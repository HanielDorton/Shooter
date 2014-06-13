package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueLineGun;

public class BasicBlueEnemy extends Enemy{

	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	protected double firingRate = 1.5;
	
	public BasicBlueEnemy(double x, double y,  Level level) {
		super(x, y, level);	
		this.width = 50;
		this.height = 44;
		this.sprite = new Sprite(enemy1Texture);	
		this.health = 1;
		this.xOffset = 7;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueLineGun(level, false);
	}
	
	public BasicBlueEnemy(double x, double y, List<Coord> pattern, Level level) {
		this(x, y, level);
		this.speed = 100;
		this.destX = x;
		this.destY = y;
		this.position = 0;
		this.pattern = pattern;		
	}
	
	public BasicBlueEnemy(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		this(x, y, level);
		this.speed = 40;
		this.path = path;
	}
	
	protected void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
	    	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	double angle = getAngleTo(x, y+10, x, y-10);
		    	weapon.shoot(x + 9, y + 10, angle);
		    	weapon.shoot(x + 52, y + 10, angle);
		    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
	    }
	}
	}