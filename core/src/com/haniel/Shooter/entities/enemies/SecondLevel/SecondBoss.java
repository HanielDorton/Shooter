package com.haniel.Shooter.entities.enemies.SecondLevel;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;

public class SecondBoss extends Enemy{
	
	private ParticleEffect engine1Effect = new ParticleEffect();
	private int startEngines;
	private float firingRate = 5;
	private float secondFiringRate = 2.5f;
	private double secondLastShot = 0;
	private boolean difficult;
	
	public SecondBoss(double x, double y, List<Coord> pattern, Level level, boolean difficult) {
		super(x, y, pattern, level);
		this.sprite = new Sprite(secondBossTexture);	
		this.width = 140;
		this.xOffset = 10;
		this.height = 770;
		this.health = 300;
		this.speed = 50;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.engine1Effect.load(Gdx.files.internal("particles/secondlevel/bossexhaust.p"), Gdx.files.internal("particles/"));
		this.lastShot = level.getTime() + 5;
		this.startEngines =level.getLevelTime() + 750;
		this.difficult = difficult;		
	}

	public void update() {
        super.update();
        if (startEngines == level.getLevelTime()) {
        	this.engine1Effect.setPosition((int)x,(int) y-10);
        	level.overlayedParticleEffects.add(engine1Effect);
        	engine1Effect.start();; 
        }
        if (startEngines < level.getLevelTime()) this.engine1Effect.setPosition((int)x,(int) y-10);
        
	}
	public void particles() {
		if( health < 0) {
			engine1Effect.allowCompletion();
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/secondlevel/bossexplosions2.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y  + 100);
			level.particleEffects.add(explosion);
			explosion.start();
			level.setLevelComplete();
			explosion02.play(.5f);
		}
	}
	public void shoot() {
		if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	level.specialBossArray.add(new HomingMissile(x + 5, y + 44 + (100), null, level));
	    	level.specialBossArray.add(new HomingMissile(x + 154, y + 44 + (100), null, level));
	    	if (difficult) level.specialBossArray.add(new HomingMissile(x + 5, y + 44 + (200), null, level));
	    	if (difficult) level.specialBossArray.add(new HomingMissile(x + 154, y + 44 + (200), null, level));
	    	level.specialBossArray.add(new HomingMissile(x + 5, y + 44 + (300), null, level));
	    	level.specialBossArray.add(new HomingMissile(x + 154, y + 44 + (300), null, level));

	    	level.specialBossArray.add(new PlayerClone(390, 600, Coord.leavebottomleftlist, level));
    		level.specialBossArray.add(new PlayerClone(410, 600, Coord.leavebottomrightlist, level));
		}
		if (health < 150) {
			if ((level.getTime() - secondLastShot) > secondFiringRate) {
		    	secondLastShot = level.getTime();
		    	level.specialBossArray.add(new ImprovedPlayerClone(0, 600, null, level));
		    	level.specialBossArray.add(new ImprovedPlayerClone(800, 600, null, level));
			}
		}
	}
	public void remove() {
		super.remove();
		engine1Effect.allowCompletion();
	}
}
