package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.Enemies.BasicBlueEnemy;
import com.haniel.Shooter.entities.Enemies.BlueSaucer;
import com.haniel.Shooter.entities.Enemies.ImprovedBlueEnemy;
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
        //first enemies
        //levelTime = 1600;
        //saucer
        levelTime = 4400;
        
        // 50 is when music starts
        
	}
	
	public void runLevel(GameScreen g) {
		levelTime += 10;

		switch (levelTime) {
		
			case 10: {
				add(new BackgroundPlanet("textures/black_planet.png", 0, 0, .4f, 400));
				break;
			}
		
			case 200: { //test code here
				break;
			}		
			case 1200: {

				break;
			}		
			
			case 1800: {
				//FIRST CHECK POINT!!
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			
			case 1870: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				addStars(20);
				break;
			}
			case 1940: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));			
				break;
			} 
			case 2010: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2080: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				addStars(20);
				break;
			} 
			case 2160: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2230: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2300: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2370: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2440: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2510: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2580: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 			
			case 2950: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3020: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3090: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3160: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3240: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3310: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3380: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3450: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3520: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3590: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3660: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3730: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}			
			case 3800: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3870: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
	
			case 4600: {
				//they come up but delay shooting by like 4 seconds
				add(new BlueSaucer(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new BlueSaucer(-150, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
			}
			
			
		}
	}

}
