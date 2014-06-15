package com.haniel.Shooter.entities.enemies.Level1;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BlueSaucer extends Enemy{
	
	protected double firingRate = 1.7;
	protected final static double firingAngle = 3.4;

	public BlueSaucer(double x, double y, Level level) {
		super(x, y, level);
		this.speed = 40;
		this.width = 140;
		this.height = 30;
		this.sprite = new Sprite(blueSaucerTexture);		
		this.health = 200;
		this.xOffset = 5;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + 5;
	}
	public BlueSaucer(double x, double y, List<Coord> pattern, Level level) {
		this(x, y, level);
		this.speed = 40;
		this.destX = x;
		this.destY = y;
		this.position = 0;
		this.pattern = pattern;		
	}
	
	public BlueSaucer(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		this(x, y, level);
		this.speed = 6;
		this.path = path;
	}
	
	protected void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	for (int i = 1; i < 9; i ++) {
		    		weapon.shoot(x + 65 +(2 * i), y + 44, firingAngle - (i * -.3));
		    	}
		    	if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);
        	}
        }
    }

	public void particles() {
		if (health < 0) {
			ParticleEffect explosion = new ParticleEffect();
			explosion.load(Gdx.files.internal("particles/firstlevel/MediumBlueExplosion.p"), Gdx.files.internal("particles/"));
			explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
			level.particleEffects.add(explosion);
			explosion.start();
			explosion02.play(.3f);
		}
	}
}
	
