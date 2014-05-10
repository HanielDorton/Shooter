package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;

public class BasicGun extends Weapon{

	public BasicGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		this.firingRate = basicGunFiringRate;
		this.sound = basicGunSound;
	}
	


}
