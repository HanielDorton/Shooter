package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.FirstLevel.BasicBlueEnemy;
import com.haniel.Shooter.entities.enemies.FirstLevel.BlueSaucer;
import com.haniel.Shooter.entities.enemies.FirstLevel.FirstBoss;
import com.haniel.Shooter.entities.enemies.FirstLevel.ImprovedBlueEnemy;
import com.haniel.Shooter.entities.enemies.FirstLevel.ImprovedBlueSaucer;
import com.haniel.Shooter.entities.enemies.FirstLevel.QuickBlue;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Coord;

public class Level1 extends Level{
	//Checkpoints: 4290 for ufo's // 9190 for secondcheckpoint//13990 for boss
	private boolean difficult = false;
			
	public Level1(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/firstlevel/BlueSphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/firstlevel/BlueExplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
		        add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
		        addStarsCheckpoint(100);
				break;
			}
			case 300: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			}		
			case 370: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			}
			case 440: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));			
				break;
			} 
			case 510: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 580: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 660: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 730: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 800: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 870: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 940: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1010: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1080: {
				add(new BasicBlueEnemy(800, 480, Coord.topRightMiddleLeaveTop, this));
				add(new BasicBlueEnemy(-60, 480, Coord.topLeftMiddleLeaveTop, this));
				break;
			} 
			case 1470: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1540: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1610: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1680: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1750: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1820: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1890: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 1960: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2030: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2100: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2170: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2240: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2310: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2380: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2450: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2520: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2590: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2660: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2740: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2810: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2880: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 2950: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3020: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3090: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3160: {
				add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3230: {
				if (difficult) add(new BasicBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new BasicBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}			
			case 3300: {
				if (difficult) add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}
			case 3370: {
				if (difficult) add(new ImprovedBlueEnemy(800, 420, Coord.straightleftaroundtop, this));
				if (difficult) add(new ImprovedBlueEnemy(-60, 360, Coord.straightrightaroundtop, this));
				break;
			}	
			case 4300: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
					add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex_firstContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(100);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				add(new BlueSaucer(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new BlueSaucer(-150, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				if (difficult) add(new BlueSaucer(300, -200, Coord.leavescreentopmiddle, this));
				break;
			}
			case 7400: {
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 7600: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				break;
			}
			case 7800: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				break;
			}
			case 8000: {
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 8200: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 8600: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 9200: {
				//checkpoint
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
					add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex_secondContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(100);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}			
			case 9600: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				addStars(20);
				break;
			}
			case 9640: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				addStars(20);
				break;
			}
			case 9680: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 9720: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult)add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 9760: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult) add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 9800: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult) add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 10100: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				addStars(20);
				break;
			}
			case 10140: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				addStars(20);
				break;
			}
			case 10180: {
				add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 10420: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult) add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 10440: {
				if (difficult)add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult) add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 10480: {
				if (difficult) add(new QuickBlue(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				if (difficult) add(new QuickBlue(-30, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 10450: {
				add(new ImprovedBlueSaucer(800, 175, Coord.circlenearrighttopslowlyforawhilethenleave, this));
				add(new ImprovedBlueSaucer(-150, 175, Coord.circlenearlefttopslowlyforawhilethenleave, this));
				break;
			}
			case 11000: {
				if (difficult) add(new ImprovedBlueSaucer(300, -200, Coord.leavescreentopmiddle, this));
				break;
			}
			
			case 14000: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background1.png", 0, 0, 3));
					add(new BackgroundImage("levels/space_background1.png", 0, 960, 3));
					addStarsCheckpoint(100);
				} else {
					add(new CheckpointReached(300, 350, 2));
					
				}
				gameScreen.setCheckPoint(levelTime - 10);
				backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
				backgroundMusic.play();
				add(new FirstBoss(125,-300, Coord.bosscircles, this, difficult));
				break;
				
			}
		}
	}
}
