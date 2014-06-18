package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;

public class BasicBulletReversed extends Projectile{
	
	public BasicBulletReversed(double x, double y, double angle, boolean fromPlayer) {
		super(x, y, angle, fromPlayer);
		this.texture = basicBulletReversedTexture;
		this.width = 2;
		this.height = 5;
		this.speed = 800;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 1;
	}
	public boolean hasTexture() {
		return true;
	}

}
