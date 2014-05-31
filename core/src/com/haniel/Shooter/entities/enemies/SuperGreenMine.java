package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.GreenGun;

public class SuperGreenMine extends Enemy{
		
		protected double firingRate = .8;
		protected final static double firingAngle = 3;
		
		public SuperGreenMine(double x, double y, List <Coord> pattern, Level level) {
			super(x, y, pattern, level);		
			this.speed = random.nextInt(30) + 40;
			this.width = 16;
			this.height = 16;
			this.sprite = new Sprite(greenMineTexture);		
			this.health = 0;
			this.xOffset = 0;
			this.yOffset = 0;
			this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
			this.weapon = new GreenGun(level, false, 200);
		}
		
		protected void shoot() {
			if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
				if ((level.getTime() - lastShot) > firingRate) {
					lastShot = level.getTime();
			    	for (int i = 1; i < 18; i ++) {
			    		weapon.shoot(x + 8, y + 8, firingAngle - (i * -.375));
			    	}
			    	if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);

				}
			}
		}
	}


