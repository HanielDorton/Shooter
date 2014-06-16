package com.haniel.Shooter.entities.enemies.Level1;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.graphics.ShipPiece;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueLineGun;

public class BlueEnemy extends Enemy{

	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	protected double firingRate = 1.5;
	
	public BlueEnemy(double x, double y,  Level level) {
		super(x, y, level);	
		this.width = 45;
		this.height = 44;
		this.sprite = new Sprite(enemy1Texture);	
		this.health = 1;
		this.xOffset = 1;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueLineGun(level, false);
	}
	
	public BlueEnemy(double x, double y, List<Coord> pattern, Level level) {
		this(x, y, level);
		this.speed = 150;
		this.destX = x;
		this.destY = y;
		this.position = 0;
		this.pattern = pattern;		
	}
	
	public BlueEnemy(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		this(x, y, level);
		this.speed = 40;
		this.path = path;
	}
	
	protected void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
	    	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	double angle = getAngleTo(x, y+10, x, y-10);
		    	weapon.shoot(x + 14, y + 10, angle);
		    	weapon.shoot(x + 25, y + 10, angle);
		    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
	    }
	}
	public void remove() {
		super.remove();
		//level.add(new ShipPiece(enemy1Part1, x, y + height, -speed, speed));
		//level.add(new ShipPiece(enemy1Part2, x + width / 2 , y + height, speed, speed));
		//level.add(new ShipPiece(enemy1Part3, x, y, -speed, -speed));
		//level.add(new ShipPiece(enemy1Part4, x + width / 2, y, speed, -speed));
	}
	}