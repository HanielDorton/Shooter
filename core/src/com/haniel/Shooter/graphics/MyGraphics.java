package com.haniel.Shooter.graphics;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.level.Level;

public abstract class MyGraphics {
	protected float x, y;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected Level level;
	protected float speed;
	protected Sprite sprite;
	protected boolean rotates = false;
	protected float rotation = 0;
	protected Random random = new Random();
	
	//load all images here so they are only loaded once:
	//every time you add a new one add it to dispose() at the bottom.
	protected Texture starTexture = Assets.manager.get("textures/star.png", Texture.class);
	protected Texture yellowStarTexture = Assets.manager.get("textures/yellowStar.png", Texture.class);
	protected Texture orangeStarTexture = Assets.manager.get("textures/orangeStar.png", Texture.class);
	protected Texture whiteStarTexture = Assets.manager.get("textures/whiteStar.png", Texture.class);
	protected Texture redStarLargeTexture = Assets.manager.get("textures/redStarLarge.png", Texture.class);
	protected Texture redStarTexture = Assets.manager.get("textures/redStar.png", Texture.class);
	protected Texture checkpointReachedTexture = Assets.manager.get("textures/checkpointreached.png", Texture.class);
	protected Texture healthBarTexture = Assets.manager.get("textures/HealthBar.png", Texture.class);
	protected Texture healthBarOutlineTexture = Assets.manager.get("textures/HealthBarOutline.png", Texture.class);
	
	public MyGraphics(String imageFile, int x, int y, float speed) {
		this.texture = Assets.manager.get(imageFile, Texture.class);
		this.sprite = new Sprite(texture);
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public MyGraphics(int y) {
		this.y = y;
	}
	public MyGraphics(int x, int y, float speed) {
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.speed = speed;
	}
	
	public void update() {
		this.y -= speed * Gdx.graphics.getDeltaTime();
		if (y < 0) remove();
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
	
	public void remove() {
		removed = true;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public boolean isSolid() {
		return false;
	}
	public void init(Level level) {
		this.level = level;
	}
	public static void dispose() {
	}
	
	public void changeSpeed(int sped) {
		this.speed += sped;
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
		return width / 2;
	}
	public float getOriginY() {
		return height / 2;
	}

}
