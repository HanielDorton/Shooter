package com.haniel.Shooter.projectiles;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Entity;

public abstract class Projectile {
	
	protected final double xOrigin, yOrigin;
	protected double angle;
	protected float x, y;
	protected double nx, ny;
	protected double distance;
	protected double speed, range, damage, firingRate;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected Texture texture;
	protected int width, height;
	protected final Random random = new Random();
	protected Entity origin;

	protected GameScreen gameScreen;
	
	//these are all the final images for projectiles so they are only loaded once:
	protected final Texture basicGun = new Texture(Gdx.files.internal("projectiles/basicgun.png"));
	
	//set firing rates so they can be accessed before projectiles are created:
	public final static double basicGunFiringRate = 0.05;
	
	public Projectile(float x, float y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
		
	}
	
	public void update() {
		
	}
	public double getFiringRate(){
		return firingRate;
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
	
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

}
