package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;

public class PlayerGun extends Weapon{

	public PlayerGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		this.firingRate = basicGunFiringRate;
		this.sound = basicGunSound;
	}
}
