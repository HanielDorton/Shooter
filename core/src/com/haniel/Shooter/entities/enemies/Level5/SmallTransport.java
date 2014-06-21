package com.haniel.Shooter.entities.enemies.Level5;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;

public class SmallTransport extends Enemy{
	
	protected PooledEffect engine1Effect;
	public SmallTransport(double x, double y, Level level) {
		super(x, y, level);	
		this.speed = 30 + random.nextInt(30);
		this.width = 43;
		this.xOffset = 2;
		this.yOffset = 2;
		this.height = 123;
		this.sprite = new Sprite(smallTransportShipTexture);	
		this.health = 7;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.points = 10;
		this.engine1Effect = level.smallerEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 23,(int) y + 4);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
	}
	
	public void update() {
		move(0, speed);
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
		this.engine1Effect.setPosition((int) x + 23, (int) y + 4);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	}
	public void remove() {
		engine1Effect.allowCompletion();
		removed = true;
	}
	public void shoot() {
		
	}
}
