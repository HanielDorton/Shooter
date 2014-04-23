package com.haniel.Shooter.entities.Enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.BlueParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public abstract class Enemy extends Entity{

	private List <Coord> pattern;
	
	public Enemy(double x, double y, List <Coord> pattern) {
		this.x = x;
		this.y = y;
		this.destX = x;
		this.destY = y;
		this.position = 0;
		this.lastShot = 0;
		this.pattern = pattern;
	}
	public void update() {
		super.update();
		if (Math.abs(x - destX) <= 5 && Math.abs(y - destY) <= 5) {
			destX = pattern.get(position).getX();
			destY = pattern.get(position).getY();
			angle = getAngleTo(x, y, destX, destY);
			position++;
			if (position == pattern.size()) position = 0;
		}
		move(Math.cos(angle) * speed, Math.sin(angle) * speed);

        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    	double angle = level.getAngletoPlayersMiddle(x + width / 2, y);
	    	weapon.shoot(x + width / 2, y, angle);
	    	//weapon.shoot(x + width + xOffset, y, 0);
	    	lastShot = level.getTime();
	    }
	}
	
	
	public void particles() {
		if( health < 0) {
			for (int i = 0; i <500; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 15));
				level.add(new BlueParticle((int) x,(int) y + height / 2, 15));
				level.add(new BlueParticle((int) x + width / 2,(int) y, 15));
				level.add(new BlueParticle((int) x + width,(int) y + height, 15));
			matches2.play();
		} else {
			for (int i = 0; i < 40; i++)
				level.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 15));
		}
		
	}
	
	public void init(Level level) {
		this.level = level;
		this.weapon = new BlueSphereGun(level, false);		
	}
	
	public void leave() {
		
		
		
		destX = pattern.get(position).getX();
		destY = pattern.get(position).getY();
		angle = getAngleTo(x, y, destX, destY);
		
	}
}

	

