package com.haniel.Shooter.entities.enemies.Level5;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class TransportShip extends Enemy{
	
	protected double firingRate = 1.2;
	protected double firingRate2 = 1.2;
	private double angle = getAngleTo(1, 0, 10, 0);
	private double angle2 = getAngleTo(1, 0, -9, 0);
	protected PooledEffect engine1Effect, engine2Effect;
	
	public TransportShip(double x, double y, Level level) {
		super(x, y, level);	
		this.speed = 40;
		this.width = 112;
		this.xOffset = 5;
		this.yOffset = 30;
		this.height = 239;
		this.sprite = new Sprite(transportShipTexture);	
		this.health = 40;

		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, 60);
		this.points = 30;
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 23,(int) y + 5);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 102,(int) y + 5);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
		this.lastShot = level.getTime() + 1;
		this.lastShot2 = level.getTime() + 1.6;
	}
	
	public void update() {
		move(0, speed);
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
		this.engine1Effect.setPosition((int) x + 23, (int) y + 5);
		this.engine2Effect.setPosition((int) x + 102, (int) y + 5);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) {
	       	shoot();
	    }
	}
	public void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();

	    	weapon.shoot(x + 112, y + 193, angle);
	    	weapon.shoot(x + 10, y + 193, angle2);

	    	weapon.shoot(x + 112, y + 113, angle);
	    	weapon.shoot(x + 10, y + 113, angle2);

	    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    }
		if ((level.getTime() - lastShot2) > firingRate) {
		   	lastShot2 = level.getTime();
		   	weapon.shoot(x + 112, y + 233, angle);
		   	weapon.shoot(x + 10, y + 233, angle2);

		   	weapon.shoot(x + 112, y + 153, angle);
		   	weapon.shoot(x + 10, y + 153, angle2);

		   	weapon.shoot(x + 112, y + 73, angle);
		   	weapon.shoot(x + 10, y + 73, angle2);
		    if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    }
		
	}
	public void remove() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		removed = true;
	}
	public void particles() {
		if (health < 0) {
			super.particles();
			explosion02.play(.3f);
		}
	}

}
