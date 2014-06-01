package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.GreenGun;
import com.haniel.Shooter.weapons.Weapon;

public class SuperGreenJet extends Enemy{
	
	protected double firingRate = 1.25;
	protected double frontFiringRate = .4;
	protected Weapon wingWeapon;
	
	
	public SuperGreenJet(double x, double y, List <Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = 70;
		this.width = 396;
		this.height = 100;
		this.sprite = new Sprite(superGreenJetTexture);		
		this.health = 230;
		this.xOffset = 2;
		this.yOffset = 50;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new GreenGun(level, false, 500);
		this.lastShot2 = level.getTime();
		this.wingWeapon = new GreenGun(level, false, 300);
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot2) > frontFiringRate) {	
				for (int i = 1; i < 8; i++) {								
					if (Math.abs((this.x + i * 50) - level.getPlayerX()) < 10) {
						lastShot2 = level.getTime();
						double shootingangle = level.getAngletoPlayersMiddle(this.x + i * 50, y + yOffset);
						if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
						weapon.shoot(this.x + i * 50, y + yOffset, shootingangle);
					}
				}
			}
			if ((level.getTime() - lastShot) > firingRate) {	        	
			    lastShot = level.getTime();
			    double shootingangle = level.getAngletoPlayersMiddle(x + 25, y + 100);
			    wingWeapon.shoot(x + 25, y + 100, shootingangle);
			    wingWeapon.shoot(x + 25, y + 100, shootingangle + .1);
			    wingWeapon.shoot(x + 25, y + 100, shootingangle - .1);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		       	shootingangle = level.getAngletoPlayersMiddle(x + 375, y + 50);
			    wingWeapon.shoot(x + 375, y + 100, shootingangle);
			    wingWeapon.shoot(x + 375, y + 100, shootingangle + .1);
			    wingWeapon.shoot(x + 375, y + 100, shootingangle - .1);
			    
	        	}
		}
	}
	public void particles() {
		if (health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/largegreenexplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			explosion02.play(.3f);
			explosion01.play(.3f);
			super.particles();
		}
	}
}
