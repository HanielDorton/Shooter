package com.haniel.Shooter;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Assets {
	public static AssetManager manager = new AssetManager();
	
	
	public static void queueLoading(){

		manager.load("sad_Exploring.mp3", Music.class);
		manager.load("Grim_League.mp3", Music.class);
		manager.load("music/black_vortex.mp3", Music.class);
		manager.load("music/black_vortex_firstContinue.mp3", Music.class);
		manager.load("music/black_vortex_secondContinue.mp3", Music.class);
		manager.load("music/All_This.mp3", Music.class);
		manager.load("music/The_Descent.mp3", Music.class);
		manager.load("music/The_Descent_firstContinue.mp3", Music.class);
		manager.load("music/The_Descent_secondContinue.mp3", Music.class);
		manager.load("music/Five_Armies.mp3", Music.class);
		manager.load("music/Five_Armies_firstContinue.mp3", Music.class);
		manager.load("music/Dark_Fog.mp3", Music.class);
		manager.load("music/Dark_Fog_firstContinue.mp3", Music.class);
		manager.load("music/Dark_Fog_secondContinue.mp3", Music.class);
		manager.load("music/Crusade.mp3", Music.class);
		manager.load("music/Crusade_firstContinue.mp3", Music.class);
		manager.load("music/Crusade_secondContinue.mp3", Music.class);
		
		manager.load("sounds/explosion-02.wav", Sound.class);
		manager.load("sounds/paper-rip-4.wav", Sound.class);
		manager.load("sounds/explosion-01.wav", Sound.class);
		manager.load("sounds/irritating-ambient-buzz.wav", Sound.class);
		manager.load("sounds/gunshot01.wav", Sound.class);
		manager.load("sounds/smatter-zap1.wav", Sound.class);
	
		manager.load("Space-Background-6.jpg", Texture.class);
		manager.load("space-2.png", Texture.class);
		manager.load("spacebackground1.png", Texture.class);
		manager.load("Parallax100.png", Texture.class);
		manager.load("hjm-big_gas_planet_0.png", Texture.class);
		manager.load("space-1.png", Texture.class);
		manager.load("spacebackground3.png", Texture.class);
		manager.load("planet1.png", Texture.class);
		manager.load("textures/star.png", Texture.class);
		manager.load("textures/yellowStar.png", Texture.class);
		manager.load("textures/orangeStar.png", Texture.class);
		manager.load("textures/whiteStar.png", Texture.class);
		manager.load("textures/redStarLarge.png", Texture.class);
		manager.load("textures/redStar.png", Texture.class);
		manager.load("textures/checkpointreached.png", Texture.class);
		manager.load("textures/HealthBar.png", Texture.class);
		manager.load("textures/HealthBarOutline.png", Texture.class);
		manager.load("entities/Level1/alien1.png", Texture.class);
		manager.load("entities/Level1/alien2.png", Texture.class);
		manager.load("entities/Level1/alien3.png", Texture.class);
		manager.load("entities/Level1/first_boss0.png", Texture.class);
		manager.load("entities/Level1/alien2.png", Texture.class);
		manager.load("entities/Level1/alien2-1.png", Texture.class);
		manager.load("entities/Level1/alien2-2.png", Texture.class);
		manager.load("entities/Level1/alien2-3.png", Texture.class);
		manager.load("entities/Level1/alien2-4.png", Texture.class);
		manager.load("entities/Level1/alien2-5.png", Texture.class);
		manager.load("entities/Level2/aliensprite2.png", Texture.class);
		manager.load("entities/Level2/smallorange.png", Texture.class);
		manager.load("entities/Level2/smallorange2.png", Texture.class);
		manager.load("entities/Level2/orangeship.png", Texture.class);
		manager.load("entities/Level3/smalljet.png", Texture.class);
		manager.load("entities/Level3/destroyer1.png", Texture.class);
		manager.load("entities/Level3/Spacestation-by-MillionthVector.png", Texture.class);
		manager.load("entities/Level3/spaceshipspr.png", Texture.class);
		manager.load("entities/Level4/F5S3-0.png", Texture.class);
		manager.load("entities/Level4/F5S3-05.png", Texture.class);
		manager.load("entities/Level4/F5S3-1.png", Texture.class);
		manager.load("entities/Level4/F5S3-15.png", Texture.class);
		manager.load("entities/Level4/F5S3-2.png", Texture.class);
		manager.load("entities/Level4/F5S3-25.png", Texture.class);
		manager.load("entities/Level4/F5S3-3.png", Texture.class);
		manager.load("entities/Level4/F5S3-35.png", Texture.class);
		manager.load("entities/Level4/F5S3-4.png", Texture.class);
		manager.load("entities/Level4/F5S3-45.png", Texture.class);
		manager.load("entities/Level4/F5S3-5.png", Texture.class);
		manager.load("entities/Level4/F5S3-6.png", Texture.class);
		manager.load("entities/Level4/F5S3-7.png", Texture.class);
		manager.load("entities/Level4/F5S3-8.png", Texture.class);
		manager.load("entities/Level4/F5S3-9.png", Texture.class);
		manager.load("entities/Level4/F5S3.png", Texture.class);
		manager.load("entities/Level4/F5S1-0.png", Texture.class);
		manager.load("entities/Level4/F5S1-05.png", Texture.class);
		manager.load("entities/Level4/F5S1-1.png", Texture.class);
		manager.load("entities/Level4/F5S1-15.png", Texture.class);
		manager.load("entities/Level4/F5S1-2.png", Texture.class);
		manager.load("entities/Level4/F5S1-25.png", Texture.class);
		manager.load("entities/Level4/F5S1-3.png", Texture.class);
		manager.load("entities/Level4/F5S1-35.png", Texture.class);
		manager.load("entities/Level4/F5S1-4.png", Texture.class);
		manager.load("entities/Level4/F5S1-45.png", Texture.class);
		manager.load("entities/Level4/F5S1-5.png", Texture.class);
		manager.load("entities/Level4/F5S1-6.png", Texture.class);
		manager.load("entities/Level4/F5S1-7.png", Texture.class);
		manager.load("entities/Level4/F5S1-8.png", Texture.class);
		manager.load("entities/Level4/F5S1-9.png", Texture.class);
		manager.load("entities/Level4/F5S1.png", Texture.class);
		manager.load("entities/Level4/F5S4.png", Texture.class);
		manager.load("entities/Level5/3.png", Texture.class);
		manager.load("entities/Level5/2.png", Texture.class);
		manager.load("entities/Level5/5.png", Texture.class);
		manager.load("entities/Level5/11.png", Texture.class);
		manager.load("entities/Level5/13.png", Texture.class);
		manager.load("entities/player/ship-5.png", Texture.class);
		manager.load("entities/player/ship-4.png", Texture.class);
		manager.load("entities/player/ship-3.png", Texture.class);
		manager.load("entities/player/ship-2.png", Texture.class);
		manager.load("entities/player/ship-1.png", Texture.class);
		manager.load("entities/player/ship0.png", Texture.class);
		manager.load("entities/player/ship1.png", Texture.class);
		manager.load("entities/player/ship2.png", Texture.class);
		manager.load("entities/player/ship3.png", Texture.class);
		manager.load("entities/player/ship4.png", Texture.class);
		manager.load("entities/player/ship5.png", Texture.class);
		
	
	}
	
    public static boolean update() {
        return manager.update();
    }

}

