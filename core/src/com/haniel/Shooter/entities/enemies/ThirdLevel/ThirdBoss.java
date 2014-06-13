package com.haniel.Shooter.entities.enemies.ThirdLevel;

import java.util.Arrays;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
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
		this.width = 96;
		this.height = 38;
		this.sprite = new Sprite(thirdBossTexture);		
		this.health = 200;
		this.xOffset = 2;
		this.yOffset = 6;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new GreenGun(level, false, 500);
		this.lastShot =level.getTime();
		this.lastShot2 = level.getTime();
	}
	
	public void shoot() {
		if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	if (health > 50) generateRandomSuperMine(480);
	    	else generateRandomMine(480);
		}
		if ((level.getTime() - lastShot2) > secondFiringRate) {
			lastShot2 = level.getTime();
	       	double angle = level.getAngletoPlayersMiddle(x + xOffset, y + yOffset + height / 2 - 5);
	       	weapon.shoot(x + xOffset, y + yOffset + height / 2 - 5, angle);
	       	angle = level.getAngletoPlayersMiddle(x + width + xOffset, y + yOffset + height / 2 - 5);
	       	weapon.shoot(x + width + xOffset, y + yOffset + height / 2 - 5, angle);
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
        if (y > 400) move(0, -speed);
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
		Coord coord = new Coord(x, -500);
		List<Coord> temp = Arrays.asList(coord);
		level.specialBossArray.add(new SuperGreenMine(x, y, temp, level));
	}
	private void generateRandomMine(int y) {
		int x = random.nextInt(760) + 20;
		Coord coord = new Coord(x, -500);
		List<Coord> temp = Arrays.asList(coord);
		level.specialBossArray.add(new GreenMine(x, y, temp, level));
	}
}
