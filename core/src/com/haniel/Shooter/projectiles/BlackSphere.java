package com.haniel.Shooter.projectiles;

import com.haniel.Shooter.level.Level;


public class BlackSphere extends BlueSphere{
	
	public BlackSphere (double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blackSphereGunTexture;
	}
	
	public void init(Level level) {
		this.level = level;
		this.effect = level.playerBulletEffectPool.obtain();
		this.generateParticles(x, y);
	}

}
