package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Enemy1;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.BackgroundPlanet;

public class LevelFirst extends Level{
	
	public LevelFirst(GameScreen gameScreen) {
		super(gameScreen);
	}
	
	public void runLevel(GameScreen g) {
		levelTime++;
		//add(new Asteroid32((random.nextInt(720) + 1 ), 480, 0, -30));
		//add(new Asteroid32((random.nextInt(720) + 1 ), 480, 0, -30));
		//add(new Asteroid32((random.nextInt(720) + 1 ), 480, 0, -30));
		//add(new Asteroid128((random.nextInt(720) + 1 ), 480, 0, -30));;
		
		//if (levelTime % 10 == 0) {
			//for (int i = 0; i< 10; i++) {
			//	 add(new Asteroid32(150 * i, 480, 0, -20));
			//}
		
	
		//add(new Enemy1((random.nextInt(720) + 1 ), 480));

		switch (levelTime) {
		
			case 1: {				
				add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
		        add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
		        add(new BackgroundPlanet("textures/black_planet.png", 0, 0, .4f, 400));

		        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
		        backgroundMusic.setLooping(true);
		        backgroundMusic.play();
				break;
			}
		
			case 2: {
				add(new Enemy1(400, 300));
				break;
			}		
			case 12: {

				break;
			}
			
			
			case 18: {
				addStars(20);
				break;
			} 
			case 19: {
				addStars(20);
				break;
			} 
			case 20: {
				addStars(20);
				break;
			} 
			case 21: {
				addStars(20);
				break;
			} 
			case 22: {
				addStars(20);
				break;
			} 
			
			case 23: {
				//for (int i = 1; i <6; i++) {
					//add(new Enemy1((i*160) - 80, 480));				
			} //break;
		}
	}

}
