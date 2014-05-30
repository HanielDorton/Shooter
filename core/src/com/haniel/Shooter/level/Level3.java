package com.haniel.Shooter.level;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.entities.enemies.GreenJet;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.util.Coord;

public class Level3 extends Level{
	
	public Level3(GameScreen gameScreen) {
		super(gameScreen);
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Five_Armies.mp3"));
		//load all particle effects for pooling:
		enemyBulletEffect.load(Gdx.files.internal("particles/greenbullet.p"), Gdx.files.internal("particles/"));
		enemyBulletEffectPool = new ParticleEffectPool(enemyBulletEffect, 45, 80);
		smallExplosionEffect.load(Gdx.files.internal("particles/PlayerExplosion.p"), Gdx.files.internal("particles/"));
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
		    	Iterator<MyGraphics> graphiciter = graphics.iterator();
		        while(graphiciter.hasNext()) {
		        	MyGraphics graphic = graphiciter.next();
		        	if (graphic instanceof Star) {
		        		graphic.changeSpeed(50);
		        	}
		        }
		        break;
			}
			case 40: {
				add(new GreenJet(-200, 480,Coord.circlenearlefttopslowlyforawhilethenleave , this));
				add(new GreenJet(800, 480,Coord.circlenearrighttopslowlyforawhilethenleave , this));
				break;
			}
			case 2700: {
				
				break;
			}
		
		}
	}

}
