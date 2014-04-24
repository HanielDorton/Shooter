package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
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
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        backgroundMusic.setLooping(true);
        
        //change levelTime to warp:
        //first enemies
        //levelTime = 1600;
        //saucer
        //continue = 
        
        // 50 is when music starts
        
	}
	
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
		        add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
				add(new BackgroundPlanet("textures/black_planet.png", 0, -200, .4f, 400));
		        backgroundMusic.play();
				break;
			}
		
			case 200: { //test code here
				break;
			}		
			case 800: {
				addStars(20);
				break;
			}
			case 900: {
				addStars(20);
				break;
			}	
			case 1000: {
				addStars(20);
				break;
			}	
			case 1100: {
				addStars(20);
				break;
			}	
		
			case 1300: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			
			case 1370: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				addStars(20);
				break;
			}
			case 1440: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));			
				break;
			} 
			case 1510: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1580: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				addStars(20);
				break;
			} 
			case 1660: {
				addStars(20);
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1730: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1800: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1870: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1940: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2010: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 2080: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 			
			case 2450: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2520: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2590: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2660: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2740: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2810: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2880: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2950: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3020: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3090: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3160: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3230: {
				add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}			
			case 3300: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3370: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
	
			case 4300: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background2.png", 0, 0, .02f));
					add(new BackgroundImage("levels/space_background2.png", 0, 960, .02f));
					backgroundMusic.play();
				}					
				gameScreen.setCheckPoint(levelTime - 10);
				add(new BlueSaucer(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new BlueSaucer(-150, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			
			case 8200: {
				gameScreen.setCheckPoint(levelTime);
				break;
				
			}
			
			
		}
	}

}
