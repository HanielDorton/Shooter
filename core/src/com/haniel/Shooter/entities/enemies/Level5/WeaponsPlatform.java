package com.haniel.Shooter.entities.enemies.Level5;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;
import com.haniel.Shooter.weapons.Weapon;

public class WeaponsPlatform extends Enemy{
	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	private Weapon weapon3, weapon2;
	protected double firingRate = .44;
	protected float rotation;
	private List<Double> angle = new LinkedList<Double>();
	private int currentAngle = 2;
	private boolean counterClockWise;
	
	public WeaponsPlatform(double x, double y, Level level, boolean counterClockWise) {
		super(x, y, level);	
		this.speed = 40;
		this.width = 33;
		this.height = 33;
		this.sprite = new Sprite(weaponsPlatformTexture, width, height);	
		this.health = 5;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, 150);
		this.weapon2 = new SphereGun(level, 250);
		this.weapon3 = new SphereGun(level, 350);
		this.points = 10;
		this.rotates = true;
		this.counterClockWise = counterClockWise;
		angle.add(getAngleTo(0,0,0,10));
		angle.add(getAngleTo(0,0,-10,10));
		angle.add(getAngleTo(0,0,-10,0));
		angle.add(getAngleTo(0,0,-10,-10));
		angle.add(getAngleTo(0,0,0,-10));
		angle.add(getAngleTo(0,0,10,-10));
		angle.add(getAngleTo(0,0,10,0));
		angle.add(getAngleTo(0,0,10,10));
		if (counterClockWise) rotation = 340f;
		else rotation = 20f;
		
		
	}
	
	protected void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
		    	lastShot = level.getTime();
		    	weapon.shoot(x + width / 2, y + height / 2, angle.get(currentAngle));
		    	weapon2.shoot(x + width / 2, y + height / 2, angle.get(currentAngle));
		    	weapon3.shoot(x + width / 2, y + height / 2, angle.get(currentAngle));
		    	if (counterClockWise) currentAngle++;
		    	else currentAngle --;
		    	if (currentAngle> 7) currentAngle = 0;
		    	if (currentAngle <0) currentAngle = 7;
		    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	
	    }
	}
	public void update() {
		move(0, -speed);
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) {
	    	shoot();
	    	if (counterClockWise) rotation += 100 * Gdx.graphics.getDeltaTime();
	    	else rotation -= 100 * Gdx.graphics.getDeltaTime();
	    	if (rotation < 0) rotation = 360f;
	    	if (rotation > 360) rotation = 0;
	    	sprite.setRotation(rotation);
	    }
	}

}
