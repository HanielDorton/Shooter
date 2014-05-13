package com.haniel.Shooter.weapons;

import com.badlogic.gdx.Gdx;
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
	
	
	//load all sounds once:
	//every time you add a new one add it to dispose() at the bottom.
	protected final static Sound basicGunSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"));
	protected final static Sound waterdropletSound = Gdx.audio.newSound(Gdx.files.internal("sounds/water-droplet-1.wav"));
	protected final static Sound whipwooshSound = Gdx.audio.newSound(Gdx.files.internal("sounds/whip-whoosh-03.wav"));
	protected final static Sound explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion-01.wav"));
	
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
	public static void dispose() {
		basicGunSound.dispose();
	}

}
