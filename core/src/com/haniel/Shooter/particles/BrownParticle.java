package com.haniel.Shooter.particles;

public class BrownParticle  extends Particle{

	public BrownParticle(double x, double y, int life) {
		super(x, y, life);
		this.texture = brownParticleTexture;
	}
}