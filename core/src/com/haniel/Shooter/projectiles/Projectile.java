package com.haniel.Shooter.projectiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.WhiteParticle;

public abstract class Projectile {
	
	protected final double xOrigin, yOrigin, angle;
	protected double x, y;
	protected double speed, range, damage;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected Texture texture;
	protected int width, height;
	protected Level level;
	protected boolean fromPlayer;
	
	//these are all the final images for projectiles so they are only loaded once:
	protected final static Texture basicBulletTexture = new Texture(Gdx.files.internal("projectiles/basicgun.png"));
	protected final static Texture blueSphereGunTexture = new Texture(Gdx.files.internal("projectiles/bluesphere.png"));
	protected final static Texture blueline = new Texture(Gdx.files.internal("projectiles/blueline.png"));
	protected final static Texture blackSphereGunTexture = new Texture(Gdx.files.internal("projectiles/blacksphere.png"));
	
	public Projectile (double x, double y, double angle, boolean fromPlayer) {
		xOrigin = x;
		yOrigin = y;
		this.angle = angle;
		this.x = x;
		this.y = y;
		this.fromPlayer = fromPlayer;		
	}
	
	public void update() {
		move(Math.cos(angle), Math.sin(angle));
        if (y < 0 - this.height) remove();
        if (y > level.getHeight() + this.height) remove();
        if (x > level.getWidth() + this.width) remove();
        if (x < 0 - this.width) remove();
		rectangle.setPosition((float) x, (float) y);
		this.generateParticles(x, y);
	}
	
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		xa *= (Gdx.graphics.getDeltaTime() * speed);
		ya *= (Gdx.graphics.getDeltaTime() * speed);
		
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
	
	public void generateParticles(double x, double y) {
		for (int i = 0; i <2; i ++) {
			level.add(new WhiteParticle(x + i, y, 3, 0, 5));
		}
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
	
	public boolean fromPlayer() {
		return fromPlayer;
	}

}
