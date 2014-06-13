package com.haniel.Shooter.level;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.FourthLevel.PlayerClonePathing;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.util.Pathing;

public class Level4 extends Level{
	
	//checkpoints: 
	
	public Level4(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Dark_Fog.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/thirdlevel/greenbullet.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/thirdlevel/greenmissileexplosion.p"), Gdx.files.internal("particles/"));
		smallExplosionEffectPool = new ParticleEffectPool(smallExplosionEffect, 5, 20);
		smallEngineEffect.load(Gdx.files.internal("particles/secondlevel/PlayerCloneEngine.p"), Gdx.files.internal("particles/"));
		smallEngineEffectPool = new ParticleEffectPool(smallEngineEffect, 5, 20);
		}
	public void runLevel(GameScreen g) {
		levelTime += 10;
		switch (levelTime) {
			
			case 10: {
				backgroundMusic.play();
				add(new BackgroundImage("levels/space_background4.png", 0, 0, 1));
			    add(new BackgroundImage("levels/space_background4.png", 0, 960, 1));				
			    break;
				}
			case 50: {
				add(new PlayerClonePathing(800, 525, Pathing.topLeftMiddleLeaveTop, this));
			}
			}
		
	}

}
