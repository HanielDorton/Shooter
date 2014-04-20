package com.haniel.Shooter.level;

import java.util.Random;

import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Enemy1;
import com.haniel.Shooter.graphics.Star;

public class Level {
	Random random = new Random();
	
	public int levelTime;
	//private Random rand = new Random();
	
	
	public Level() {
		
		//load graphics to be used?:
		
		
		
	}
	
	public void update(GameScreen g) {
		levelTime++;
		if (levelTime > 25)	g.add(new Enemy1((random.nextInt(720) + 1 ), 480));
		if (levelTime > 48)	{
			g.add(new Enemy1((random.nextInt(720) + 1 ), 480));
			g.add(new Enemy1((random.nextInt(720) + 1 ), 480));
		}
		//g.add(new Enemy_1(MathUtils.random(0, 800), 480));
		switch (levelTime) {
		
			case 18: {
				addStars(g, 20);
				break;
				} 
			case 19: {
				addStars(g, 20);
				break;
				} 
			case 20: {
				addStars(g, 20);
				break;
				} 
			case 21: {
				addStars(g, 20);
				break;
				} 
			case 22: {
				addStars(g, 20);
				break;
				} 
			
			case 23: {
				for (int i = 1; i <6; i++) {
					g.add(new Enemy1((i*160) - 80, 480));				
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
