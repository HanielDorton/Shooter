package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BlueSphere;

public class BlueSphereGun extends Weapon{

	public BlueSphereGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		this.firingRate = blueSphereGunFiringRate;
		//this.sound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"))
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new BlueSphere(x, y, angle, fromPlayer));
	}

		
}
