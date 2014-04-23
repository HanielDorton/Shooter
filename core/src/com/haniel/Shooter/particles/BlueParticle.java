package com.haniel.Shooter.particles;

public class BlueParticle extends Particle{

	public BlueParticle(double x, double y, int life) {
		super(x, y, life);
		this.texture = blueParticleTexture;
	}
	public BlueParticle(double x, double y, int life, double xa, double ya) {
		super(x, y, life, xa, ya);
		this.texture = blueParticleTexture;
	}
}
