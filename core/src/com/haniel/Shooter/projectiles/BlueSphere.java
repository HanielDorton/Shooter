package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.particles.WhiteParticle;

public class BlueSphere extends Projectile{

	public BlueSphere(float x, float y, double dir) {
		super(x, y, dir);
		this.texture = blueSphereGunTexture;
		this.width = 8;
		this.height = 8;
		this.speed = 200;
		this.rectangle = new Rectangle(x, y, width, height);
		this.damage = 5;
	}
	
	public void update() {
		this.y -= speed * Gdx.graphics.getDeltaTime();
		if (y < 0) removed = true;
		rectangle.setPosition(x, y);
		generateParticles(x, y);
	}
	
	public void generateParticles(float x, float y) {
		for (int i = 0; i <3; i ++) {
			level.add(new BlueParticle(x + width / 2, y, 1, 0, 0));
		}
	}

}
