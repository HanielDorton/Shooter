package com.haniel.Shooter.entities.enemies.Level1;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class QuickBlue extends Enemy{
	
	protected final static double firingRate = .5;
	protected float rotation = 0f;
	private double lastX;

	public QuickBlue(double x, double y, CatmullRomSpline<Vector2> path,Level level) {
		super(x, y, level);
		this.path = path;
		this.speed = 40;
		this.width = 40;
		this.height = 40;
		this.sprite = new Sprite(quickBlueTexture);		
		this.health = 3;
		this.xOffset = 5;
		this.yOffset = 5;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, 130);
		this.lastShot = level.getTime() + random.nextInt(2);
		this.rotates = true;
		this.lastX = x;
		this.points = 10;
	}

	public void update() {
		super.update();
		if (rotation < 0) rotation = 360f;
		if (rotation > 360) rotation = 0;
		if (lastX > x) {
			rotation += 3;
		} else if (lastX < x) {
			rotation -=3;
		}
		lastX = x;
		sprite.setRotation(rotation);		
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