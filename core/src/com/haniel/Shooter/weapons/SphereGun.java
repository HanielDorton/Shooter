package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.Sphere;

public class SphereGun extends Weapon{
	
	protected int speed;

	public SphereGun(Level level, boolean fromPlayer, int speed) {
		super(level, fromPlayer);
		this.sound = smatterZap1;
		this.speed = speed;
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new Sphere(x, y, angle, fromPlayer, speed));
	}

		
}
