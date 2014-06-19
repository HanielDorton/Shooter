package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.Level2.CargoCraft;
import com.haniel.Shooter.entities.enemies.Level2.ImprovedRedEnemy;
import com.haniel.Shooter.entities.enemies.Level2.RedEnemy;
import com.haniel.Shooter.entities.enemies.Level2.SecondBoss;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.util.Pathing;

public class Level2 extends Level{
	
	///checkpoints: 6890, 10790, 18390

	
	public Level2(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/secondlevel/redsphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/secondlevel/enemyexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 5);
		smallExplosionEffect2.load(Gdx.files.internal("particles/secondlevel/missileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffect2Pool = new ParticleEffectPool(smallExplosionEffect2, 5, 8);
		smallEngineEffect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/Parallax100.png", 0, 0, 1f));
				addStarsCheckpoint(100);
				add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 350, 1.5f));

				break;
			}
			case 200: {
				add(new RedEnemy(0, 525, Pathing.leaveBottom, this));
				break;
			}
			case 300: {
				add(new RedEnemy(800, 525, Pathing.leaveBottom2, this));
				break;
			}
			case 400: {
				add(new RedEnemy(400, 525, Pathing.leaveBottomLeft, this));
				break;				
			}
			case 500: {
				add(new RedEnemy(400, 525, Pathing.leaveBottomRight, this));
				break;
			}
			case 600: {
				add(new RedEnemy(100, 525, Pathing.leaveBottom3, this));
				break;
			}
			case 700: {
				add(new RedEnemy(700, 525, Pathing.leaveBottom4, this));
				break;
			}
			case 800: {
				add(new RedEnemy(300, 525, Pathing.leaveBottomLeft2, this));
				break;				
			}
			case 900: {
				add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}
			case 1000: {
				add(new RedEnemy(200, 525, Pathing.leaveBottom5, this));
				break;
			}
			case 1100: {
				add(new RedEnemy(600, 525, Pathing.leaveBottom6, this));
				break;
			}
			case 1200: {
				add(new RedEnemy(200, 525, Pathing.leaveBottomLeft3, this));
				break;				
			}
			case 1300: {
				add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}
			case 1400: {
				add(new RedEnemy(0, 525, Pathing.leaveBottom, this));
				break;
			}
			case 1500: {
				add(new RedEnemy(800, 525, Pathing.leaveBottom2, this));
				break;
			}
			case 1600: {
				add(new RedEnemy(400, 525, Pathing.leaveBottomLeft, this));
				break;				
			}
			case 1700: {
				add(new RedEnemy(400, 525, Pathing.leaveBottomRight, this));
				break;
			}
			case 1800: {
				add(new RedEnemy(100, 525, Pathing.leaveBottom3, this));
				break;
			}
			case 1900: {
				add(new RedEnemy(700, 525, Pathing.leaveBottom4, this));
				break;
			}
			case 2000: {
				add(new RedEnemy(300, 525, Pathing.leaveBottomLeft2, this));
				break;				
			}
			case 2100: {
				add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}
			case 2200: {
				add(new RedEnemy(200, 525, Pathing.leaveBottom5, this));
				break;
			}
			case 2300: {
				add(new RedEnemy(600, 525, Pathing.leaveBottom6, this));
				break;
			}
			case 2400: {
				add(new RedEnemy(200, 525, Pathing.leaveBottomLeft3, this));
				break;				
			}
			case 2500: {
				add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}
			case 2650: {
				add(new RedEnemy(800, 525, Pathing.leaveBottom2, this));
				break;
			}
			case 2800: {
				add(new RedEnemy(100, 525, Pathing.leaveBottom3, this));
				break;
			}
			case 2950: {
				 add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}
			case 3100: {
				add(new RedEnemy(200, 525, Pathing.leaveBottomLeft3, this));
				break;				
			}
			case 3230: {
				add(new RedEnemy(800, 525, Pathing.leaveBottom2, this));
				break;
			}
			case 3290: {
				add(new RedEnemy(400, 525, Pathing.leaveBottomRight, this));
				break;
			}
			case 3380: {
				add(new RedEnemy(300, 525, Pathing.leaveBottomLeft2, this));
				break;				
			}
			case 3440: {
				add(new RedEnemy(200, 525, Pathing.leaveBottom5, this));
				break;
			}
			case 3530: {
				add(new RedEnemy(600, 525, Pathing.leaveBottomRight2, this));
				break;
			}			
			case 4100: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				break;
			}
			case 4300: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				break;
			}
			case 4500: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				break;
			}
			case 4700: {
				add(new CargoCraft(-100, 500, Pathing.goLeft, this, true));
				break;
			}
			case 4900: {
				add(new CargoCraft(-100, 500, Pathing.goLeft, this, true));
				break;
			}
			case 5100: {
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			case 5600: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			case 6000: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			case 6400: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}		
			case 6900: { //next checkpoitn 108
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/Parallax100.png", 0, 0, 1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 246, 1.5f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_firstContinue.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 7200: {
				threeFighterFormation();
				break;
			}
			case 7600: {
				threeFighterFormation();
				break;
			}
			case 7800: {
				threeFighterFormation();
				break;
			}
			case 7900: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			case 8400: {
				threeFighterFormation();
				break;
			}
			case 8600: {
				threeFighterFormation();
				break;
			}
			case 8900: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			case 9400: {
				threeFighterFormation();
				break;
			}
			case 9600: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}
			
			case 9800: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}

			case 10300: {
				add(new CargoCraft(-100, 500, Pathing.goRight, this, false));
				add(new CargoCraft(-100, 300, Pathing.goLeft, this, true));
				break;
			}

			
			case 10800: { 
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/Parallax100.png", 0, 0, 1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 188, 1.5f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent_secondContinue.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 10810: {
				add(new SecondBoss(240, -700, Pathing.bottomToTopMiddle, this, true));
				break;
			}
			case 18400: { 
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/Parallax100.png", 0, 0, 1f));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/hjm-big_gas_planet_0.png", 80, 74, 1.5f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
					backgroundMusic.stop();
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
					backgroundMusic.play();
				}
				add(new SecondBoss(240, 800, Pathing.hoverAtTop, this, false));			
				break;
			}
			
		}
	}
	
	protected void addStarsCheckpoint(int number){
        for (int i = 1; i < (number / 2); i++) {
        	add(new Star(random.nextInt(480), 4));
        	add(new Star(random.nextInt(480), 5));
        	} 
	}
	
	public void threeFighterFormation() {
		for (int i = 0; i < 6; i++) {
			if (!(i % 2 == 0)) add(new ImprovedRedEnemy((175 * i) - 150, 575, this));
			}
		}
	}


