package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Enemies.BasicBlueEnemy;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.BackgroundPlanet;
import com.haniel.Shooter.util.Coord;

public class LevelFirst extends Level{
	
	public LevelFirst(GameScreen gameScreen) {
		super(gameScreen);
		add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
        add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
        Music backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();
        
        //change levelTime to warp:
        levelTime = 15;
        
        // 50 is when music starts
        
	}
	
	public void runLevel(GameScreen g) {
		levelTime++;

		switch (levelTime) {
		
			case 1: {
				add(new BackgroundPlanet("textures/black_planet.png", 0, 0, .4f, 400));
				break;
			}
		
			case 2: { //test code here
				break;
			}		
			case 12: {

				break;
			}
			
			
			case 18: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(800, 560, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 560, Coord.topLeftMiddleLeaveTop));
				break;
			} 
			case 19: {
				addStars(20);
				break;
			} 
			case 20: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(800, 560, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 560, Coord.topLeftMiddleLeaveTop));
				break;
			} 
			case 21: {
				addStars(20);
				break;
			} 
			case 22: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(800, 560, Coord.topRightMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop));
				add(new BasicBlueEnemy(-60, 560, Coord.topLeftMiddleLeaveTop));
				break;
			} 
			
			case 28: {
				add(new BasicBlueEnemy(700, 480, Coord.circleTop));
				add(new BasicBlueEnemy(700, 540, Coord.circleTop));
				add(new BasicBlueEnemy(700, 600, Coord.circleTop));
				add(new BasicBlueEnemy(-60, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-120, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-180, 400, Coord.circleTop));
				break;
			}
				
			case 31: {
				add(new BasicBlueEnemy(700, 480, Coord.circleTop));
				add(new BasicBlueEnemy(700, 540, Coord.circleTop));
				add(new BasicBlueEnemy(700, 600, Coord.circleTop));
				add(new BasicBlueEnemy(-60, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-120, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-180, 400, Coord.circleTop));
				break;	
			}
			case 34: {
				add(new BasicBlueEnemy(700, 480, Coord.circleTop));
				add(new BasicBlueEnemy(700, 540, Coord.circleTop));
				add(new BasicBlueEnemy(700, 600, Coord.circleTop));
				add(new BasicBlueEnemy(-60, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-120, 400, Coord.circleTop));
				add(new BasicBlueEnemy(-180, 400, Coord.circleTop));
				break;	
				
			}
			case 45: {
				//make remaining enemies leave
			}
			
			case 49: {
				//two large enemies from bottom sides come to top and go back and forth while shooting heavily
			}
		}
	}

}
