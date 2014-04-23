package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;


public class BasicBullet extends Projectile{

	public BasicBullet(float x, float y, double dir) {
		super(x, y, dir);
		this.texture = basicBulletTexture;
		this.width = 2;
		this.height = 5;
		this.speed = 800;
		this.rectangle = new Rectangle(x, y, width, height);
		this.damage = 1;
	}
	

}
