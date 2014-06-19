package com.haniel.Shooter.entities.enemies.Level3;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.graphics.HealthBar;
import com.haniel.Shooter.graphics.HealthBarOutline;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.GreenGun;

public class ThirdBoss extends Enemy{
	
	private float firingRate = 1.75f;
	private float secondFiringRate = .8f;
	private double center;
	
	public ThirdBoss(double x, double y, List <Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = 150;
		this.width = 85;
		this.height = 142;
		this.sprite = new Sprite(thirdBossTexture);		
		this.health = 400;
		this.xOffset = 5;
		this.yOffset = 5;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new GreenGun(level, false, 500);
		this.lastShot =level.getTime();
		this.lastShot2 = level.getTime();
		level.add(new HealthBarOutline(0));
		level.add(new HealthBar(this, 0));
	}
	
	public void shoot() {
		if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	if (health > 200) generateRandomSuperMine(480);
	    	else generateRandomMine(480);
		}
		if ((level.getTime() - lastShot2) > secondFiringRate) {
			lastShot2 = level.getTime();
	       	double angle = level.getAngletoPlayersMiddle(x + 14, y +50);
	       	weapon.shoot(x + 14, y + 50, angle);
	       	angle = level.getAngletoPlayersMiddle(x + 81, y + 50);
	       	weapon.shoot(x + 81, y + 50, angle);
	       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		}
	}
	
	public void update() {
		if (health < 0) remove();
        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
        if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) {
        	shoot();
        }
        center = x + xOffset + width / 2;
        if (center > level.getPlayerX()) move(-speed, 0);
        else if (center < level.getPlayerX()) move(speed, 0);
        if (y > 330) move(0, -speed);
        if (x< 0) x = 1;
        if (x > 700) x = 699;
        
	}
	public void particles() {
		if( health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/thirdlevel/largegreenexplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			explosion02.play(.3f);
			level.setLevelComplete();
		}
	}
	private void generateRandomSuperMine(int y) {
		int x = random.nextInt(760) + 20;
		level.specialBossArray.add(new SuperGreenMine(x, 480, level, random.nextInt(11)));
	}
	private void generateRandomMine(int y) {
		level.specialBossArray.add(new GreenMine(x, 480, level, random.nextInt(11)));
	}
}
