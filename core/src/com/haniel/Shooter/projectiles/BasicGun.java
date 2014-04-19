package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class BasicGun extends Projectile{

	public BasicGun(float x, float y, double dir) {
		super(x, y, dir);
		this.texture = basicGun;
		this.width = 2;
		this.height = 5;
		this.speed = 800;
		firingRate = basicGunFiringRate;
		this.rectangle = new Rectangle(x, y, width, height);
		this.damage = 1;
	}
	
	public void update() {
		this.y += speed * Gdx.graphics.getDeltaTime();
		if (y > 480) removed = true;
		rectangle.setPosition(x, y);
	}
	


}
