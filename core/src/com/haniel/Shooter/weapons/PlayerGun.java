package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;

public class PlayerGun extends Weapon{

	public PlayerGun(Level level) {
		super(level);
		this.firingRate = basicGunFiringRate;
		this.sound = basicGunSound;
	}
}
