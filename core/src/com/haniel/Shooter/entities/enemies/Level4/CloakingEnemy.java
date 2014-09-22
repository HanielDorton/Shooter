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
	
	protected int moveX, moveY;
	protected List<Sprite> sprites = new LinkedList<Sprite>();
	protected int currentSprite;
	protected float changeSprite = 0;
	protected int direction = 1;
	protected float cloakingRate;
	protected float firingRate = .3f;
	private int firingSpeed =100;
	private float angleAdjustment = .2f;
	private double angle = getAngleTo(x, y, x, y+10);
	private double angle2 = getAngleTo(x,y, x+5, y -2);
	private double angle3 = getAngleTo(x,y, x-5, y -2);
	
	public CloakingEnemy(double x, double y, Level level) {
		super(x, y, level);
	}
	
	public CloakingEnemy(double x, double y, int moveX, int moveY, Level level) {
		this(x, y, level);	
		this.moveX = moveX;
		this.moveY = moveY;
		this.speed = 0;
		this.width = 66;
		this.height = 117;
		sprites.add(new Sprite(cloakingEnemyTexture0));
		sprites.add(new Sprite(cloakingEnemyTexture05));
		sprites.add(new Sprite(cloakingEnemyTexture1));
		sprites.add(new Sprite(cloakingEnemyTexture15));
		sprites.add(new Sprite(cloakingEnemyTexture2));
		sprites.add(new Sprite(cloakingEnemyTexture25));
		sprites.add(new Sprite(cloakingEnemyTexture3));
		sprites.add(new Sprite(cloakingEnemyTexture35));
		sprites.add(new Sprite(cloakingEnemyTexture4));
		sprites.add(new Sprite(cloakingEnemyTexture45));
		sprites.add(new Sprite(cloakingEnemyTexture5));
		sprites.add(new Sprite(cloakingEnemyTexture6));
		sprites.add(new Sprite(cloakingEnemyTexture7));
		sprites.add(new Sprite(cloakingEnemyTexture8));
		sprites.add(new Sprite(cloakingEnemyTexture9));
		sprites.add(new Sprite(cloakingEnemyTexture10));
		
		this.sprite = sprites.get(currentSprite);	
		this.health = 4;
		this.xOffset = 1;
		this.yOffset = 15;
		this.rectangle = new Rectangle(1000, 1000, 0, 0);
		this.weapon = new SphereGun(level, firingSpeed);
		this.points = 20;
		this.cloakingRate = .15f;
	}
	public void update() {
        if (health < 0) remove();
        move(moveX, moveY);
		changeSprite += Gdx.graphics.getDeltaTime();
		if (changeSprite > cloakingRate) {
			changeSprite = 0;
			currentSprite += direction;
			if (currentSprite == 15) direction = -1;
			if (currentSprite == 0) remove();
			this.sprite = sprites.get(currentSprite);	
		}
		if (currentSprite > 12) {
			shoot();
	        rectangle.set((float)x, (float)y, width, height);
		}
		else {
	        rectangle.set(1000, 1000, 0, 0);
		}
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
 	    	lastShot = level.getTime();
	       	weapon.shoot(x + (width / 2), y + height, angle + angleAdjustment);
	       	weapon.shoot(x + (width / 2), y + height, angle - angleAdjustment);
	       	weapon.shoot(x + 42, y, angle2 + angleAdjustment);
	       	weapon.shoot(x + 42, y, angle2 - angleAdjustment);
	       	weapon.shoot(x + 30, y, angle3 + angleAdjustment);
	       	weapon.shoot(x + 30, y, angle3 - angleAdjustment);
	       	firingSpeed += 25;
	       	this.weapon = new SphereGun(level, firingSpeed);
	       	if (level.weaponSounds.size() == 0) level.weaponSounds.add(weapon);
        }
	}
}
