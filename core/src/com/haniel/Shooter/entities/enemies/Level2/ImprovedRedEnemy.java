package com.haniel.Shooter.entities.enemies.Level2;

import com.haniel.Shooter.level.Level;

public class ImprovedRedEnemy extends RedEnemy{
	
	private boolean stopTracking = false;
	
	public ImprovedRedEnemy(double x, double y, Level level) {
		super(x, y, level);
		this.speed = 250;
	}
	
	public void update() {
        if (y < 0 - this.height - 300) remove();
        if (y > level.getHeight() + this.height + 300) remove();
        if (x > level.getWidth() + this.width + 300) remove();
        if (x < 0 - this.width - 300) remove();
        if (health < 0) remove();		
		if (!stopTracking) {
			this.angle = level.getAngletoPlayersMiddle(x + (width / 2), y + (height / 2));
			if (this.y < level.getPlayerY()) {
				stopTracking = true;
				this.angle = getAngleTo(x, y+10, x, y-10);
			}
			shoot();
		}
		move(Math.cos(angle) * speed, Math.sin(angle) * speed);		
        rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
        this.engine1Effect.setPosition((int) x + 27, (int) y + 100);

	}
}
