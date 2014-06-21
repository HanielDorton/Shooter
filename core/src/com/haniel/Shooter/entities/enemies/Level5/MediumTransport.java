package com.haniel.Shooter.entities.enemies.Level5;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;

public class MediumTransport extends Enemy{
	protected PooledEffect engine1Effect, engine2Effect;
	
	public MediumTransport(double x, double y, Level level) {
		super(x, y, level);	
		this.speed = 20 + random.nextInt(10);
		this.width = 93;
		this.xOffset = 10;
		this.yOffset = 10;
		this.height = 203;
		this.sprite = new Sprite(mediumTransportShipTexture);	
		this.health = 22;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.points = 20;
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 28,(int) y + 5);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 85,(int) y + 5);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
	}
	
	public void update() {
		move(0, speed);
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
		this.engine1Effect.setPosition((int) x + 28, (int) y + 5);
		this.engine2Effect.setPosition((int) x + 85,(int) y + 5);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	}
	public void remove() {
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		removed = true;
	}
	public void shoot() {
		
	}
	public void particles() {
		if (health < 0) {
			super.particles();
			explosion02.play(.3f);
		}
	}

}
