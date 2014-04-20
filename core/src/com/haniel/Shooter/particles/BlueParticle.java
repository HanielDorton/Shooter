package com.haniel.Shooter.particles;

public class BlueParticle extends Particle{

	public BlueParticle(int x, int y, int life, float speed) {
		super(x, y, life, speed);
		this.texture = blueParticleTexture2x2;
		
		/*
		if (random.nextInt(3) < 1) {
			this.texture = blueParticleTexture2x2;
		} else {
			this.texture = blueParticleTexture;
		}*/
	}

}
