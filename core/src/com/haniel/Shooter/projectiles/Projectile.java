package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.WhiteParticle;

public abstract class Projectile {
	
	protected final double xOrigin, yOrigin, angle;
	protected float x, y;
	protected double speed, range, damage;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected Texture texture;
	protected int width, height;
	protected Level level;
	
	//these are all the final images for projectiles so they are only loaded once:
	protected final static Texture basicBulletTexture = new Texture(Gdx.files.internal("projectiles/basicgun.png"));
	protected final static Texture blueSphereGunTexture = new Texture(Gdx.files.internal("projectiles/bluesphere.png"));

	
	public Projectile(float x, float y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
		
	}
	
	public void update() {
		this.y += speed * Gdx.graphics.getDeltaTime();
		if (y > 480) removed = true;
		rectangle.setPosition(x, y);
		generateParticles(x, y);
	}
	
	public void generateParticles(float x, float y) {
		for (int i = 0; i <3; i ++) {
			level.add(new WhiteParticle(x + i, y, 1, 0, 5));
		}
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
	
	public void init(Level level) {
		this.level = level;
	}

}
