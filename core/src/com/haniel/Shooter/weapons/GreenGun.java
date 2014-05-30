package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.GreenBullet;

public class GreenGun extends Weapon{
	
	protected int speed;
	
	public GreenGun(Level level, boolean fromPlayer, int speed) {
		super(level, fromPlayer);
		this.sound = smatterZap1;
		this.speed = speed;
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new GreenBullet(x, y, angle, fromPlayer, speed));
	}

}
