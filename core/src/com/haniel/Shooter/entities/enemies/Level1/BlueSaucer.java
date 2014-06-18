package com.haniel.Shooter.entities.enemies.Level1;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class BlueSaucer extends Enemy{
	
	protected double firingRate = 1.7;
	protected final static double firingAngle = 3.4;
	private List<Sprite> sprites = new LinkedList<Sprite>();
	private int currentSprite;
	private float changeSprite = 0;
	private int direction = 1;
	

	public BlueSaucer(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, level);
		this.speed = 6;
		this.width = 140;
		this.height = 30;
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2.png"))));
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2-1.png"))));
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2-2.png"))));
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2-3.png"))));
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2-4.png"))));
		sprites.add(new Sprite(new Texture(Gdx.files.internal("entities/Level1/alien2-5.png"))));
		this.currentSprite = 0;
		this.sprite = sprites.get(currentSprite);	
		this.health = 200;
		this.xOffset = 5;
		this.yOffset = 15;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new SphereGun(level, false, 130);
		this.lastShot = level.getTime() + 5;
		this.path = path;
	}
	
	public void update() {
		super.update();
		changeSprite += Gdx.graphics.getDeltaTime();
		if (changeSprite > .17f) {
			changeSprite = 0;
			currentSprite += direction;
			if (currentSprite > sprites.size() -2) direction = -1;
			if (currentSprite < 1) direction = 1;
			this.sprite = sprites.get(currentSprite);			
		}
		
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
	
