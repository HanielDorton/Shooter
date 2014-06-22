package com.haniel.Shooter.entities.enemies.Level3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;
import com.haniel.Shooter.weapons.Weapon;

public class GreenJet extends Enemy{
	
	protected double firingRate = 1.75;
	protected double frontFiringRate = .2;
	protected Weapon wingWeapon;
	
	public GreenJet(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);		
		this.speed = 6;
		this.width = 170;
		this.height = 30;
		this.sprite = new Sprite(greenJetTexture);		
		this.health = 160;
		this.xOffset = 15;
		this.yOffset = 35;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, false, 500);
		this.wingWeapon = new SphereGun(level, false, 200);
		this.lastShot2 = level.getTime() + 2;
		this.lastShot = level.getTime() + 2;
		this.points = 50;		
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot2) > frontFiringRate) {
				if (Math.abs(getMidX() - level.getPlayerX()) < 20) {
					lastShot2 = level.getTime();
					double shootingangle = level.getAngletoPlayersMiddle(x + xOffset + width / 2, y + yOffset);
					if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
					weapon.shoot(x + 100, y + 40, shootingangle);
				}
		}
	        if ((level.getTime() - lastShot) > firingRate) {	        	
			    lastShot = level.getTime();
			    double shootingangle = level.getAngletoPlayersMiddle(x + 40, y + 55);
			    wingWeapon.shoot(x + 40, y + 55, shootingangle);
			    wingWeapon.shoot(x + 40, y + 55, shootingangle + .2);
			    wingWeapon.shoot(x + 40, y + 55, shootingangle - .2);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		       	shootingangle = level.getAngletoPlayersMiddle(x + 159, y + 55);
			    wingWeapon.shoot(x + 159, y + 55, shootingangle);
			    wingWeapon.shoot(x + 159, y + 55, shootingangle + .2);
			    wingWeapon.shoot(x + 159, y + 55, shootingangle - .2);
			    
	        	}
        }

	}
	public void particles() {
		if (health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/thirdlevel/greenexplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			explosion02.play(.3f);
		}
	}
}
