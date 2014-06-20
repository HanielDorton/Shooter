package com.haniel.Shooter.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
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
	protected static final Sound explosion02 = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion-02.wav"));
	//level one
	protected static final Texture enemy1Texture = new Texture(Gdx.files.internal("entities/Level1/alien1.png"));
	protected static final Sound matches2 = Gdx.audio.newSound(Gdx.files.internal("sounds/paper-rip-4.wav"));
	protected static final Texture blueSaucerTexture = new Texture(Gdx.files.internal("entities/Level1/alien2.png"));
	protected static final Texture quickBlueTexture = new Texture(Gdx.files.internal("entities/Level1/alien3.png"));
	protected static final Texture firstBossTexture = new Texture(Gdx.files.internal("entities/Level1/first_boss0.png"));
	//level two
	protected static final Texture redEnemyTexture = new Texture(Gdx.files.internal("entities/Level2/aliensprite2.png"));
	protected static final Texture cargoCraftTexture = new Texture(Gdx.files.internal("entities/Level2/smallorange.png"));
	protected static final Texture cargoCraft2Texture = new Texture(Gdx.files.internal("entities/Level2/smallorange2.png"));
	protected static final Texture starTexture = new Texture(Gdx.files.internal("textures/star.png"));
	protected static final Sound explosion01 = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion-01.wav"));
	protected static final Sound irritatingAmbiantBuzz = Gdx.audio.newSound(Gdx.files.internal("sounds/irritating-ambient-buzz.wav"));
	protected static final Texture secondBossTexture = new Texture(Gdx.files.internal("entities/Level2/orangeship.png"));
	//level three
	protected static final Texture greenJetTexture = new Texture(Gdx.files.internal("entities/Level3/smalljet.png"));
	protected static final Texture superGreenJetTexture = new Texture(Gdx.files.internal("entities/Level3/destroyer1.png"));
	protected static final Texture greenMineTexture = new Texture(Gdx.files.internal("entities/Level3/Spacestation-by-MillionthVector.png"));
	protected static final Texture thirdBossTexture = new Texture(Gdx.files.internal("entities/Level3/spaceshipspr.png"));
	//level four
	protected static final Texture cloakingEnemyTexture0 = new Texture(Gdx.files.internal("entities/Level4/F5S3-0.png"));
	protected static final Texture cloakingEnemyTexture1 = new Texture(Gdx.files.internal("entities/Level4/F5S3-1.png"));
	protected static final Texture cloakingEnemyTexture2 = new Texture(Gdx.files.internal("entities/Level4/F5S3-2.png"));
	protected static final Texture cloakingEnemyTexture3 = new Texture(Gdx.files.internal("entities/Level4/F5S3-3.png"));
	protected static final Texture cloakingEnemyTexture4 = new Texture(Gdx.files.internal("entities/Level4/F5S3-4.png"));
	protected static final Texture cloakingEnemyTexture5 = new Texture(Gdx.files.internal("entities/Level4/F5S3-5.png"));
	protected static final Texture cloakingEnemyTexture6 = new Texture(Gdx.files.internal("entities/Level4/F5S3-6.png"));
	protected static final Texture cloakingEnemyTexture7 = new Texture(Gdx.files.internal("entities/Level4/F5S3-7.png"));
	protected static final Texture cloakingEnemyTexture8 = new Texture(Gdx.files.internal("entities/Level4/F5S3-8.png"));
	protected static final Texture cloakingEnemyTexture9 = new Texture(Gdx.files.internal("entities/Level4/F5S3-9.png"));
	protected static final Texture cloakingEnemyTexture10 = new Texture(Gdx.files.internal("entities/Level4/F5S3.png"));
	
	
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
	
	public static void dispose() {
		enemy1Texture.dispose();
		matches2.dispose();
		blueSaucerTexture.dispose();
		quickBlueTexture.dispose();
		firstBossTexture.dispose();
		redEnemyTexture.dispose();
		explosion02.dispose();
		cargoCraftTexture.dispose();
		cargoCraft2Texture.dispose();
		secondBossTexture.dispose();
		starTexture.dispose();
		explosion01.dispose();
		irritatingAmbiantBuzz.dispose();
		greenJetTexture.dispose();
		superGreenJetTexture.dispose();
		greenMineTexture.dispose();
		thirdBossTexture.dispose();
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