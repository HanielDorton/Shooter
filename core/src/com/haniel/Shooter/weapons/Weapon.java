package com.haniel.Shooter.weapons;

import com.badlogic.gdx.audio.Sound;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.level.Level;

public abstract class Weapon {

	protected double firingRate;
	protected Level level;
	protected Sound sound;
	protected int speed;
	
	//set firing rates so they can be accessed before projectiles are created:
	protected final static double basicGunFiringRate = 0.2;
	
	
	//load all sounds once:
	//every time you add a new one add it to dispose() at the bottom.
	protected Sound basicGunSound = Assets.manager.get("sounds/gunshot01.wav", Sound.class);
	protected Sound smatterZap1 = Assets.manager.get("sounds/smatter-zap1.wav", Sound.class);
	
	
	
	public Weapon(Level level) {
		this.level = level;
	}
	
	public double getFiringRate(){
		return firingRate;
	}

	public void shoot(double x, double y, double angle) {
		level.addPlayerProjectile(new PlayerBullet(x, y, angle));
	}
	
	public void playSound() {
		sound.play();
		
	}
	
	public void changeSpeed( int speed) {
		this.speed = speed;
	}
}
