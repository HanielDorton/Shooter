package com.haniel.Shooter.entities.enemies.Level1;

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
	//private int firstFiringAngle = 10;
	private double secondLastShot = 0;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();

	public FirstBoss(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 40;
		this.width = 560;
		this.xOffset = 20;
		this.height = 160;
		this.yOffset = 20;
		this.sprite = new Sprite(firstBossTexture);		
		this.health = 500;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset , width, height);
		this.weapon = new BlackSphereGun(level, false);
		this.lastShot = level.getTime() + 8;
		this.engine1Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 85,(int) y + 5);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/firstlevel/BossEngines.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 515,(int) y + 5);
		level.particleEffects.add(engine2Effect);
		engine1Effect.start();
		engine2Effect.start();
		
		
	}
	
	protected void shoot() {
		if (health < (100)) firingRate = 1.5f;
        if ((level.getTime() - lastShot) > firingRate) {
		    	lastShot = level.getTime();
		    	double angle = level.getAngletoPlayersMiddle(x + 255, y + 20);
		       	weapon.shoot(x + 255, y + 20 , angle);
		       	weapon.shoot(x + 255, y + 20, angle + .3);
		       	weapon.shoot(x + 255, y + 20, angle - .3);
		       	angle = level.getAngletoPlayersMiddle(x + 345, y + 20);
		       	weapon.shoot(x + 345, y + 20 , angle);
		       	weapon.shoot(x + 345, y + 20, angle + .3);
		       	weapon.shoot(x + 345, y + 20, angle - .3);
		       	secondLastShot =  level.getTime();;
		
        			    
		if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
        }
	    if (health < (400)) {
	    	if ((level.getTime() - secondLastShot) > firingRate) {

		    }
	    		
	    }
	}
    
	
	public void update() {
		super.update();
		this.engine1Effect.setPosition((int)x + 85,(int) y + 5);
		this.engine2Effect.setPosition((int)x + 515,(int) y + 5);
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
