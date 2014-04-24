package com.haniel.Shooter.entities.Enemies;

import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.particles.OrangeParticle;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.weapons.BlueSphereGun;

public class BasicBlueEnemy extends Enemy{
	
	//this guy just shoots the slow player-seeking blue balls from the middle of his ship
	protected final static double firingRate = 2;

	public BasicBlueEnemy(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);		
		this.speed = 100;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;		
		this.health = 2;
		this.xOffset = 4;
		this.yOffset = 20;
		this.rectangle = new Rectangle((float)x + xOffset, (float)y + yOffset, width * 0.8f, height / 2);
		this.weapon = new BlueSphereGun(level, false);

	}
	public void shoot() {
        if ((level.getTime() - lastShot) > firingRate) {
	    	lastShot = level.getTime();
	       	double angle = level.getAngletoPlayersMiddle(x + width / 2, y + height / 2 - 5);
	       	weapon.shoot(x + width / 2, y + height / 2 - 5, angle);
        }
    	
	}
	public void update(){
		super.update();
	    for (int i =0; i < 25; i++) {
			level.add(new OrangeParticle(x + 20 + i, y + height - 10, 1, 0, 0));
	    }
	}
}
