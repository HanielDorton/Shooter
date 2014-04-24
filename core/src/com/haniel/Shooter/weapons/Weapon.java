package com.haniel.Shooter.weapons;

import com.badlogic.gdx.audio.Sound;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BasicBullet;

public abstract class Weapon {

	protected double firingRate;
	//protected float x, y;
	protected Level level;
	protected Sound sound;
	protected boolean fromPlayer;
	
	//set firing rates so they can be accessed before projectiles are created:
	protected final static double basicGunFiringRate = 0.2;

	
	public Weapon(Level level, boolean fromPlayer) {
		this.level = level;
		this.fromPlayer = fromPlayer;
	}
	
	public double getFiringRate(){
		return firingRate;
	}

	public void shoot(double x, double y, double angle) {
		level.add(new BasicBullet(x, y, angle, fromPlayer));
	}
	
	public void playSound() {
		sound.play();
		
	}

}
