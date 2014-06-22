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

public class SuperGreenJet extends Enemy{
	
	protected double firingRate = 1.75;
	protected double frontFiringRate = .2;
	protected Weapon wingWeapon;
	
	
	public SuperGreenJet(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);		
		this.speed = 10;
		this.width = 340;
		this.height = 60;
		this.sprite = new Sprite(superGreenJetTexture);		
		this.health = 440;
		this.xOffset = 30;
		this.yOffset = 70;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, false, 500);
		this.lastShot2 = level.getTime();
		this.wingWeapon = new SphereGun(level, false, 300);
		this.points = 100;
	}
	public void update() {
		if (level.getTime() > 52){
				move(-50, 30);
		        if (y < 0 - this.height - 300) remove();
		        if (y > level.getHeight() + this.height + 300) remove();
		        if (x > level.getWidth() + this.width + 300) remove();
		        if (x < 0 - this.width - 300) remove();
		        if (health < 0) remove();
		        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
		        if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) shoot();
		    
		} else if (y > 270) {
			move(50, -50);
	        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	        if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) {
	        	shoot();
	        }
		} else {
			super.update();
		}
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot2) > frontFiringRate) {	
				if (Math.abs(getMidX() - level.getPlayerX()) < 20) {
					lastShot2 = level.getTime();
					double shootingangle = level.getAngletoPlayersMiddle(x + xOffset + width / 2, y + height / 2);
					if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
					weapon.shoot(x + xOffset + width / 2, y + height, shootingangle);
				}
			}
			if ((level.getTime() - lastShot) > firingRate) {	        	
			    lastShot = level.getTime();
			    double shootingangle = level.getAngletoPlayersMiddle(x + 50, y + 170);
			    wingWeapon.shoot(x + 50, y + 170, shootingangle);
			    wingWeapon.shoot(x + 50, y + 170, shootingangle + .1);
			    wingWeapon.shoot(x + 50, y + 170, shootingangle - .1);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		       	shootingangle = level.getAngletoPlayersMiddle(x + 350, y + 170);
			    wingWeapon.shoot(x + 350, y + 170, shootingangle);
			    wingWeapon.shoot(x + 350, y + 170, shootingangle + .1);
			    wingWeapon.shoot(x + 350, y + 170, shootingangle - .1);
			    
	        	}
		}
	}
	public void particles() {
		if (health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/thirdlevel/largegreenexplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			explosion02.play(.3f);
			explosion01.play(.3f);
			super.particles();
		}
	}
}
