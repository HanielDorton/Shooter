package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.HomingMissile;
import com.haniel.Shooter.entities.enemies.ImprovedPlayerClone;
import com.haniel.Shooter.entities.enemies.PlayerClone;
import com.haniel.Shooter.entities.enemies.SecondBoss;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Coord;

public class LevelSecond extends Level{
	
	///checkpoints: 6890, 10790
	
	ParticleEffect nebula = new ParticleEffect();

	
	
	public LevelSecond(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/homingmissile.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/PlayerExplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallExplosionEffect2.load(Gdx.files.internal("particles/missileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffect2Pool = new ParticleEffectPool(smallExplosionEffect2, 5, 20);
		smallEngineEffect.load(Gdx.files.internal("particles/PlayerCloneEngine.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				addStarsCheckpoint(200);
				//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
		        //add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
				break;
			}
			case 200: {
				add(new PlayerClone(0, 480, Coord.leavebottom, this));
				break;
			}
			case 300: {
				add(new PlayerClone(800, 480, Coord.leavebottom, this));
				break;
			}
			case 400: {
				add(new PlayerClone(400, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 500: {
				add(new PlayerClone(400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 600: {
				add(new PlayerClone(100, 480, Coord.leavebottom, this));
				break;
			}
			case 700: {
				add(new PlayerClone(700, 480, Coord.leavebottom, this));
				break;
			}
			case 800: {
				add(new PlayerClone(300, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 900: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1000: {
				add(new PlayerClone(200, 480, Coord.leavebottom, this));
				break;
			}
			case 1100: {
				add(new PlayerClone(600, 480, Coord.leavebottom, this));
				break;
			}
			case 1200: {
				add(new PlayerClone(200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1300: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1400: {
				add(new PlayerClone(0, 480, Coord.leavebottom, this));
				break;
			}
			case 1500: {
				add(new PlayerClone(800, 480, Coord.leavebottom, this));
				break;
			}
			case 1600: {
				add(new PlayerClone(400, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1700: {
				add(new PlayerClone(400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1800: {
				add(new PlayerClone(100, 480, Coord.leavebottom, this));
				break;
			}
			case 1900: {
				add(new PlayerClone(700, 480, Coord.leavebottom, this));
				break;
			}
			case 2000: {
				add(new PlayerClone(300, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2100: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 2200: {
				add(new PlayerClone(200, 480, Coord.leavebottom, this));
				break;
			}
			case 2300: {
				add(new PlayerClone(600, 480, Coord.leavebottom, this));
				break;
			}
			case 2400: {
				add(new PlayerClone(200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2500: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 2600: {
				add(new PlayerClone(0, 480, Coord.leavebottom, this));
				break;
			}
			case 2650: {
				add(new PlayerClone(800, 480, Coord.leavebottom, this));
				break;
			}
			case 2700: {
				add(new PlayerClone(400, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2750: {
				add(new PlayerClone(400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 2800: {
				add(new PlayerClone(100, 480, Coord.leavebottom, this));
				break;
			}
			case 2850: {
				add(new PlayerClone(700, 480, Coord.leavebottom, this));
				break;
			}
			case 2900: {
				add(new PlayerClone(300, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2950: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 3000: {
				add(new PlayerClone(200, 480, Coord.leavebottom, this));
				break;
			}
			case 3050: {
				add(new PlayerClone(600, 480, Coord.leavebottom, this));
				break;
			}
			case 3100: {
				add(new PlayerClone(200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3150: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 3200: {
				add(new PlayerClone(0, 480, Coord.leavebottom, this));
				break;
			}
			case 3230: {
				add(new PlayerClone(800, 480, Coord.leavebottom, this));
				break;
			}
			case 3260: {
				add(new PlayerClone(400, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3290: {
				add(new PlayerClone(400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 3320: {
				add(new PlayerClone(100, 480, Coord.leavebottom, this));
				break;
			}
			case 3350: {
				add(new PlayerClone(700, 480, Coord.leavebottom, this));
				break;
			}
			case 3380: {
				add(new PlayerClone(300, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3410: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 3440: {
				add(new PlayerClone(200, 480, Coord.leavebottom, this));
				break;
			}
			case 3470: {
				add(new PlayerClone(600, 480, Coord.leavebottom, this));
				break;
			}
			case 3500: {
				add(new PlayerClone(200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3530: {
				add(new PlayerClone(600, 480, Coord.leavebottomrightlist, this));
				break;
			}			
			case 4100: {
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 4200: {
				add(new HomingMissile(390, 500, null, this));
				break;
			}
			case 4300: {
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 4500: {
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 4600: {
				add(new HomingMissile(390, 500, null, this));
				break;
			}
			case 4700: {
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 5000: {
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				add(new HomingMissile(0, -10, null, this));
				add(new HomingMissile(800, -10, null, this));
				break;
			}
			case 5100: {
				add(new HomingMissile(390, 500, null, this));
				break;
			}
			case 5200: {
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 5300: {
				add(new HomingMissile(0, -10, null, this));
				break;
			}
			case 5400: {
				add(new HomingMissile(800, -10, null, this));
				break;
			}
			case 5600: {
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				add(new HomingMissile(0, -10, null, this));
				add(new HomingMissile(0, -10, null, this));
				add(new HomingMissile(800, -10, null, this));
				add(new HomingMissile(800, -10, null, this));
				break;
			}
			case 5700: {
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				break;
			}
			case 5800: {
				add(new HomingMissile(800, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				break;
			}
			case 5900: {
				add(new HomingMissile(0, -10, null, this));
				add(new HomingMissile(0, -10, null, this));
				break;
			}
			case 6000: {
				add(new HomingMissile(800, -10, null, this));
				add(new HomingMissile(800, -10, null, this));
				break;
			}
			case 6100: {
				add(new HomingMissile(0, -10, null, this));
				add(new HomingMissile(0, -10, null, this));
				break;
			}
			case 6200: {
				add(new HomingMissile(800, -10, null, this));
				add(new HomingMissile(800, -10, null, this));
				break;
			}
			
			case 6900: { //next checkpoitn 108
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
					//add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_firstContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(200);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 7100: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 7400: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 7700: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 7900: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 8000: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile(800 + (37 * i), 880 - (110 * i), null, this));
				}
				break;
			}
			case 8100: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile(1100 - (175 * i), 480 + (37 * i), null, this));
				}
				break;
			}
			case 8200: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile(0 - (37 * i), (110 * i) - 300, null, this));
				}
				break;
			}
			case 8800: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 9000: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 9400: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 9600: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 9800: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 10000: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			
			case 10300: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 10400: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}

			
			case 10800: { 
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
					//add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_secondContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(200);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				//nebula.load(Gdx.files.internal("particles/Nebula.p"), Gdx.files.internal("particles/"));
				//nebula.setPosition(-100, 500);
				//nebula.start();
				//overlayedParticleEffects.add(nebula);
				break;
			}
			case 11200: {
				add(new SecondBoss(325, -800, Coord.leavetopmiddlelist, this));
				break;
			}
			case 16500: {
				for (int i = 0; i < 5; i++) {
					add(new ImprovedPlayerClone(0 + (200 * i), 480, null, this));
				}
				break;
			}
			case 18400: { 
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
					//add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(200);
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
					backgroundMusic.stop();
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
				}
				add(new SecondBoss(325, 800, Coord.bossstayinmiddlelist, this));
			
				break;
			}
			
		}
	}
}

