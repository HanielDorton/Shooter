package com.haniel.Shooter.particles;

public class LightBlueParticle extends Particle {
	
	public LightBlueParticle(double x, double y, int life) {
		super(x, y, life);
		this.texture = lightblueParticleTexture;
	}
	public LightBlueParticle(double x, double y, int life, double xa, double ya) {
		super(x, y, life, xa, ya);
		this.texture = lightblueParticleTexture;
	}
}
