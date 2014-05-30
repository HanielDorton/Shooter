package com.haniel.Shooter.entities.enemies.SecondLevel;

import java.util.List;

import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.Coord;

public class ImprovedPlayerClone extends PlayerClone{
	
	private boolean stopTracking = false;
	
	public ImprovedPlayerClone(double x, double y, List<Coord> pattern, Level level) {
		super(x, y, pattern, level);
		this.speed = 250;
	}
	
	public void update() {
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();
		this.engine1Effect.setPosition((int) x + 11, (int) y + 30);
		this.engine2Effect.setPosition((int) x + 19,(int) y + 30);
		if (!stopTracking) {
			this.angle = level.getAngletoPlayersMiddle(x + (width / 2), y + (height / 2));
			if (this.y < level.getPlayerY()) {
				stopTracking = true;
				this.angle = getAngleTo(x, y+10, x, y-10);
			}
		}
		move(Math.cos(angle) * speed, Math.sin(angle) * speed);		
        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
        shoot();		
	}
}
