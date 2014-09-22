package com.haniel.Shooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.haniel.Shooter.MyGdxGame;
import com.haniel.Shooter.util.DesktopActionResolver;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    config.title = "Grief: Surviving the Impossible";
	    config.width = 800;
	    config.height = 480;
	      
		new LwjglApplication(new MyGdxGame(new DesktopActionResolver()), config);
	}
}
