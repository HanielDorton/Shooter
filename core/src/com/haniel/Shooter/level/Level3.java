package com.haniel.Shooter.level;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.GreenJet;
import com.haniel.Shooter.entities.enemies.GreenMine;
import com.haniel.Shooter.entities.enemies.SuperGreenJet;
import com.haniel.Shooter.entities.enemies.SuperGreenMine;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.util.Coord;

public class Level3 extends Level{
	
	//checkpoints: 5940, 11490;
	
	public Level3(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Five_Armies.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/greenbullet.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/greenmissileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
	}
	
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
		
			case 10: {
				backgroundMusic.play();
				addStarsCheckpoint(300);
				add(new BackgroundImage("levels/space_background3.png", 0, 0, 20));
		        add(new BackgroundImage("levels/space_background3.png", 0, 960, 20));				
		        increaseStarSpeed();
		        break;
			}
			case 100: {
				add(new GreenJet(-200, 480,Coord.circlenearlefttopslowlyforawhilethenleave , this));
				add(new GreenJet(800, 480,Coord.circlenearrighttopslowlyforawhilethenleave , this));
				break;
			}
			case 2550: {
				add(new SuperGreenJet(-200, 480,Coord.superJet , this));
				break;
			}
			case 5950: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background3.png", 0, 0, 3));
					add(new BackgroundImage("levels/space_background3.png", 0, 960, 3));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Five_Armies_firstContinue.mp3"));
					backgroundMusic.play();
					addStarsCheckpoint(300);
					increaseStarSpeed();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;
			}
			case 6300: {
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
				for (int i = 0; i < 4; i++ ) generateRandomMine(480 + (50 * i));
				break;
			}
			case 7800: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			case 8200: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			case 8600: {
				for (int i = 0; i < 2; i++ ) generateRandomMine(480 + (100 * i));
				break;
			}
			
			case 9000: {
				for (int i = 0; i < 4; i++ ) generateRandomMine(480 + (50 * i));
				break;
			}
			
			case 9500: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			case 10200: {
				for (int i = 0; i < 3; i++ ) generateRandomSuperMine(480 + (100 * i));
				break;
			}
			
			
			case 11500: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space_background3.png", 0, 0, 3));
					add(new BackgroundImage("levels/space_background3.png", 0, 960, 3));
					addStarsCheckpoint(300);
					increaseStarSpeed();
				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/All_This.mp3"));
				backgroundMusic.play();
				break;
				
			}
					
		}
	}
	
	private void increaseStarSpeed() {
		Iterator<MyGraphics> graphiciter = graphics.iterator();
        while(graphiciter.hasNext()) {
        	MyGraphics graphic = graphiciter.next();
        	if (graphic instanceof Star) {
        		graphic.changeSpeed(50);
        	}
        }
	}
	
	private void generateRandomMine(int y) {
		int x = random.nextInt(760) + 20;
		Coord coord = new Coord(x, -500);
		List<Coord> temp = Arrays.asList(coord);
		add(new GreenMine(x, y, temp, this));
	}
	
	private void generateRandomSuperMine(int y) {
		int x = random.nextInt(760) + 20;
		Coord coord = new Coord(x, -500);
		List<Coord> temp = Arrays.asList(coord);
		add(new SuperGreenMine(x, y, temp, this));
	}
}