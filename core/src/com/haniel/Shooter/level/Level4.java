package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level4.CloakingEnemy;
import com.haniel.Shooter.entities.enemies.Level4.CloakingEnemyBombs;
import com.haniel.Shooter.entities.enemies.Level4.FighterJet;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.graphics.Star;

public class Level4 extends Level{
	
	//checkpoints: 4990, 13590 
	
	public Level4(GameScreen gameScreen) {
		super(gameScreen);
		this.name = "4: Depression";
		backgroundMusic = Assets.manager.get("music/Dark_Fog.mp3", Music.class);
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/level4/purplesphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 200);
		smallExplosionEffect.load(Gdx.files.internal("particles/level4/purpleexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallExplosionEffect2.load(Gdx.files.internal("particles/level4/bomb.p"), Gdx.files.internal("particles/"));
		smallExplosionEffect2Pool = new ParticleEffectPool(smallExplosionEffect2, 5, 20);
		}
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
			
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("spacebackground3.png", 0, 0, 1));
				addStarsCheckpoint(100);
			    break;
				}
			case 400: {
				add(new CloakingEnemy(370, 240, 0, 20, this));
				break;
			}
			case 700: {
				add(new CloakingEnemy(50, 100, 20, 20, this));
				add(new CloakingEnemy(700, 100, -20, 20, this));
				break;
			}
			case 1100: {
				add(new CloakingEnemy(50, 275, 0, 10, this));
				break;
			}
			case 1250: {
				add(new CloakingEnemy(200, 275, 0, 13, this));
				break;
			}
			case 1400: {
				add(new CloakingEnemy(350, 275, 0, 16, this));
				add(new CloakingEnemy(650, 25, 0, 10, this));
				break;
			}
			case 1550: {
				add(new CloakingEnemy(500, 275, 0, 19, this));
				add(new CloakingEnemy(500, 25, 0, 13, this));
				break;
			}
			case 1700: {
				add(new CloakingEnemy(650, 275, 0, 22, this));
				add(new CloakingEnemy(350, 25, 0, 16, this));
				break;
			}
			case 1850: {
				add(new CloakingEnemy(200, 25, 0, 19, this));
				break;
			}
			case 2000: {
				add(new CloakingEnemy(50, 25, 0, 22, this));
				break;
			}
			case 2500: {
				add(new CloakingEnemy(0, -50, 0, 100, this));
				break;				
			}
			case 2600: {
				add(new CloakingEnemy(75, -50, 0, 100, this));
				break;				
			}
			case 2700: {
				add(new CloakingEnemy(150, -50, 0, 100, this));
				break;				
			}
			case 2800: {
				add(new CloakingEnemy(225, -50, 0, 100, this));
				break;				
			}
			case 2900: {
				add(new CloakingEnemy(300, -50, 0, 100, this));
				break;				
			}
			case 3000: {
				add(new CloakingEnemy(375, -50, 0, 100, this));
				break;				
			}
			case 3100: {
				add(new CloakingEnemy(450, -50, 0, 100, this));
				break;				
			}
			case 3200: {
				add(new CloakingEnemy(525, -50, 0, 100, this));
				break;				
			}
			case 3300: {
				add(new CloakingEnemy(590, -50, 0, 100, this));
				break;				
			}
			case 3400: {
				add(new CloakingEnemy(655, -50, 0, 100, this));
				break;				
			}
			case 3500: {
				add(new CloakingEnemy(730, -50, 0, 100, this));
				break;				
			}
			case 3800: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 4400: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 4800: {
				add( new CloakingEnemyBombs(380, -250, 0, 150, this));
				break;
			}
			case 5000: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("spacebackground3.png", 0, -50, 1));
					addStarsCheckpoint(100);
					backgroundMusic = Assets.manager.get("music/Dark_Fog_firstContinue.mp3", Music.class);
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}			
			case 5400: {
				add( new CloakingEnemyBombs(200, -200, 0, 100, this));
				add( new CloakingEnemyBombs(550, -200, 0, 100, this));
				break;
			}
			case 5800: {
				add(new CloakingEnemy(200, 150, -20, 30, this));
				add(new CloakingEnemy(550, 150, 20, 30, this));
				break;
			}
			case 6500: {
				add(new CloakingEnemyBombs(0, -50, 0, 100, this));
				break;				
			}
			case 6650: {
				add(new CloakingEnemyBombs(75, -50, 0, 100, this));
				break;				
			}
			case 6800: {
				add(new CloakingEnemyBombs(150, -50, 0, 100, this));
				break;				
			}
			case 6950: {
				add(new CloakingEnemyBombs(225, -50, 0, 100, this));
				break;				
			}
			case 7100: {
				add(new CloakingEnemyBombs(300, -50, 0, 100, this));
				break;				
			}
			case 7250: {
				add(new CloakingEnemyBombs(375, -50, 0, 100, this));
				break;				
			}
			case 7400: {
				add(new CloakingEnemyBombs(450, -50, 0, 100, this));
				break;				
			}
			case 7550: {
				add(new CloakingEnemyBombs(525, -50, 0, 100, this));
				break;				
			}
			case 7700: {
				add(new CloakingEnemyBombs(590, -50, 0, 100, this));
				break;				
			}
			case 7850: {
				add(new CloakingEnemyBombs(655, -50, 0, 100, this));
				break;				
			}
			case 8000: {
				add(new CloakingEnemyBombs(730, -50, 0, 100, this));
				break;				
			}
			case 9500: {
				add(new CloakingEnemy(370, 240, 0, 20, this));
				break;
			}			
			case 10000: {
				add(new CloakingEnemy(200, 200, 20, 20, this));
				add(new CloakingEnemy(550, 200, -20, 20, this));
				break;
			}
			case 10400: {
				add( new CloakingEnemyBombs(200, -200, 0, 100, this));
				add( new CloakingEnemyBombs(550, -200, 0, 100, this));
				break;
			}
			case 10800: {
				add(new CloakingEnemy(200, 150, -20, 30, this));
				add(new CloakingEnemy(550, 150, 20, 30, this));
				break;
			}
			case 11200: {
				add( new CloakingEnemyBombs(200, -200, 0, 100, this));
				add( new CloakingEnemyBombs(550, -200, 0, 100, this));
				break;
			}
			case 12000: {
				add(new CloakingEnemy(200, 200, 20, 20, this));
				add(new CloakingEnemy(550, 200, -20, 20, this));
				break;
			}
			case 12400: {
				add(new CloakingEnemy(200, 150, -20, 30, this));
				add(new CloakingEnemy(550, 150, 20, 30, this));
				break;
			}

			case 13600: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("spacebackground3.png", 0, -136, 1));
					addStarsCheckpoint(100);
					backgroundMusic = Assets.manager.get("music/Dark_Fog_secondContinue.mp3", Music.class);
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 15000: {
				add(new CloakingEnemy(370, 240, 0, 20, this));
				break;
			}
			
			case 15600: {
				add(new CloakingEnemy(50, 100, 20, 20, this));
				add(new CloakingEnemy(700, 100, -20, 20, this));
				break;
			}
			case 16200: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 17200: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 18200: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 19200: {
				add( new CloakingEnemyBombs(20, -200, 0, 100, this));
				add( new CloakingEnemyBombs(720, -200, 0, 100, this));
				break;
			}
			case 20200:{
				add(new CloakingEnemy(50, 100, 20, 20, this));
				add(new CloakingEnemy(700, 100, -20, 20, this));
				break;
			}
			case 21200: {
				add(new CloakingEnemy(370, 240, 0, 20, this));
				break;
			}
			
			case 22200: {
				setLevelComplete();
				break;
			}

		}
		if (levelTime > 13900 && levelTime < 21800 && levelTime % 200 == 0) generateRandomJet();
		
	}
	protected void addStarsCheckpoint(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(random.nextInt(480), 0));
        	} 
	}
	private void generateRandomJet() {
		add(new FighterJet(0, 480, random.nextInt(9), this));
	}

}
