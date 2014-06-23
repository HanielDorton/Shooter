package com.haniel.Shooter.entities.enemies.Level4;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.SphereGun;

public class CloakingEnemyBombs extends CloakingEnemy{
	
	private float firingRate = .5f;
	private float delay = 2;
	
	public CloakingEnemyBombs(double x, double y, int moveX, int moveY, Level level) {
		super(x, y, level);
		this.moveX = moveX;
		this.moveY = moveY;
		this.width = 70;
		this.height = 118;
		sprites.add(new Sprite(cloakingEnemyBombTexture0));
		sprites.add(new Sprite(cloakingEnemyBombTexture05));
		sprites.add(new Sprite(cloakingEnemyBombTexture1));
		sprites.add(new Sprite(cloakingEnemyBombTexture15));
		sprites.add(new Sprite(cloakingEnemyBombTexture2));
		sprites.add(new Sprite(cloakingEnemyBombTexture25));
		sprites.add(new Sprite(cloakingEnemyBombTexture3));
		sprites.add(new Sprite(cloakingEnemyBombTexture35));
		sprites.add(new Sprite(cloakingEnemyBombTexture4));
		sprites.add(new Sprite(cloakingEnemyBombTexture45));
		sprites.add(new Sprite(cloakingEnemyBombTexture5));
		sprites.add(new Sprite(cloakingEnemyBombTexture6));
		sprites.add(new Sprite(cloakingEnemyBombTexture7));
		sprites.add(new Sprite(cloakingEnemyBombTexture8));
		sprites.add(new Sprite(cloakingEnemyBombTexture9));
		sprites.add(new Sprite(cloakingEnemyBombTexture10));
		this.sprite = sprites.get(currentSprite);	
		this.rectangle = new Rectangle(1000, 1000, 0, 0);
		this.cloakingRate = .25f;
		this.weapon = new SphereGun(level, false, 400);
	}
	
	public void update() {
		super.update();
	}
	
	public void shoot(){
		if ((level.getTime() - lastShot) > firingRate) {
 	    	lastShot = level.getTime();
	       	level.specialBossArray.add(new Bomb(x + (width /2) - 4, y + height /2, level, delay));
	       	delay += .25f;
	       	if (level.weaponSounds.size() < 3) level.weaponSounds.add(weapon);
		}
	}
}
