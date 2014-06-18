package com.haniel.Shooter.entities.enemies.Level2;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;

public class BossCargos extends Enemy{
	protected PooledEffect engine1Effect, engine2Effect;
	private float firingRate = .9f;
	
	public BossCargos(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);
		this.speed = 60;
		this.width = 27;
		this.xOffset = 2;
		this.height = 76;
		this.yOffset = 3;
		this.health = 3;
		this.sprite = new Sprite(cargoCraft2Texture);
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.lastShot= level.getTime() + .5f;
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 18,(int) y + 3);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 32,(int) y + 3);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
	}
	public void update() {
		super.update();
		this.engine1Effect.setPosition((int) x + 18, (int) y + 3);
		this.engine2Effect.setPosition((int) x + 32,(int) y + 3);
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
