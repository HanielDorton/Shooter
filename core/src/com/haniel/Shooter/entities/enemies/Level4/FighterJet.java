package com.haniel.Shooter.entities.enemies.Level4;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Pathing;
import com.haniel.Shooter.weapons.SphereGun;

public class FighterJet extends Enemy{
	
	protected double firingRate = .35;
	private double angle = getAngleTo(x, y+10, x, y-10);
	//private float angleOffset = 0;
	//private float anglChange = .1f;
	private int weaponSpeed = 100;

	public FighterJet(double x, double y, int p, Level level) {
		super(x, y, level);
		this.width = 66;
		this.xOffset = 2;
		this.height = 110;
		this.yOffset = 3;
		this.speed = 40;
		this.health = 10;
		this.sprite = new Sprite(fighterJetTexture);
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, weaponSpeed);
		this.points = 20;
		switch (p) {
			case 1: {
				this.path = Pathing.jet1;
				break;
			}
			case 2: {
				this.path = Pathing.jet2;
				break;
			}
			case 3: {
				this.path = Pathing.jet3;
				break;
			}
			case 4: {
				this.path = Pathing.jet4;
				break;
			}
			case 5: {
				this.path = Pathing.jet5;
				break;
			}
			case 6: {
				this.path = Pathing.jet6;
				break;
			}
			case 7: {
				this.path = Pathing.jet7;
				break;
			}
			case 8: {
				this.path = Pathing.jet8;
				break;
			}
			default: {
				this.path = Pathing.jet9;
			}	
		}
	}
	protected void shoot() {
	    if ((level.getTime() - lastShot) > firingRate) {
	    	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	weapon.shoot(x + xOffset + width / 2, y, angle);
		    	weaponSpeed += 35;
				this.weapon = new SphereGun(level, weaponSpeed);
		    	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
	    	}
	    }
	}
}
