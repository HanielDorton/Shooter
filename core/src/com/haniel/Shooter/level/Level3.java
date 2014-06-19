package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level3.GreenJet;
import com.haniel.Shooter.entities.enemies.Level3.GreenMine;
import com.haniel.Shooter.entities.enemies.Level3.SuperGreenJet;
import com.haniel.Shooter.entities.enemies.Level3.SuperGreenMine;
import com.haniel.Shooter.entities.enemies.Level3.ThirdBoss;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Coord;
import com.haniel.Shooter.util.Pathing;

public class Level3 extends Level{
	
	//checkpoints: 5940, 11490;
	
	public Level3(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Five_Armies.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/thirdlevel/greenbullet.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/thirdlevel/greenmissileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
	}
	
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/space-1.png", 0, 0, 2));
				addStarsCheckpoint(300);
		        break;
			}
			case 100: {
				add(new GreenJet(-200, 480,Pathing.jetCirclesLeft , this));
				add(new GreenJet(800, 480,Pathing.jetCirclesRight , this));
				break;
			}
			case 2550: {
				add(new SuperGreenJet(-200, 480,Coord.superJet , this));
				break;
			}
			case 5950: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-1.png", 0, -118, 2));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Five_Armies_firstContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(300);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 6350: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			case 6700: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			case 7100: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			
			case 7400: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (50 * i));
				break;
			}
			case 7800: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 1; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 8200: {
				//for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 2; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 8600: {
				//for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			
			case 9000: {
				for (int i = 0; i < 3; i++ ) generateRandomMine(480 + (50 * i));
				for (int i = 0; i < 2; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			
			case 9500: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 9900: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 10200: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 10600: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 10900: {
				for (int i = 0; i < 1; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 1; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 11200: {
				for (int i = 0; i < 1; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 1; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			
			
			case 11500: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-1.png", 0, -230, 2));
					addStarsCheckpoint(300);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
				backgroundMusic.play();
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				for (int i = 0; i < 1; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;				
			}
			case 11700:{
				add(new ThirdBoss(350, 480, Coord.bosscircles, this));
				break;
			}
					
		}
	}
	
	private void generateRandomMine(int y) {
		int x = random.nextInt(760) + 20;
		add(new GreenMine(x, 480, this, random.nextInt(11)));
	}
	
	private void generateRandomSuperMine(int y) {
		int x = random.nextInt(760) + 20;
		add(new SuperGreenMine(x, 480, this, random.nextInt(11)));
	}
}
