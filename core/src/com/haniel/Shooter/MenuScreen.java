package com.haniel.Shooter;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.util.GameState;
import com.haniel.Shooter.weapons.Weapon;

public class MenuScreen implements Screen{
	
	OrthographicCamera camera;
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonPlay, buttonCredits, buttonExit;
	private Label title, author;
	private TextureAtlas atlas;
	private Music backgroundMusic;
    List<MyGraphics> graphics;
	
    public MenuScreen(final MyGdxGame gam) {
    	this.game = gam;  
    	camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

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
        game.batch.end();
    	stage.act(Gdx.graphics.getDeltaTime());
    	stage.draw();		
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());	
	}

	public void show() {
		backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("music/sad_Exploring.mp3"));
		backgroundMusic.play();
		backgroundMusic.setLooping(true);
        graphics = new LinkedList<MyGraphics>();
        add(new BackgroundImage("textures/Space-Background-6.jpg", 0, 0, 0));
		atlas = new TextureAtlas("ui/uiskin.atlas");
		skin = new Skin(Gdx.files.internal("ui/uiskin.json"), atlas);
		stage = new Stage();
		table = new Table(skin);
		stage.addActor(table);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		title =new Label("Grief: Surviving the Impossible", skin);
		author =new Label("A Haniel Dorton Game", skin);
		buttonPlay = new TextButton("Start Game", skin);
		buttonPlay.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				GameState gameState = new GameState(4, 0, 0, 0); //level, checkpoint, kills, continues 
	            game.setScreen(new GameScreen(game, gameState));
	            dispose();				
			}
		});
		buttonCredits = new TextButton("Credits", skin);
		buttonCredits.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
	        	game.setScreen(new CreditsScreen(game));
	            dispose();				
			}
		});
		buttonExit = new TextButton("Exit", skin);
		buttonExit.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
	        	MyGraphics.dispose();
	        	Entity.dispose();
	        	Weapon.dispose();
	            dispose();
	            Gdx.app.exit(); 				
			}
		});
		table.add(title).padBottom(30);
		table.row();
		table.add(author).padBottom(70);
		table.row();
		table.add(buttonPlay).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonCredits).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonExit).padBottom(10).width(200).height(40);
				
		
	}

	public void hide() {
	}

	public void pause() {
	}

	public void resume() {
	}

	public void dispose() {
		stage.dispose();
		backgroundMusic.dispose();		
	}
	public void add(MyGraphics g) {
		graphics.add(g);
	}


}
