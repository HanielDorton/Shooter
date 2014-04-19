package com.haniel.Shooter.level;

public class Level {
	
	private int levelTime;
	
	
	public Level() {
		
	}
	
	public void update() {
		levelTime++;
		System.out.println(levelTime);
	}

}
