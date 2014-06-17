package com.haniel.Shooter;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.graphics.Star;

public class CreditsScreen implements Screen{	
	final MyGdxGame game;  
	OrthographicCamera camera;
    List<MyGraphics> graphics;
    List<credit> currentCredits;
    LinkedList<String> credits;
    double time = 3;
    int creditsCount ;
    private Music backgroundMusic;
    
    public CreditsScreen(final MyGdxGame gam) {
    	this.game = gam;      
    	camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        graphics = new LinkedList<MyGraphics>();
        currentCredits = new LinkedList<credit>();
        add(new BackgroundImage("levels/space-2.png", 0, 0, 1));
        addStarsCheckpoint(480);
        creditsCount = 0;
        credits = new LinkedList<String>();
        credits.add("Grief: Surviving the Impossible");
        credits.add("A Haniel Dorton Game");
        credits.add("Created in Java with LIBGDX");
        credits.add("All programming by Daniel Horton");
        // Art
        credits.add("Art:");
        credits.add("Player Ship & Menu Background by rawdanitsu, http://opengameart.org/art-search?keys=rawdanitsu");
        credits.add("Level 1 background by StumpyStrust, http://opengameart.org/users/stumpystrust");
        credits.add("Level 1 Enemy Ships by MillionthVector, http://millionthvector.blogspot.de/");
        credits.add("Level 2:");
        credits.add("Level 3:");
        credits.add("Level 4:");
        credits.add("Level 5:");
        credits.add("Credits Background by fraang http://opengameart.org/users/fraang");
        credits.add("");
        // MUSIC
        credits.add("Music:");
        credits.add("Main Menu: 'Sad Exploring' by Eric Taylor (erictaylormusic.com)");
        credits.add("Level 1: 'Black Vortex' by Kevin MacLeod (incompetech.com)");
        credits.add("Level 2: 'The Descent' by Kevin MacLeod (incompetech.com)");
        credits.add("Level 3: 'Five Armies' by Kevin MacLeod (incompetech.com)");
        credits.add("Level 4: 'Dark Fog' by Kevin MacLeod (incompetech.com)");
        credits.add("Level 5: 'Crusade' by Kevin MacLeod (incompetech.com)");
        credits.add("Boss Battle: 'All This' by Kevin MacLeod (incompetech.com)");
        credits.add("Credits: 'Grim League' by Kevin MacLeod (incompetech.com))");
        // SOUND EFFECTS
        credits.add("Sound Effects:");
        credits.add("Player Bullets: 'Gun_Shot-01' from http://www.soundjay.com");
        credits.add("Small Explosions: 'Paper_Rip-4' from http://www.soundjay.com");
        credits.add("First Level Enemies: 'Smatter-Zap1' from http://www.soundjay.com");
        credits.add("Boss Explosions: 'explosion-02' from http://www.soundjay.com");
        credits.add("Second Level Homing Missiles: 'explosion-01' from http://www.soundjay.com");
        credits.add("Second Level Homing Missiles Explosions: 'Paper_Rip-4' from http://www.soundjay.com");
        credits.add("");
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/Grim_League.mp3"));
        backgroundMusic.play();
        backgroundMusic.setLooping(true);
    }

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        for (MyGraphics graphic : graphics) {
        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
        	graphic.update();
        }
        for (credit cc : currentCredits) {
        	game.font.draw(game.batch, (CharSequence) cc.s, (float) cc.x, (float) cc.y);
        	cc.update();
        }
        time += Gdx.graphics.getDeltaTime();
        
        if (time > 3) {
        	time = 0;
        	currentCredits.add(new credit(credits.get(creditsCount), 380 - (credits.get(creditsCount).length() * 2.6), -10));
        	creditsCount++;
        	if (creditsCount >= credits.size()) {
        		creditsCount = 0;
        		time = -20;        		
        	}	
        }
        if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER) || (Gdx.input.isKeyPressed(Keys.SPACE))) {
        	game.setScreen(new MenuScreen(game));
            dispose();
        }

        
        game.batch.end();
		
	}
	protected void addStarsCheckpoint(int number){
        for (int i = 0; i < number; i++) {
        	add(new Star(0 + i, 0));
        	} 
	}
	public void add(MyGraphics g) {
		graphics.add(g);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		backgroundMusic.dispose();
		
	}
	private class credit {
		public String s;
		public double y;
		public double x;
		
		public credit(String s, double x, double y) {
			this.s = s;
			this.y = y;
			this.x = x;
		}
		public void update() {
			this.y += 25 * Gdx.graphics.getDeltaTime();
		}
		
	}

}
