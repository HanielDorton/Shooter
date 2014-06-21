package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.CheckpointReached;
import com.haniel.Shooter.graphics.Star;

public class Level5 extends Level{
	
	//checkpoints: 5190,13900 for this section, 20090 for boss
	//first section: quick 50 second intro section quick firing quick movements with you destorying A LOT
		// maybe auto defense system with the little guys facing you and pouring bullets at you?
	//second section- medium guys go buy with bullets out of the sides mainly?
	//third section
	//boss

	
	public Level5(GameScreen gameScreen){
		super(gameScreen);
		this.name = "5: Acceptance";
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Crusade.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/level4/purplesphere.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/level4/purpleexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		}
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
			
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/space-2.png", 0, 0, 1));
				addStarsCheckpoint(100);
				add(new BackgroundImage("levels/planet1.png", -1100, 300, 15f));
			    break;
			}
			
			
			
			case 5100: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/planet1.png", -1100, -480, 15f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Crusade_firstContinue.mp3"));
					backgroundMusic.play();

				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;				
			}

			
			
			
			case 13900: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/planet1.png", -1100, -1785, 15f));
					backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Crusade_secondContinue.mp3"));
					backgroundMusic.play();

				} else {
					add(new CheckpointReached(300, 350, 2));
					gameScreen.setCheckPoint(levelTime - 10);
				}
				break;				
			}
			

			
			
			case 20100: {
				if (gameScreen.getCheckPoint() + 10 == levelTime) {
					add(new BackgroundImage("levels/space-2.png", 0, 0, 1));
					addStarsCheckpoint(100);
					add(new BackgroundImage("levels/planet1.png", -1100, -2715, 15f));

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
	protected void addStarsCheckpoint(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(random.nextInt(480), 0));
        	} 
	}
}
