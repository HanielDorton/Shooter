package com.haniel.Shooter.entities.enemies.Level2;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.SphereGun;

public class PlayerClone extends Enemy{
	protected PooledEffect engine1Effect;
	protected PooledEffect engine2Effect;
	private float firingRate = .5f;
	
	public PlayerClone(double x, double y, Level level) {
		super(x, y, level);
		this.speed = 200;
		this.width = 46;
		this.xOffset =2;
		this.height = 80;
		this.yOffset = 4;
		this.sprite = new Sprite(playerCloneTexture);
		this.sprite.flip(false, true);
		this.health = 4;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.lastShot= 0;
		this.weapon = new SphereGun(level, false, 800);
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 18,(int) y + 77);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 32,(int) y + 77);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
	}
	
	public PlayerClone(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		this(x, y, level);
		this.path = path;
	}
	public PlayerClone(double x, double y, List<Coord> pattern, Level level) {
		this(x, y, level);
		this.pattern = pattern;
		this.destX = x;
		this.destY = y;
		this.position = 0;
	}
	

	public void update() {
		super.update();
		this.engine1Effect.setPosition((int) x + 18, (int) y + 77);
		this.engine2Effect.setPosition((int) x + 32,(int) y + 77);
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot) > firingRate) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y-10);
	    		weapon.shoot(x + 6, y + 40, angle);
	    		weapon.shoot(x + 43, y + 40, angle);
	    		lastShot = level.getTime();
	    		if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
		}
	}
	public void particles() {

		super.particles();
	}
	public void remove() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		removed = true;
	}
	

}
