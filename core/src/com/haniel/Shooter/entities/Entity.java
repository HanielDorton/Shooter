package com.haniel.Shooter.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.Weapon;
public abstract class Entity{
	
	protected double x, y, speed, destX, destY;
	protected double angle;
	protected int xOffset, yOffset;
	protected int position;
	protected int width, height;
	protected Sprite sprite;
	protected boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected Rectangle rectangle;
	protected float health;
	protected Weapon weapon;
	protected double lastShot, lastShot2, lastShot3;
	protected boolean rotates = false;
	protected float rotation = 0;
	
	//all entity textures so they are only loaded once:
	//every time you add a new one add it to dispose() at the bottom.
	protected Sound explosion02 = Assets.manager.get("sounds/explosion-02.wav", Sound.class);
	//level one
	protected Texture enemy1Texture = Assets.manager.get("entities/Level1/alien1.png", Texture.class);
	protected Sound matches2 = Assets.manager.get("sounds/paper-rip-4.wav", Sound.class);
	protected Texture blueSaucerTexture = Assets.manager.get("entities/Level1/alien2.png", Texture.class);
	protected Texture quickBlueTexture = Assets.manager.get("entities/Level1/alien3.png", Texture.class);
	protected Texture firstBossTexture = Assets.manager.get("entities/Level1/first_boss0.png", Texture.class);
	//level two
	protected Texture redEnemyTexture = Assets.manager.get("entities/Level2/aliensprite2.png", Texture.class);
	protected Texture cargoCraftTexture = Assets.manager.get("entities/Level2/smallorange.png", Texture.class);
	protected Texture cargoCraft2Texture = Assets.manager.get("entities/Level2/smallorange2.png", Texture.class);
	protected Texture starTexture = Assets.manager.get("textures/star.png", Texture.class);
	protected Sound explosion01 = Assets.manager.get("sounds/explosion-01.wav", Sound.class);
	protected Sound irritatingAmbiantBuzz = Assets.manager.get("sounds/irritating-ambient-buzz.wav", Sound.class);
	protected Texture secondBossTexture = Assets.manager.get("entities/Level2/orangeship.png", Texture.class);
	//level three
	protected Texture greenJetTexture = Assets.manager.get("entities/Level3/smalljet.png", Texture.class);
	protected Texture superGreenJetTexture = Assets.manager.get("entities/Level3/destroyer1.png", Texture.class);
	protected Texture greenMineTexture = Assets.manager.get("entities/Level3/Spacestation-by-MillionthVector.png", Texture.class);
	protected Texture thirdBossTexture = Assets.manager.get("entities/Level3/spaceshipspr.png", Texture.class);
	//level four
	protected Texture cloakingEnemyTexture0 = Assets.manager.get("entities/Level4/F5S3-0.png", Texture.class);
	protected Texture cloakingEnemyTexture05 = Assets.manager.get("entities/Level4/F5S3-05.png", Texture.class);
	protected Texture cloakingEnemyTexture1 = Assets.manager.get("entities/Level4/F5S3-1.png", Texture.class);
	protected Texture cloakingEnemyTexture15 = Assets.manager.get("entities/Level4/F5S3-15.png", Texture.class);
	protected Texture cloakingEnemyTexture2 = Assets.manager.get("entities/Level4/F5S3-2.png", Texture.class);
	protected Texture cloakingEnemyTexture25 = Assets.manager.get("entities/Level4/F5S3-25.png", Texture.class);
	protected Texture cloakingEnemyTexture3 = Assets.manager.get("entities/Level4/F5S3-3.png", Texture.class);
	protected Texture cloakingEnemyTexture35 = Assets.manager.get("entities/Level4/F5S3-35.png", Texture.class);
	protected Texture cloakingEnemyTexture4 = Assets.manager.get("entities/Level4/F5S3-4.png", Texture.class);
	protected Texture cloakingEnemyTexture45 = Assets.manager.get("entities/Level4/F5S3-45.png", Texture.class);
	protected Texture cloakingEnemyTexture5 = Assets.manager.get("entities/Level4/F5S3-5.png", Texture.class);
	protected Texture cloakingEnemyTexture6 = Assets.manager.get("entities/Level4/F5S3-6.png", Texture.class);
	protected Texture cloakingEnemyTexture7 = Assets.manager.get("entities/Level4/F5S3-7.png", Texture.class);
	protected Texture cloakingEnemyTexture8 = Assets.manager.get("entities/Level4/F5S3-8.png", Texture.class);
	protected Texture cloakingEnemyTexture9 = Assets.manager.get("entities/Level4/F5S3-9.png", Texture.class);
	protected Texture cloakingEnemyTexture10 = Assets.manager.get("entities/Level4/F5S3.png", Texture.class);
	
	protected Texture cloakingEnemyBombTexture0 = Assets.manager.get("entities/Level4/F5S1-0.png", Texture.class);
	protected Texture cloakingEnemyBombTexture05 = Assets.manager.get("entities/Level4/F5S1-05.png", Texture.class);
	protected Texture cloakingEnemyBombTexture1 = Assets.manager.get("entities/Level4/F5S1-1.png", Texture.class);
	protected Texture cloakingEnemyBombTexture15 = Assets.manager.get("entities/Level4/F5S1-15.png", Texture.class);
	protected Texture cloakingEnemyBombTexture2 = Assets.manager.get("entities/Level4/F5S1-2.png", Texture.class);
	protected Texture cloakingEnemyBombTexture25 = Assets.manager.get("entities/Level4/F5S1-25.png", Texture.class);
	protected Texture cloakingEnemyBombTexture3 = Assets.manager.get("entities/Level4/F5S1-3.png", Texture.class);
	protected Texture cloakingEnemyBombTexture35 = Assets.manager.get("entities/Level4/F5S1-35.png", Texture.class);
	protected Texture cloakingEnemyBombTexture4 = Assets.manager.get("entities/Level4/F5S1-4.png", Texture.class);
	protected Texture cloakingEnemyBombTexture45 = Assets.manager.get("entities/Level4/F5S1-45.png", Texture.class);
	protected Texture cloakingEnemyBombTexture5 = Assets.manager.get("entities/Level4/F5S1-5.png", Texture.class);
	protected Texture cloakingEnemyBombTexture6 = Assets.manager.get("entities/Level4/F5S1-6.png", Texture.class);
	protected Texture cloakingEnemyBombTexture7 = Assets.manager.get("entities/Level4/F5S1-7.png", Texture.class);	
	protected Texture cloakingEnemyBombTexture8 = Assets.manager.get("entities/Level4/F5S1-8.png", Texture.class);
	protected Texture cloakingEnemyBombTexture9 = Assets.manager.get("entities/Level4/F5S1-9.png", Texture.class);
	protected Texture cloakingEnemyBombTexture10 = Assets.manager.get("entities/Level4/F5S1.png", Texture.class);
	
	protected Texture fighterJetTexture = Assets.manager.get("entities/Level4/F5S4.png", Texture.class);
	
	//Level Five:
	protected Texture transportShipTexture = Assets.manager.get("entities/Level5/3.png", Texture.class);
	protected Texture weaponsPlatformTexture = Assets.manager.get("entities/Level5/2.png", Texture.class);
	protected Texture lastBosstexture = Assets.manager.get("entities/Level5/5.png", Texture.class);
	protected Texture smallTransportShipTexture = Assets.manager.get("entities/Level5/11.png", Texture.class);
	protected Texture mediumTransportShipTexture = Assets.manager.get("entities/Level5/13.png", Texture.class);
	public Entity() {
		
	}
	
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		ya *= Gdx.graphics.getDeltaTime();//  * speed);
		xa *= Gdx.graphics.getDeltaTime();//  * speed);
		
		while (xa != 0) {
			if(Math.abs(xa) > 1) {
				this.x += myAbs(xa);
				xa -= myAbs(xa);		
			}
			else {
				this.x += xa;
				xa = 0;
			}			
		}	
		
		while (ya != 0) {
			if(Math.abs(ya) > 1) {
				this.y += myAbs(ya) ;
				ya -= myAbs(ya);
			} else {
				this.y += ya;
				ya = 0;
			}
		}
		
	}
	
	protected int myAbs(double value) {
		if (value < 0) return -1;
		else return 1;
	}
	
	public void damage(double damage) {
		health -= damage;
		particles();
	}
				
	public void particles() {
		System.out.println("No particles set up");
	}
	
	public void update() {
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
		
	}

	
	public void remove() {
		removed = true;
	}
	
	public double getX() {
		return x;	
	}
	
	public double getY() {
		return y;
	}
	
	public double getMidX() {
		return x + xOffset + (width / 2);
		
	}
	public double getMidY() {
		return y + yOffset + (height / 2);
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}	
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(Level level) {
		this.level = level;
	}
	public double getAngleTo(double x, double y, double destX, double destY) {
		return (Math.atan2(destY - y, destX - x));	
	}	
	
	public Sprite getSprite() {
		return sprite;
	}
	public boolean rotates() {
		return rotates;
	}
	public float getRotation() {
		return rotation;
	}
	public float getOriginX() {
		return (float)xOffset + (width / 2);
	}
	public float getOriginY() {
		return (float)yOffset + (height / 2);
	}
	public float getHealth() {
		return health;
	}
}