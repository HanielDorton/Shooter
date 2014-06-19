package com.haniel.Shooter.entities.enemies.Level3;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Pathing;
import com.haniel.Shooter.weapons.SphereGun;

public class GreenMine extends Enemy{
	
	protected double firingRate = .6;
	protected float rotation = 0f;
	private double lastX;
	
	public GreenMine(double x, double y, Level level, int p) {
		super(x, y, level);		
		this.speed = random.nextInt(20) + 30;
		this.width = 32;
		this.height = 32;
		this.sprite = new Sprite(greenMineTexture);		
		this.health = 3;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, false, 400);
		this.rotates = true;
		this.lastX = x;
		this.points = 10;

		switch (p) {
			case 1: {
				this.path = Pathing.mine1;
				break;
			}
			case 2: {
				this.path = Pathing.mine1;
				break;
			}
			case 3: {
				this.path = Pathing.mine3;
				break;
			}
			case 4: {
				this.path = Pathing.mine4;
				break;
			}
			case 5: {
				this.path = Pathing.mine5;
				break;
			}
			case 6: {
				this.path = Pathing.mine6;
				break;
			}
			case 7: {
				this.path = Pathing.mine7;
				break;
			}
			case 8: {
				this.path = Pathing.mine8;
				break;
			}
			case 9: {
				this.path = Pathing.mine9;
				break;
			}
			case 10: {
				this.path = Pathing.mine10;
				break;
			}
			default: {
				this.path = Pathing.mine11;
			}
		
		}
	}
	
	public void update() {
		super.update();
		if (rotation < 0) rotation = 360f;
		if (rotation > 360) rotation = 0;
		if (lastX > x) {
			rotation += 3;
		} else if (lastX < x) {
			rotation -=3;
		}
		lastX = x;
		sprite.setRotation(rotation);		
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
		if (health < 0)	explosion01.play(.5f);
		super.particles();
	}
}
