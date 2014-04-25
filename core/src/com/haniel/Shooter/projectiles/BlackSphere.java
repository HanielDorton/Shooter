package com.haniel.Shooter.projectiles;

import com.haniel.Shooter.particles.OrangeParticle;

public class BlackSphere extends BlueSphere{
	
	public BlackSphere (double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blackSphereGunTexture;
	}
	
	public void generateParticles(double x, double y) {
		for (int i = 0; i <3; i ++) {
			level.add(new OrangeParticle(x + width / 2, y + height / 2, 3, 0, 0));
		}
	}
}
