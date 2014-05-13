package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BlackSphere;

public class BlackSphereGun extends BlueSphereGun{
	
	public BlackSphereGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		this.sound = explosionSound;
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new BlackSphere(x, y, angle, fromPlayer));
	}

}
