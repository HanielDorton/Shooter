package com.haniel.Shooter.level;

import java.util.Random;

import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Enemy_1;
import com.haniel.Shooter.graphics.Star;

public class Level {
	
	private int levelTime;
	private Random rand = new Random();
	
	
	public Level() {
		
	}
	
	public void update(GameScreen g) {
		levelTime++;
		if (levelTime > 15) 	addStars(g, 1);
		//g.add(new Enemy_1(MathUtils.random(0, 800), 480));
		System.out.println(levelTime);
		switch (levelTime) {
		
			case 12: {
				addStars(g, 200);
				break;
				} 
			
			case 20: {
				for (int i = 1; i <11; i++) {
					g.add(new Enemy_1((i*80) - 80, 480));				
				} break;
			}
		}
	}
		
	
	public void addStars(GameScreen g, int number){
        for (int i = 0; i < number; i++) {
        	g.add(new Star(480));
        	} 
	}
}
