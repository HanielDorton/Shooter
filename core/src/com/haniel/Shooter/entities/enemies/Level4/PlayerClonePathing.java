package com.haniel.Shooter.entities.enemies.Level4;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.haniel.Shooter.entities.enemies.Level2.RedEnemy;
import com.haniel.Shooter.level.Level;

public class PlayerClonePathing extends RedEnemy{

	
	public PlayerClonePathing(double x, double y, CatmullRomSpline<Vector2> path, Level level) {
		super(x, y, path, level);
		this.path = path;
		this.speed = 80;
	}
	
	public void update() {
		super.update();
		Vector2 temp = new Vector2((float)x, (float)y);
		System.out.println(path.locate(temp) + " " + x + " " + y);
	}
}
