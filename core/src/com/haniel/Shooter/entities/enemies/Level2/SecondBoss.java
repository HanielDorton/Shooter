package com.haniel.Shooter.entities.enemies.Level2;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.graphics.HealthBar;
import com.haniel.Shooter.graphics.HealthBarOutline;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Pathing;
import com.haniel.Shooter.weapons.SphereGun;

public class SecondBoss extends Enemy{
	
	//private ParticleEffect engine1Effect = new ParticleEffect();
	//private ParticleEffect engine2Effect = new ParticleEffect();;
	private int startEngines;
	private double firingRate = 2;
	private double secondFiringRate = 1.15;
	private double thirdFiringRate = 3;
	private final static double firingAngle2 = 3;
	private final static double firingAngle = 6.25;
	private boolean flyby, flip;
	
	
	public SecondBoss(double x, double y, CatmullRomSpline<Vector2> path, Level level, boolean flyby) {
		super(x, y, path, level);
		this.sprite = new Sprite(secondBossTexture);	
		this.width = 300;
		this.xOffset = 3;
		this.height = 690;
		this.yOffset = 5;
		this.health = 500;
		this.speed = 7;
		this.weapon = new SphereGun(level, false, 70);
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		//this.engine1Effect.load(Gdx.files.internal("particles/secondlevel/bossexhaust.p"), Gdx.files.internal("particles/"));
		//this.engine2Effect.load(Gdx.files.internal("particles/secondlevel/bossexhaust.p"), Gdx.files.internal("particles/"));
		this.lastShot = level.getTime() + 9;
		this.lastShot2 = level.getTime() + 15;
		this.lastShot3 = level.getTime() + 3;
		this.startEngines =level.getLevelTime() + 1300;
		this.points = 200;
		this.flyby = flyby;
		if (!flyby) {
			level.add(new HealthBarOutline(0));
			level.add(new HealthBar(this, 0));
			this.speed = 2;
		}
	}
	
	public void shoot() {
		if (flyby) {
			if (y > level.getHeight() + 200) remove();
			if (!(y > level.getHeight())) {
				if ((level.getTime() - lastShot) > firingRate) {
					lastShot = level.getTime();
					if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
			    	for (int i = 1; i < 5; i ++) {
			    		weapon.shoot(x + 154, y + 554, firingAngle - (i * -.6));
			    	}
			    	for (int i = 1; i < 9; i ++) {
			    		weapon.shoot(x + 154, y + 441, firingAngle2 - (i * -.750));
			    		weapon.shoot(x + 154, y + 200, firingAngle2 - (i * -.750));
			    	}
				}
			   if ((level.getTime() - lastShot2) > secondFiringRate) {
						lastShot2 = level.getTime();
						if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
						double angle = getAngleTo(x, y, x - 10, y);
						weapon.shoot(x + 2, y + 433, angle);
						weapon.shoot(x + 2, y + 189, angle);
						angle = getAngleTo(x, y, x +10, y);
						weapon.shoot(x + 304, y + 433, angle);
						weapon.shoot(x + 304, y + 189, angle);
				}
			}
			
		}
		else{
			if ((level.getTime() - lastShot3) > thirdFiringRate) {
				lastShot3 = level.getTime();
				if (health > 150) {
					if (flip) {
						level.specialBossArray.add(new BossCargos(0, -80, Pathing.goUpLeft, level));
						flip = false;
					} else {
						level.specialBossArray.add(new BossCargos(770, -80, Pathing.goUpRight, level));
						flip = true;
					}
				} else {
					level.specialBossArray.add(new BossCargos(770, -80, Pathing.goUpRight, level));
					level.specialBossArray.add(new BossCargos(0, -80, Pathing.goUpLeft, level));
					
				}
			}
		}

	}

	public void update() {
		if (!flyby){
			if (y > 400) {
				move(0, -30);
		        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
		        shoot();
			} else {
				super.update();
			}
			
		}else {
	        super.update();
	        
		}
        if (startEngines == level.getLevelTime()) {
        	//this.engine1Effect.setPosition((int)x + 38,(int) y+5);
        	//this.engine2Effect.setPosition((int)x + 170,(int) y+5);
        	//level.overlayedParticleEffects.add(engine1Effect);
        	//level.overlayedParticleEffects.add(engine2Effect);
        	//engine1Effect.start();
        	//engine2Effect.start();
        }
        //if (startEngines < level.getLevelTime()) {
        	//this.engine1Effect.setPosition((int)x + 38,(int) y+5);
        	//this.engine2Effect.setPosition((int)x + 170,(int) y+5);
        	
       // }
        
	}
	public void particles() {
		if( health < 0) {
			//engine1Effect.allowCompletion();
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/secondlevel/bossexplosions2.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y  + 100);
			level.particleEffects.add(explosion);
			explosion.start();
			level.setLevelComplete();
			explosion02.play(.5f);
		}
	}

	public void remove() {
		super.remove();
		//engine1Effect.allowCompletion();
		//engine2Effect.allowCompletion();
	}
}
