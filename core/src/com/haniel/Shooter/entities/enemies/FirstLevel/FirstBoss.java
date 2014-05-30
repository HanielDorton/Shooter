package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlackSphereGun;

public class FirstBoss extends Enemy{
	
	private float firingRate = 2;
	private int firstFiringAngle = 3;
	private double secondLastShot = 0;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();
	private int difficult = 0;

	public FirstBoss(double x, double y, List<Coord> pattern, Level level, boolean difficulty) {
		super(x, y, pattern, level);
		if (difficulty) this.difficult = 50;
		this.speed = 40;
		this.width = 600;
		this.height = 200;
		this.sprite = new Sprite(firstBossTexture);		
		this.health = 300 + difficult;
		this.rectangle = new Rectangle((float)x, (float)y , width, height);
		this.weapon = new BlackSphereGun(level, false);
		this.lastShot = level.getTime() + 8;
		this.engine1Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 50,(int) y + 3);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 545,(int) y + 3);
		level.particleEffects.add(engine2Effect);
		engine1Effect.start();
		engine2Effect.start();
		
		
	}
	
	protected void shoot() {
		if (health < (50 + difficult)) firingRate = 1.5f;
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	for (int i = 1; i < 9; i ++) {
	    		weapon.shoot(x + (width / 2), y, firstFiringAngle - (i * -.375));
	    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	
	    	}
        }
	    if (health < (250 + difficult)) {
	    	if ((level.getTime() - secondLastShot) > firingRate) {
	        	double angle = level.getAngletoPlayersMiddle(x + 51, y);
		       	weapon.shoot(x + 51, y , angle);
		       	weapon.shoot(x + 51, y, angle + .2);
		       	weapon.shoot(x + 51, y, angle - .2);
		       	angle = level.getAngletoPlayersMiddle(x + 549, y);
		       	weapon.shoot(x + 549, y , angle);
		       	weapon.shoot(x + 549, y, angle + .2);
		       	weapon.shoot(x + 549, y, angle - .2);
		       	secondLastShot =  level.getTime();;
		    }
	    		
	    }
	}
    
	
	public void update() {
		super.update();
		this.engine1Effect.setPosition((int)x + 50,(int) y + 7);
		this.engine2Effect.setPosition((int)x + 545,(int) y + 7);
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
