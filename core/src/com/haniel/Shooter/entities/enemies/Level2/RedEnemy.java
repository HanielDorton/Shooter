package com.haniel.Shooter.entities.enemies.Level2;

import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class RedEnemy extends Enemy{
	protected PooledEffect engine1Effect;
	private float firingRate = .5f;
	
	public RedEnemy(double x, double y, Level level) {
		super(x, y, level);
		this.width = 43;
		this.xOffset =6;
		this.height = 60;
		this.yOffset = 20;
		this.sprite = new Sprite(redEnemyTexture);
		this.health = 4;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.lastShot= level.getTime() + .75;
		this.weapon = new SphereGun(level, false, 800);
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 27,(int) y + 100);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.points = 10;
	}
	
	public RedEnemy(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		this(x, y, level);
		this.path = path;
		this.speed = 80;
	}
	
	public void update() {
		super.update();
		this.engine1Effect.setPosition((int) x + 27, (int) y + 100);
	}
	
	protected void shoot() {
		if ((level.getTime() - lastShot) > firingRate) {
    		double angle = getAngleTo(x - 1, y, x - 1, y-10);
    		weapon.shoot(x + 21, y + 20, angle);
    		weapon.shoot(x + 35, y + 20, angle);
    		lastShot = level.getTime();
    		if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		}
	}
	public void remove() {
		engine1Effect.allowCompletion();
		removed = true;
	}
	

}
