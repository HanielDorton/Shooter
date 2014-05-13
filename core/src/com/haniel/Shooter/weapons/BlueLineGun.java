package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BlueLine;

public class BlueLineGun extends Weapon{

	public BlueLineGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		this.sound = whipwooshSound;
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new BlueLine(x, y, angle, fromPlayer));
		
	}
}
