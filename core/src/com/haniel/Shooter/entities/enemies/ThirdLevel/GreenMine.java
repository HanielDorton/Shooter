package com.haniel.Shooter.entities.enemies.ThirdLevel;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.GreenGun;

public class GreenMine extends Enemy{
	
	protected double firingRate = .6;
	
	public GreenMine(double x, double y, List <Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = random.nextInt(30) + 20;
		this.width = 16;
		this.height = 16;
		this.sprite = new Sprite(greenMineTexture);		
		this.health = 0;
		this.xOffset = 0;
		this.yOffset = 0;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new GreenGun(level, false, 400);
	}
	
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			if ((level.getTime() - lastShot) > firingRate) {
				lastShot = level.getTime();
		       	double angle = level.getAngletoPlayersMiddle(x + xOffset + width / 2, y + yOffset + height / 2 - 5);
		       	weapon.shoot(x + xOffset + width / 2, y + yOffset + height / 2 - 5, angle);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
			}
		}
	}
	public void particles() {
		explosion01.play(.5f);
		super.particles();
	}
}
