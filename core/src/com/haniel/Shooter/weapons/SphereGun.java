package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;

public class SphereGun extends Weapon{

	public SphereGun(Level level, int speed) {
		super(level);
		this.sound = smatterZap1;
		this.speed = speed;
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new Sphere(x, y, angle, speed));
	}


		
}
