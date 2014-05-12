package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.PlayerClone;
import com.haniel.Shooter.util.Coord;

public class LevelSecond extends Level{
	
	ParticleEffect nebula = new ParticleEffect();

	
	
	public LevelSecond(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/The_Descent.mp3"));
		//load all particle effects for pooling:
		//enemyBulletEffect.load(Gdx.files.internal("particles/firstlevel/BlueSphere.p"), Gdx.files.internal("particles/"));
		//enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/PlayerExplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallEngineEffect.load(Gdx.files.internal("particles/PlayerCloneEngine.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
		
		//use this for third phase
		//nebula.load(Gdx.files.internal("particles/Nebula.p"), Gdx.files.internal("particles/"));
		//nebula.setPosition(-100, 470);
		//nebula.start();
		//overlayedParticleEffects.add(nebula);
	}

	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				addStarsCheckpoint(200);
				//add(new BackgroundImage("levels/space_background2.png", 0, 0, 3));
		        //add(new BackgroundImage("levels/space_background2.png", 0, 960, 3));
		        //addStarsCheckpoint(80);
				break;
			}
			case 300: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 350: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 400: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 450: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 500: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 550: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 600: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 650: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 700: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 750: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 800: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 850: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 900: {
				add(new PlayerClone(random.nextInt(300), 480, Coord.leavebottom, this));
				break;
			}
			case 950: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 1000: {
				add(new PlayerClone(random.nextInt(400), 480, Coord.leavebottom, this));
				break;
			}
			case 1050: {
				add(new PlayerClone(random.nextInt(300) + 500, 480, Coord.leavebottom, this));
				break;
			}
			case 1100: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1150: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1200: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1250: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1300: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1350: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1400: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1450: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1500: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1550: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1600: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1650: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1700: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1750: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			case 1800: {
				add(new PlayerClone(random.nextInt(200) + 200, 480, Coord.leavebottomleftlist, this));
				break;				
			}
			case 1850: {
				add(new PlayerClone(random.nextInt(200) + 400, 480, Coord.leavebottomrightlist, this));
				break;
			}
			
		}
	}
}
