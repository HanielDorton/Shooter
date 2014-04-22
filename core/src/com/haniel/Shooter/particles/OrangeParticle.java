package com.haniel.Shooter.particles;

public class OrangeParticle extends Particle{

	public OrangeParticle(float x, float y, int life) {
		super(x, y, life);
		this.texture = orangeParticleTexture;
	}
	public OrangeParticle(float x, float y, int life, double xa, double ya) {
		super(x, y, life, xa, ya);
		this.texture = orangeParticleTexture;
	}
}