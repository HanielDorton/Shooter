package com.haniel.Shooter.entities.enemies.Level2;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;

public class CargoCraft extends Enemy{
	protected PooledEffect engine1Effect, engine2Effect;
	private int engineOffset;
	private float firingRate = 1f;
	
	public CargoCraft(double x, double y, CatmullRomSpline<Vector2> path, Level level, boolean flip) {
		super(x, y, path, level);
		this.speed = 80;
		this.width = 76;
		this.xOffset = 3;
		this.height = 27;
		this.yOffset = 2;
		this.sprite = new Sprite(cargoCraftTexture);
		if (flip) {
			this.sprite.flip(true, false);
			engineOffset = 79;
		} else {
			this.engineOffset = 3;
		}
		this.health = 9;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.lastShot= level.getTime() + .5f;
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + engineOffset,(int) y + 31);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + engineOffset,(int) y + 18);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
	}
	
	public void update() {
		super.update();
		this.engine1Effect.setPosition((int) x + engineOffset, (int) y + 31);
		this.engine2Effect.setPosition((int) x + engineOffset,(int) y + 18);
	}
	public void shoot(){
		if ((level.getTime() - lastShot) > firingRate) {
    		lastShot = level.getTime();
    		level.specialBossArray.add(new HomingMissile(x + width, y + height, level, 200));
		}
	}
	public void remove() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		removed = true;
	}
}
