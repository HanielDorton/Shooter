package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.BlueParticle;

public class BlueSphere extends Projectile{

	public BlueSphere(double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blueSphereGunTexture;
		this.width = 8;
		this.height = 8;
		this.speed = 180;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 5;
	}
	
	public void generateParticles(double x, double y) {
		for (int i = 0; i <3; i ++) {
			level.add(new BlueParticle(x + width / 2, y + height / 2, 3, 0, 0));
		}
	}

}
