package com.haniel.Shooter.projectiles;


public class BlackSphere extends BlueSphere{
	
	public BlackSphere (double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blackSphereGunTexture;
	}

}
