package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BasicBulletReversed;

public class PlayerCloneGun extends PlayerGun{
	
	public PlayerCloneGun (Level level, boolean fromPlayer) {
		super(level, fromPlayer);
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new BasicBulletReversed(x, y, angle, fromPlayer));
	}

}
