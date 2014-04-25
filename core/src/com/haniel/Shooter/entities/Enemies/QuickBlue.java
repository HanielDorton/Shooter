package com.haniel.Shooter.entities.Enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.OrangeParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class QuickBlue extends Enemy{
	
	protected final static double firingRate = .5;

	public QuickBlue(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 300;
		this.width = 20;
		this.height = 30;
		this.texture = quickBlueTexture;		
		this.health = 0;
		this.xOffset = 5;
		this.yOffset = 5;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width, height);
		this.weapon = new BlueSphereGun(level, false);
		this.lastShot = level.getTime() + random.nextInt(2);
	}
	
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	    	double angle = level.getAngletoPlayersMiddle(x + xOffset, y + yOffset);
	       	weapon.shoot(x + xOffset, y + yOffset, angle);
	       	weapon.shoot(x + xOffset, y + yOffset, angle + .2);
	       	weapon.shoot(x + xOffset, y + yOffset, angle - .2);
	    }
    }
	
	public void update(){
		super.update();
		///add engine particle effects here
		for (int i = 0; i < 5; i++) {
			level.add(new OrangeParticle((int) x + xOffset,(int) y, 1));
			level.add(new OrangeParticle((int) x + xOffset + width,(int) y, 1));
		}
	}
}