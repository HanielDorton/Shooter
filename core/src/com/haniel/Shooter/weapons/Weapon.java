package com.haniel.Shooter.weapons;

import com.badlogic.gdx.audio.Sound;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BasicBullet;

public abstract class Weapon {

	protected double firingRate;
	protected float x, y;
	protected Level level;
	protected Sound sound;
	
	//set firing rates so they can be accessed before projectiles are created:
	protected final static double basicGunFiringRate = 0.2;
	protected final static double blueSphereGunFiringRate = 0.5;
	
	
	public Weapon(Level level) {
		this.level = level;
	}
	
	public double getFiringRate(){
		return firingRate;
	}

	public void shoot(float x, float y, double dir) {
		level.add(new BasicBullet(x, y, 0));
	}
	
	public void playSound() {
		sound.play();
		
	}
}
