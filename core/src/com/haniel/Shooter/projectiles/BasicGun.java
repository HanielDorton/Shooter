package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;

public class BasicGun extends Projectile{

	public BasicGun(float x, float y, double dir) {
		super(x, y, dir);
		this.texture = basicGun;
		this.width = 2;
		this.height = 5;
		this.speed = 10;
		firingRate = basicGunFiringRate;
		this.rectangle = new Rectangle(x, y, width, height);
	}
	
	public void update() {
		this.y += speed;
		if (y > 480) removed = true;
		rectangle.setPosition(x, y);
	}
	


}
