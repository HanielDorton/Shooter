package com.haniel.Shooter.entities.enemies.Level4;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.enemies.Enemy;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class CloakingEnemy extends Enemy{
	
	private int moveX, moveY;
	private List<Sprite> sprites = new LinkedList<Sprite>();
	private int currentSprite;
	private float changeSprite = 0;
	private int direction = 1;
	private float firingRate = .25f;
	
	public CloakingEnemy(double x, double y, int moveX, int moveY, Level level) {
		super(x, y, level);	
		this.moveX = moveX;
		this.moveY = moveY;
		this.speed = 10;
		this.width = 66;
		this.height = 117;
		sprites.add(new Sprite(cloakingEnemyTexture0));
		sprites.add(new Sprite(cloakingEnemyTexture1));
		sprites.add(new Sprite(cloakingEnemyTexture2));
		sprites.add(new Sprite(cloakingEnemyTexture3));
		sprites.add(new Sprite(cloakingEnemyTexture4));
		sprites.add(new Sprite(cloakingEnemyTexture5));
		sprites.add(new Sprite(cloakingEnemyTexture6));
		sprites.add(new Sprite(cloakingEnemyTexture7));
		sprites.add(new Sprite(cloakingEnemyTexture8));
		sprites.add(new Sprite(cloakingEnemyTexture9));
		sprites.add(new Sprite(cloakingEnemyTexture10));
		
		this.sprite = sprites.get(currentSprite);	
		this.health = 10;
		this.xOffset = 1;
		this.yOffset = 15;
		this.rectangle = new Rectangle(1000, 1000, 0, 0);
		this.weapon = new SphereGun(level, false, 100);
		this.points = 10;
	}
	public void update() {
        if (health < 0) remove();
        move(moveX, moveY);
		changeSprite += Gdx.graphics.getDeltaTime();
		if (changeSprite > .2) {
			changeSprite = 0;
			currentSprite += direction;
			if (currentSprite == 10) direction = -1;
			if (currentSprite == 0) remove();
			this.sprite = sprites.get(currentSprite);	
		}
		if (currentSprite > 8) {
			shoot();
	        rectangle.set((float)x, (float)y, width, height);
		}
		else {
	        rectangle.set(1000, 1000, 0, 0);
		}
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
        	if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
		    	lastShot = level.getTime();
		    	double angle = level.getAngletoPlayersMiddle(x + (width / 2), y + height);
		       	weapon.shoot(x + (width / 2), y + height, angle);
		       	weapon.shoot(x + (width / 2), y + height, angle + .03);
		       	weapon.shoot(x + (width / 2), y + height, angle - .03);
		       	weapon.shoot(x + (width / 2), y + height, angle + .06);
		       	weapon.shoot(x + (width / 2), y + height, angle - .06);
		       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
		
        	}

        }
	}
}
