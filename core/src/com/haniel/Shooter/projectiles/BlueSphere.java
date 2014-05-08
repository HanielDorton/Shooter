package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
public class BlueSphere extends Projectile{

	public BlueSphere(double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blueSphereGunTexture;
		this.width = 8;
		this.height = 8;
		this.speed = 180;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 5;
	}
	
	public void init(Level level) {
		this.level = level;
		this.effect = level.enemyBulletEffectPool.obtain();
		this.generateParticles(x, y);
	}

}
