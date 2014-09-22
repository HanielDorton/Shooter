package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level3.GreenJet;
import com.haniel.Shooter.entities.enemies.Level3.GreenMine;
import com.haniel.Shooter.entities.enemies.Level3.SuperGreenJet;
import com.haniel.Shooter.entities.enemies.Level3.SuperGreenMine;
import com.haniel.Shooter.entities.enemies.Level3.ThirdBoss;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Pathing;

public class Level3 extends Level{
	
	//checkpoints: 5940, 11490;
	
	public Level3(GameScreen gameScreen) {
		super(gameScreen);
		this.name = "3: Bargaining";
		backgroundMusic = Assets.manager.get("music/Five_Armies.mp3", Music.class);
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/thirdlevel/greenbullet.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 200);
		smallExplosionEffect.load(Gdx.files.internal("particles/thirdlevel/greenmissileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallExplosionEffect2.load(Gdx.files.internal("particles/thirdlevel/greenexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffect2Pool = new ParticleEffectPool(smallExplosionEffect2, 2, 2);
		largeExplosionEffect.load(Gdx.files.internal("particles/thirdlevel/largegreenexplosion.p"), Gdx.files.internal("particles/"));
		largeExplosionPool = new ParticleEffectPool(largeExplosionEffect, 2, 2);
	}
	
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("space-1.png", 0, 0, 2));
				addStarsCheckpoint(100);
		        break;
			}
			case 100: {
				add(new GreenJet(-200, 480,Pathing.jetCirclesLeft , this));
				add(new GreenJet(800, 480,Pathing.jetCirclesRight , this));
				break;
			}
			case 2600: {
				add(new SuperGreenJet(-10,480,Pathing.jetCircles , this));
				break;
			}
			case 5950: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("space-1.png", 0, -118, 2));
					backgroundMusic = Assets.manager.get("music/Five_Armies_firstContinue.mp3", Music.class);
					backgroundMusic.play();
					addStarsCheckpoint(100);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 6300: {
				generateRandomMine(2);
				break;
			}
			case 6700: {
				generateRandomMine(2);
				break;
			}
			case 7100: {
				generateRandomMine(2);
				break;
			}
			
			case 7400: {
				generateRandomMine(2);
				break;
			}
			case 7800: {
				generateRandomMine(2);
				generateRandomSuperMine(1);
				break;
			}
			case 8200: {
				generateRandomSuperMine(2);
				break;
			}
			case 8600: {
				generateRandomSuperMine(3);
				break;
			}
			
			case 9000: {
				generateRandomMine(3);
				generateRandomSuperMine(2);
				break;
			}
			
			case 9500: {
				generateRandomSuperMine(6);
				break;
			}
			case 9900: {
				generateRandomSuperMine(3);
				break;
			}
			case 10200: {
				generateRandomSuperMine(7);
				break;
			}
			case 10600: {
				generateRandomSuperMine(3);
				break;
			}
			case 10900: {
				generateRandomMine(1);
				generateRandomSuperMine(1);
				break;
			}
			case 11200: {
				generateRandomMine(1);
				generateRandomSuperMine(1);
				break;
			}
			
			
			case 11500: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("space-1.png", 0, -230, 2));
					addStarsCheckpoint(300);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				backgroundMusic = Assets.manager.get("music/All_This.mp3", Music.class);
				backgroundMusic.play();
				generateRandomSuperMine(1);
				generateRandomSuperMine(1);
				break;				
			}
			case 11700:{
				add(new ThirdBoss(350, 480, this));
				break;
			}
					
		}
	}
	
	private void generateRandomMine(int quantity) {
		for (int i = 0; i< quantity; i++){
			add(new GreenMine(0, 480, this, random.nextInt(11)));
		}
	}
	
	private void generateRandomSuperMine(int quantity) {
		for (int i = 0; i< quantity; i++) {
			add(new SuperGreenMine(0, 480, this, random.nextInt(11)));
		}		
	}
}
