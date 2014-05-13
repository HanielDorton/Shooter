package com.haniel.Shooter.entities.enemies.FirstLevel;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BlueSaucer extends Enemy{
	
	protected double firingRate = 1;
	protected double firingAngle = 3;

	public BlueSaucer(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 40;
		this.width = 140;
		this.height = 48;
		this.sprite = new Sprite(blueSaucerTexture);		
		this.health = 100;
		this.xOffset = 5;
		this.yOffset = 5;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + 5;
	}
	
	protected void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	for (int i = 1; i < 9; i ++) {
		    		weapon.shoot(x + (16 * i), y + yOffset + 5, firingAngle - (i * -.375));
		    	}
		    	if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);
        	}
        }
    }
	
	public void update(){
		super.update();
		///add engine particle effects here
	}
	
	public void particles() {
		if (health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/firstlevel/MediumBlueExplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			matches2.play();
		}
	}
}
	
