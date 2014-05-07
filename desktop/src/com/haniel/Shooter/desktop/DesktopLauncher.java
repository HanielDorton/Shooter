package com.haniel.Shooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.haniel.Shooter.MyGdxGame;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    config.title = "Drop";
	    config.width = 800;
	    config.height = 480;
	      
		new LwjglApplication(new MyGdxGame(), config);
	}
}
