package com.haniel.Shooter.weapons;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.projectiles.BlueLine;

public class BlueLineGun extends Weapon{

	public BlueLineGun(Level level, boolean fromPlayer) {
		super(level, fromPlayer);
		//this.sound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"))
	}
	
	public void shoot(double x, double y, double angle) {
		level.add(new BlueLine(x, y, angle, fromPlayer));
		
	}
}
