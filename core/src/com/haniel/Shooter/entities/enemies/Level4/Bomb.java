package com.haniel.Shooter.entities.enemies.Level4;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class Bomb extends Enemy{
	
	private float delay;
	private PooledEffect effect;
	private float start = 0;
	private int firingSpeed = 50;
	private final static double firingAngle = 6;
	
	public Bomb(double x, double y, Level level, float delay){
		super(x, y, level);
		this.delay = delay;
		this.effect = level.smallExplosionEffect2Pool.obtain();
		this.rectangle = new Rectangle(1000, 1000, 0, 0);
		this.sprite = new Sprite(cloakingEnemyBombTexture0);
		rectangle.setPosition((float) x, (float) y);
		level.effects.add(this.effect);
		this.effect.start();
		this.effect.setPosition((int) x + width / 2,(int) y + width / 2);
		this.weapon = new SphereGun(level, firingSpeed);
	}
	
	public void update() {
		move(0, -10);
		this.effect.setPosition((int) x + width / 2,(int) y + width / 2);
		start += Gdx.graphics.getDeltaTime();
		if (start > delay) {
			for (int a = 0; a < 3; a++){
		    	for (int i = 1; i < 9; i ++) {
		    		weapon.shoot(x + 2, y + 2, firingAngle - (i * -.75));
		    	}
	    		firingSpeed += 50;
	    		weapon = new SphereGun(level, firingSpeed);
			}
			matches2.play();
	    	remove();
			
		}
	}
	public void particles() {
		
	}
	
	public void remove() {
		super.remove();
		this.effect.allowCompletion();
	}

}
