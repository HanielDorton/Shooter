package com.haniel.Shooter.particles;

public class BlueParticle extends Particle{

	public BlueParticle(int x, int y, int life) {
		super(x, y, life);
		this.texture = blueParticleTexture;
	}
	public BlueParticle(float x, float y, int life, double xa, double ya) {
		super(x, y, life, xa, ya);
		this.texture = whiteParticleTexture;
	}
}
