package com.haniel.Shooter.entities.enemies.SecondLevel;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.PlayerCloneGun;

public class PlayerClone extends Enemy{
	protected PooledEffect engine1Effect;
	protected PooledEffect engine2Effect;
	
	public PlayerClone(double x, double y, Level level) {
		super(x, y, level);
		this.speed = 200;
		this.width = 21;
		this.height = 15;
		this.sprite = new Sprite(playerCloneTexture);
		this.sprite.flip(false, true);
		this.health = 1;
		this.xOffset = 4;
		this.yOffset = 7;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.lastShot= 0;
		this.health = 0;
		this.weapon = new PlayerCloneGun(level, false);
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 11,(int) y + 30);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 19,(int) y + 30);
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
		this.engine1Effect.setPosition((int) x + 11, (int) y + 30);
		this.engine2Effect.setPosition((int) x + 19,(int) y + 30);
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y-10);
	    		weapon.shoot(x - 1, y - 1, angle);
	    		weapon.shoot(x + width + xOffset, y, angle);
	    		lastShot = level.getTime();
	    		if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
		}
	}
	public void particles() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		super.particles();
	}
	public void remove() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		removed = true;
	}
	

}
