package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.BlueParticle;

public class BlueLine extends Projectile{

	public BlueLine(double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blueline;
		this.width = 2;
		this.height = 6;
		this.speed = 300;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 1;
	}
	
	public void generateParticles(double x, double y) {
		level.add(new BlueParticle(x + width / 2, y + height / 2, 3, 0, 0));
	}

}
