package com.haniel.Shooter.entities.enemies;

import java.util.List;

import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;

public abstract class Enemy extends Entity{
	
	//every enemy should call super.update if it overrides update
	//super.update removes enemy if out of bounds, moves player based on pattern and shoots
	// and need to override init to set weapon
	//override particles to have different particles on death

	private List <Coord> pattern;
	
	public Enemy(double x, double y, List <Coord> pattern, Level level) {
		this.x = x;
		this.y = y;
		this.destX = x;
		this.destY = y;
		this.position = 0;
		this.pattern = pattern;
		this.level = level;
		this.lastShot = level.getTime() - random.nextInt(3);
	}
	
	public void update() {
		super.update();
		if (Math.abs(x - destX) <= 15 && Math.abs(y - destY) <= 15) {
			destX = pattern.get(position).getX();
			destY = pattern.get(position).getY();
			angle = getAngleTo(x, y, destX, destY);
			position++;
			if (position == pattern.size()) position = 0;
		}
		move(Math.cos(angle) * speed, Math.sin(angle) * speed);		
        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
        if (!(y < 0 - this.height) && !(y > level.getHeight() + this.height) && !(x > level.getWidth() + this.width) && !(x < 0 - this.width)) {
        	shoot();
        }
	}
	
	
	public void particles() {
		if( health < 0) {
			PooledEffect effect = level.smallExplosionEffectPool.obtain();
			effect.setPosition((int) x + xOffset + width / 2,(int) y + yOffset + height / 2);
			level.effects.add(effect);
			matches2.play();
		} 
		
	}
	protected void shoot() {
		if (!(getMidY()> 480) && !(getMidY() < 0) && !(getMidX() < 0 && !(getMidX() > 800))){
			System.out.println("shooting not setup for this enemy");
		}
	}
}

	

