package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level2.HomingMissile;
import com.haniel.Shooter.entities.enemies.Level2.ImprovedPlayerClone;
import com.haniel.Shooter.entities.enemies.Level2.PlayerClone;
import com.haniel.Shooter.entities.enemies.Level2.SecondBoss;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.util.Coord;

public class Level2 extends Level{
	
	///checkpoints: 6890, 10790, 18390

	
	public Level2(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/secondlevel/redsphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/PlayerExplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallExplosionEffect2.load(Gdx.files.internal("particles/secondlevel/missileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffect2Pool = new ParticleEffectPool(smallExplosionEffect2, 5, 20);
		smallEngineEffect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/space-2.png", 0, 0, .1f));
				addStarsCheckpoint(100);
				add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 350, 1f));

				break;
			}
			case 200: {
				add(new PlayerClone(0, 525, Coord.leavebottom, this));
				break;
			}
			case 300: {
				add(new PlayerClone(800, 525, Coord.leavebottom, this));
				break;
			}
			case 400: {
				add(new PlayerClone(400, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 500: {
				add(new PlayerClone(400, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 600: {
				add(new PlayerClone(100, 525, Coord.leavebottom, this));
				break;
			}
			case 700: {
				add(new PlayerClone(700, 525, Coord.leavebottom, this));
				break;
			}
			case 800: {
				add(new PlayerClone(300, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 900: {
				add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 1000: {
				add(new PlayerClone(200, 525, Coord.leavebottom, this));
				break;
			}
			case 1100: {
				add(new PlayerClone(600, 525, Coord.leavebottom, this));
				break;
			}
			case 1200: {
				add(new PlayerClone(200, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1300: {
				add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 1400: {
				add(new PlayerClone(0, 525, Coord.leavebottom, this));
				break;
			}
			case 1500: {
				add(new PlayerClone(800, 525, Coord.leavebottom, this));
				break;
			}
			case 1600: {
				add(new PlayerClone(400, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1700: {
				add(new PlayerClone(400, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 1800: {
				add(new PlayerClone(100, 525, Coord.leavebottom, this));
				break;
			}
			case 1900: {
				add(new PlayerClone(700, 525, Coord.leavebottom, this));
				break;
			}
			case 2000: {
				add(new PlayerClone(300, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2100: {
				add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 2200: {
				add(new PlayerClone(200, 525, Coord.leavebottom, this));
				break;
			}
			case 2300: {
				add(new PlayerClone(600, 525, Coord.leavebottom, this));
				break;
			}
			case 2400: {
				add(new PlayerClone(200, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 2500: {
				add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 2650: {
				add(new PlayerClone(800, 525, Coord.leavebottom, this));
				break;
			}
			case 2800: {
				add(new PlayerClone(100, 525, Coord.leavebottom, this));
				break;
			}
			case 2950: {
				 add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 3100: {
				add(new PlayerClone(200, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3230: {
				add(new PlayerClone(800, 525, Coord.leavebottom, this));
				break;
			}
			case 3290: {
				add(new PlayerClone(400, 525, Coord.leavebottomrightlist, this));
				break;
			}
			case 3380: {
				add(new PlayerClone(300, 525, Coord.leavebottomleftlist, this));
				break;				
			}
			case 3440: {
				add(new PlayerClone(200, 525, Coord.leavebottom, this));
				break;
			}
			case 3530: {
				add(new PlayerClone(600, 525, Coord.leavebottomrightlist, this));
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
			case 5600: {
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(0, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(390, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
				add(new HomingMissile(800, 500, null, this));
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
		
			case 6900: { //next checkpoitn 108
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-2.png", 0, 0, .1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 280, 1f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_firstContinue.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 7100: {
				addFiveFighters();
				break;
			}
			case 7400: {
				addFiveFighters();
				break;
			}
			case 7700: {
				addFiveFighters();
				break;
			}
			case 7900: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 8500: {
				addFiveFighters();
				break;
			}
			case 8800: {
				addFiveFighters();
				break;
			}
			case 9000: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 9400: {
				addFiveFighters();
				break;
			}
			case 9600: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			case 9800: {
				addFiveFighters();
				break;
			}
			case 10000: {
				for (int i = 0; i < 8; i++) {
					add(new HomingMissile((175 * i) - 300, 480 + (37 * i), null, this));
				}
				break;
			}
			
			case 10300: {
				addFiveFighters();
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
					add(new BackgroundImage("levels/space-2.png", 0, 0, .1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 242, 1f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_secondContinue.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 11200: {
				add(new SecondBoss(250, -690, Coord.leavetopmiddlelist, this, false));
				break;
			}
			case 18400: { 
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-2.png", 0, 0, .1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 166, 1f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
					backgroundMusic.stop();
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
				}
				add(new SecondBoss(250, 800, Coord.bossstayinmiddlelist, this, true));			
				break;
			}
			
		}
	}
	
	public void addFiveFighters() {
		for (int i = 0; i < 6; i++) {
			if (!(i % 2 == 0)) add(new ImprovedPlayerClone((175 * i) - 150, 525, null, this));
			}
		}
	}


