package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;

public class LevelSecond extends Level{
	
	ParticleEffect nebula = new ParticleEffect();

	
	
	public LevelSecond(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/firstlevel/BlueSphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/firstlevel/BlueExplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		
		nebula.load(Gdx.files.internal("particles/Nebula.p"), Gdx.files.internal("particles/"));
		nebula.setPosition(-100, 470);
		nebula.start();
		particleEffects.add(nebula);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				nebula.setPosition(-100, 460);
				//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
		        //add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
		        //addStarsCheckpoint(80);
				break;
			}
			case 100: {
				nebula.setPosition(-100, 430);
				break;
			}
			case 200: {
				nebula.setPosition(-100, 400);
				break;
			}
			case 300: {
				nebula.setPosition(-100, 370);
				break;
			}
			case 400: {
				nebula.setPosition(-100, 340);
				break;
			}
			case 500: {
				nebula.setPosition(-100, 310);
				break;
			}
			case 600: {
				nebula.setPosition(-100, 280);
				break;
			}
			case 700: {
				nebula.setPosition(-100, 250);
				break;
			}
			case 800: {
				nebula.setPosition(-100, 220);
				break;
			}
			case 900: {
				nebula.setPosition(-100, 190);
				break;
			}
			case 1000: {
				nebula.setPosition(-100, 160);
				break;
			}
			case 1100: {
				nebula.setPosition(-100, 130);
				break;
			}
			case 1200: {
				nebula.setPosition(-100, 100);
				break;
			}
			case 1300: {
				nebula.setPosition(-100, 75);
				break;
			}
			case 1400: {
				nebula.setPosition(-100, 50);
				break;
			}
			case 1500: {
				nebula.setPosition(-100, 25);
				break;
			}
			case 1600: {
				nebula.setPosition(-100, 0);
				break;
			}
			
		}
	}
}
