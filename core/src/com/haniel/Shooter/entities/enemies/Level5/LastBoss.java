package com.haniel.Shooter.entities.enemies.Level5;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.graphics.HealthBar;
import com.haniel.Shooter.graphics.HealthBarOutline;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class LastBoss extends Enemy{
	
	
	protected PooledEffect engine1Effect, engine2Effect, engine3Effect;
	private double firingRate =.6;
	//private double secondFiringRate = 1.15;
	//private double thirdFiringRate = 3;
	//private final static double firingAngle2 = 3;
	//private final static double firingAngle = 6.5;
	private boolean flyby;
	
	
	public LastBoss(double x, double y, CatmullRomSpline<Vector2> path, Level level, boolean flyby) {
		super(x, y, path, level);
		this.sprite = new Sprite(lastBosstexture);	
		this.width = 111;
		this.xOffset = 56;
		this.height = 300;
		this.health = 500;
		if (flyby) this.speed = 20;
		this.weapon = new SphereGun(level, 70);
		this.lastShot =level.getTime() + 3;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.engine1Effect = level.smallEngineEffectPool.obtain();
		this.engine1Effect.setPosition((int) x + 78,(int) y + 5);
		level.effects.add(this.engine1Effect);
		this.engine1Effect.start();
		this.engine2Effect = level.smallEngineEffectPool.obtain();
		this.engine2Effect.setPosition((int) x + 117,(int) y + 5);
		level.effects.add(this.engine2Effect);
		this.engine2Effect.start();
		this.engine3Effect = level.smallEngineEffectPool.obtain();
		this.engine3Effect.setPosition((int) x + 153,(int) y + 5);
		level.effects.add(this.engine3Effect);
		this.engine3Effect.start();
		//this.lastShot = level.getTime() + 9;
		//this.lastShot2 = level.getTime() + 15;
		//this.lastShot3 = level.getTime() + 3;
		this.points = 200;
		this.flyby = flyby;
		if (!flyby) {
			level.add(new HealthBarOutline(0));
			level.add(new HealthBar(this, 0));
			this.speed = 10;
		}
	}
		
	public void shoot() {
		if (flyby) {
		}
		else{
			if ((level.getTime() - lastShot) > firingRate) {
		    	lastShot = level.getTime();
		    	for (int i = 0; i <8; i++) {
		    		angle = i + random.nextFloat();
			    	weapon.shoot(x + xOffset + random.nextInt(width), y +  yOffset + random.nextInt(height), angle);
			    	weapon.changeSpeed(random.nextInt(130) + 20);
		    	}
				if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
				firingRate = random.nextFloat() + .2;
			}
		}
	}
	
	public void update() {
		if (!flyby){
			if (y> 180) {
				move(0, -30);
		        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
		        shoot();
			} else {
				super.update();
			}
			
		}else {
	        move(0, speed);	        
		}
		this.engine1Effect.setPosition((int)x + 78,(int) y+5);
		this.engine2Effect.setPosition((int)x + 115,(int) y+5);
		this.engine3Effect.setPosition((int)x + 153,(int) y+5);
		rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
    }
	public void particles() {
		if( health < 0) {
			engine1Effect.allowCompletion();
			engine2Effect.allowCompletion();
			engine3Effect.allowCompletion();
			PooledEffect effect = level.largeExplosionPool.obtain();
			effect.setPosition((int) x + xOffset + width / 2,(int) y + yOffset + height / 2);
			level.effects.add(effect);
			level.setLevelComplete();
			explosion02.play(.5f);
		}
	}
}
