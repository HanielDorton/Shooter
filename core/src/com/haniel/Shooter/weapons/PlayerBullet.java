package com.haniel.Shooter.weapons;

import com.badlogic.gdx.math.Rectangle;


public class PlayerBullet extends Projectile{

	public PlayerBullet(double x, double y, double angle) {
		super(x, y, angle);
		this.width = 4;
		this.height = 5;
		this.speed = 800;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 1;
	}

	

}
