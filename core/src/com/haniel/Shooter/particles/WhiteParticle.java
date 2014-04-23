package com.haniel.Shooter.particles;

public class WhiteParticle extends Particle{

	public WhiteParticle(double x, double y, int life) {
		super(x, y, life);
		this.texture = whiteParticleTexture;
	}
	public WhiteParticle(double x, double y, int life, double xa, double ya) {
		super(x, y, life, xa, ya);
		this.texture = whiteParticleTexture;
	}
}
