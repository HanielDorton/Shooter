package com.haniel.Shooter.entities.enemies.Level2;


import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;

public class HomingMissile extends Enemy{
	
	private int trackPlayer = 12;
	private float firingRate = .2f;
	private PooledEffect effect;

	public HomingMissile(double x, double y,  Level level, int speed) {
		super(x, y, level);	
		this.speed = speed;
		this.sprite = new Sprite(starTexture);
		this.health = 0;
		this.width = 15;
		this.height = 8;
		this.rectangle = new Rectangle((float)x - (width / 2), (float)y - (height / 2), width, height);
		this.lastShot = level.getTime() - 1.4f;
		this.angle = level.getAngletoPlayersMiddle(x + (width / 2), y + (height / 2));
		this.effect = level.enemyBulletEffectPool.obtain();
		this.effect.setPosition((int) x, (int)y);
		level.effects.add(this.effect);
		this.effect.start();
		this.points = 0;
	}
	
	public void shoot() {
		//for this 'enemy' 'shooting' resets the angle to the player
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 680) && !(getMidY() < -200) && !(getMidX() < -200 && !(getMidX() > 1000))){
		    	lastShot = level.getTime();
		    	trackPlayer--;
		    	this.angle = level.getAngletoPlayersMiddle(x + (width / 2), y + (height / 2));
        	}
        }
		
	}
	public void update() {
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
        if (!removed) {
	        move(Math.cos(angle) * speed, Math.sin(angle) * speed);	
	        rectangle.setPosition((float)x, (float)y);
	        this.effect.setPosition((int) x, (int)y);
	        if (trackPlayer > 0) shoot();
	        if (random.nextInt(10) > 7) irritatingAmbiantBuzz.play(.4f);
        }
	}
	
	public void particles() {
		if( health < 0) {
			PooledEffect effect2 = level.smallExplosionEffect2Pool.obtain();
			effect2.setPosition((int) x + xOffset + width / 2,(int) y + yOffset + height / 2);
			level.effects.add(effect2);
			explosion01.play(.25f);
			effect.allowCompletion();
		}
	}

}

