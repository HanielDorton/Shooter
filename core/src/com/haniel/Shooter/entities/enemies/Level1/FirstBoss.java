package com.haniel.Shooter.entities.enemies.Level1;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class FirstBoss extends Enemy{
	
	private float firingRate = 1;
	//private int firstFiringAngle = 10;
	private double secondLastShot = 0;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();

	public FirstBoss(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);
		this.speed =15;
		this.width = 102;
		this.xOffset = 3;
		this.height = 200;
		this.yOffset =7;
		this.sprite = new Sprite(firstBossTexture);		
		this.health = 500;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset , width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + 4;
		this.engine1Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 32,(int) y + 8);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 76,(int) y + 8);
		level.particleEffects.add(engine2Effect);
		engine1Effect.start();
		engine2Effect.start();
		
		
	}
	
	protected void shoot() {
		if (health < (100)) firingRate = 1.5f;
        if ((level.getTime() - lastShot) > firingRate) {
		    	lastShot = level.getTime();
		    	double angle = getAngleTo(x, y+10, x, y-10);
		       	weapon.shoot(x + 18, y + 3 , angle);
		       	//weapon.shoot(x + 18, y + 3, angle + .3);
		       	//weapon.shoot(x + 18, y + 3, angle - .3);
		       	//angle = level.getAngletoPlayersMiddle(x + 92, y + 3);
		       	weapon.shoot(x + 92, y + 3 , angle);
		       	//weapon.shoot(x + 92, y + 3, angle + .3);
		       	//weapon.shoot(x + 92, y + 3, angle - .3);
		       	secondLastShot =  level.getTime();;
		
        			    
		if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
        }
	    if (health < (400)) {
	    	if ((level.getTime() - secondLastShot) > firingRate) {

		    }
	    		
	    }
	}
    
	
	public void update() {
		if (y < 219) {
			move(0, 70);
	        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
		} else {
			super.update();
		}
		this.engine1Effect.setPosition((int)x + 32,(int) y + 8);
		this.engine2Effect.setPosition((int)x + 76,(int) y + 8);
	}
	
	
	public void particles() {
		if( health < 0) {
			engine1Effect.allowCompletion();
			engine2Effect.allowCompletion();
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/firstlevel/BossExplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			level.setLevelComplete();
			explosion02.play(.5f);
		}
	}
}
