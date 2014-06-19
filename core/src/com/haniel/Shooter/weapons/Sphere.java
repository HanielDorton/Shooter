package com.haniel.Shooter.weapons;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
public class Sphere extends Projectile{

	public Sphere(double x, double y, double dir, boolean fromPlayer, int speed) {
		super(x, y, dir, fromPlayer);
		this.width = 4;
		this.height = 4;
		this.speed = speed;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 5;
	}
	
	public void init(Level level) {
		this.level = level;
		this.effect = level.enemyBulletEffectPool.obtain();
		this.generateParticles(x, y);
	}

}
