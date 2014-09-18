package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level5.LastBoss;
import com.haniel.Shooter.entities.enemies.Level5.MediumTransport;
import com.haniel.Shooter.entities.enemies.Level5.SmallTransport;
import com.haniel.Shooter.entities.enemies.Level5.TransportShip;
import com.haniel.Shooter.entities.enemies.Level5.WeaponsPlatform;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.util.Pathing;

public class Level5 extends Level{
	
	//checkpoints: 5090, 13890 for this section, 20090 for boss

	public Level5(GameScreen gameScreen){
		super(gameScreen);
		this.name = "5: Acceptance";
		backgroundMusic = Assets.manager.get("music/Crusade.mp3", Music.class);
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/level5/brownsphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 200);
		smallExplosionEffect.load(Gdx.files.internal("particles/level5/explosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallEngineEffect.load(Gdx.files.internal("particles/level5/engines.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
		smallerEngineEffect.load(Gdx.files.internal("particles/level5/smallengines.p"), Gdx.files.internal("particles/"));
		smallerEngineEffectPool = new ParticleEffectPool(smallerEngineEffect, 5, 20);
		}
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
			
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("space-2.png", 0, 0, 1));
				addStarsCheckpoint(100);
				add(new BackgroundImage("planet1.png", 0, 300, 15f));
			    break;
			}
			case 500: {
				add(new TransportShip(50, -300, this));
				break;
			}
			case 1100: {
				add(new TransportShip(650, -300, this));
				break;
			}
			case 1600: {
				add(new TransportShip(50, -300, this));
				break;
			}
			case 2200: {
				add(new TransportShip(650, -300, this));
				break;
			}
			case 2700: {
				add(new TransportShip(50, -300, this));
				break;
			}
			case 3300: {
				add(new TransportShip(650, -300, this));
				break;
			}
			case 5100: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);
					add(new BackgroundImage("planet1.png", 0, -480, 15f));
					backgroundMusic = Assets.manager.get("music/Crusade_firstContinue.mp3", Music.class);
					backgroundMusic.play();

				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;				
			}
			case 5400: {
				add(new WeaponsPlatform(300, 480, this, true));
				break;
			}
			case 5600: {
				add(new WeaponsPlatform(600, 485, this, false));
				break;
			}
			case 5800: {
				add(new WeaponsPlatform(200, 480, this, true));
				break;
			}
			case 6000: {
				add(new WeaponsPlatform(500, 490, this, false));
				break;
			}
			case 6200: {
				add(new WeaponsPlatform(20, 480, this, true));
				break;
			}
			case 6400: {
				add(new WeaponsPlatform(750, 480, this, false));
				break;
			}
			case 6600: {
				add(new WeaponsPlatform(440, 480, this, true));
				break;
			}
			case 6800: {
				add(new WeaponsPlatform(230, 480, this, false));
				break;
			}
			case 7000: {
				add(new WeaponsPlatform(300, 480, this, true));
				break;
			}
			case 7200: {
				add(new WeaponsPlatform(600, 485, this, false));
				break;
			}
			case 7400: {
				add(new WeaponsPlatform(200, 480, this, true));
				break;
			}
			case 7600: {
				add(new WeaponsPlatform(500, 490, this, true));
				break;
			}
			case 7800: {
				add(new WeaponsPlatform(20, 480, this, false));
				break;
			}
			case 8000: {
				add(new WeaponsPlatform(750, 480, this, false));
				break;
			}

			case 8400: {
				add(new WeaponsPlatform(230, 480, this, false));
				break;
			}
			case 8500: {
				add(new LastBoss(320, -310, null, this, true));
				break;
			}
			case 8800: {
				add(new WeaponsPlatform(300, 480, this, true));
				break;
			}
			case 9100: {
				add(new WeaponsPlatform(600, 485, this, true));
				break;
			}
			case 9400: {
				add(new WeaponsPlatform(200, 480, this, false));
				break;
			}
			case 9700: {
				add(new WeaponsPlatform(500, 490, this, true));
				break;
			}
			case 10000: {
				add(new WeaponsPlatform(20, 480, this, false));
				break;
			}
			case 10300: {
				add(new WeaponsPlatform(750, 480, this, false));
				break;
			}
			case 10600: {
				add(new WeaponsPlatform(110, 500, this, true));
				break;
			}
			case 10900: {
				add(new WeaponsPlatform(230, 480, this, false));
				break;
			}
			case 11200: {
				add(new WeaponsPlatform(230, 480, this, false));
				break;
			}
			case 11500: {
				add(new WeaponsPlatform(725, 485, this, true));
				break;
			}
			case 11800: {
				add(new WeaponsPlatform(200, 480, this, true));
				break;
			}
			case 12100: {
				add(new WeaponsPlatform(650, 490, this, true));
				break;
			}
			case 12400: {
				add(new WeaponsPlatform(20, 480, this, true));
				break;
			}
			case 12700: {
				add(new WeaponsPlatform(750, 480, this, false));
				break;
			}
			case 13000: {
				add(new WeaponsPlatform(140, 480, this, true));
				break;
			}
			case 13900: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);
					add(new BackgroundImage("planet1.png", 0, -1785, 15f));
					backgroundMusic = Assets.manager.get("music/Crusade_secondContinue.mp3", Music.class);
					backgroundMusic.play();

				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;				
			}
			

			
			
			case 21000: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);

				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				backgroundMusic = Assets.manager.get("music/All_This.mp3", Music.class);
				backgroundMusic.play();
				break;				
			}
			case 21100: {
				add(new LastBoss(290, 500, Pathing.lastBossCircles,this, false));
			}
			
		}
		if (levelTime > 13900 && levelTime < 18000 && levelTime % 100 == 0) {
			add(new SmallTransport(random.nextInt(750) + 50, -200, this));
			if(levelTime > 14900 && levelTime % 1000 == 0)add(new MediumTransport(random.nextInt(650) + 50, -300, this));
		}
	}
	protected void addStarsCheckpoint(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(random.nextInt(480), 0));
        	} 
	}
}
