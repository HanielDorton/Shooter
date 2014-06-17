package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;

public class BlueLine extends Projectile{

	public BlueLine(double x, double y, double dir, boolean fromPlayer) {
		super(x, y, dir, fromPlayer);
		this.texture = blankTexture;
		this.width = 8;
		this.height = 8;
		this.speed = 300;
		this.rectangle = new Rectangle((float)x, (float)y, width, height);
		this.damage = 1;
	}
	
	public void init(Level level) {
		this.level = level;
		effect = level.enemyBulletEffectPool.obtain();
		this.generateParticles(x, y);
	}

}
