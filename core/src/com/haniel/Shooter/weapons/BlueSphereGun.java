package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BlueSphere;

public class BlueSphereGun extends Weapon{

	public BlueSphereGun(Level level) {
		super(level);
		this.firingRate = blueSphereGunFiringRate;
		//this.sound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"))
	}
	
	public void shoot(float x, float y, double dir) {
		level.add(new BlueSphere(x, y, 0));
	}

		
}
