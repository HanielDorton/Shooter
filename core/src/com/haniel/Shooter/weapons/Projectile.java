package com.haniel.Shooter.weapons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;

public abstract class Projectile {

	protected final double angle;
	protected double x, y, speed, damage;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected int width, height;
	protected Level level;
	protected boolean fromPlayer;
	protected PooledEffect effect;

	public Projectile (double x, double y, double angle, boolean fromPlayer) {
		this.angle = angle;
		this.x = x;
		this.y = y;
		this.fromPlayer = fromPlayer;
	}
	
	public void update() {
		move(Math.cos(angle), Math.sin(angle));
        if (y + 100 < 0 - this.height) remove();
        if (y > level.getHeight() + 100 + this.height) remove();
        if (x > level.getWidth() + 100 + this.width) remove();
        if (x + 100 < 0 - this.width) remove();
		rectangle.setPosition((float) x, (float) y);
		this.effect.setPosition((int) x + width / 2,(int) y + width / 2);

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
		this.effect.setPosition((int) x,(int) y);
		level.effects.add(this.effect);
		this.effect.start();
	}
	
	public void remove() {		
		this.effect.allowCompletion();
		removed = true;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
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
		this.effect = level.playerBulletEffectPool.obtain();
		this.generateParticles(x, y);
	}
	
	public boolean fromPlayer() {
		return fromPlayer;
	}
	


}
