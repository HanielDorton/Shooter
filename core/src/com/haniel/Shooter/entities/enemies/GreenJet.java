package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.GreenGun;
import com.haniel.Shooter.weapons.Weapon;

public class GreenJet extends Enemy{
	
	protected double firingRate = 1.75;
	protected double frontFiringRate = .2;
	protected Weapon wingWeapon;
	
	public GreenJet(double x, double y, List <Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = 50;
		this.width = 196;
		this.height = 50;
		this.sprite = new Sprite(greenJetTexture);		
		this.health = 80;
		this.xOffset = 2;
		this.yOffset = 25;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new GreenGun(level, false, 600);
		this.wingWeapon = new GreenGun(level, false, 200);
		this.lastShot2 = level.getTime();

		
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot2) > frontFiringRate) {
				lastShot2 = level.getTime();
				if (Math.abs(getMidX() - level.getPlayerX()) < 20) {
					double shootingangle = level.getAngletoPlayersMiddle(x + xOffset + width / 2, y + yOffset + height / 2 - 5);
					if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
					weapon.shoot(x + xOffset + width / 2, y + yOffset + height / 2 - 5, shootingangle);
				}
		}
	        if ((level.getTime() - lastShot) > firingRate) {	        	
			    lastShot = level.getTime();
			    double shootingangle = level.getAngletoPlayersMiddle(x + 25, y + 50);
			    wingWeapon.shoot(x + 25, y + 50, shootingangle);
			    wingWeapon.shoot(x + 25, y + 50, shootingangle + .2);
			    wingWeapon.shoot(x + 25, y + 50, shootingangle - .2);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		       	shootingangle = level.getAngletoPlayersMiddle(x + 175, y + 50);
			    wingWeapon.shoot(x + 175, y + 50, shootingangle);
			    wingWeapon.shoot(x + 175, y + 50, shootingangle + .2);
			    wingWeapon.shoot(x + 175, y + 50, shootingangle - .2);
			    
	        	}
        }

	}	
}
