package com.haniel.Shooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.graphics.MyGraphics;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.GameState;
import com.haniel.Shooter.weapons.Weapon;

public class DeathScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonContinue, buttonSkip, buttonMenu, buttonExit;
	private TextureAtlas atlas;
	private GameState gameState;
	private Level level;
	
    public DeathScreen(final MyGdxGame gam, GameState gameState, Level level) {
    	this.game = gam;
    	this.gameState = gameState;
    	this.level = level;
    }

	public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	stage.act(Gdx.graphics.getDeltaTime());
    	stage.draw();			
	}

	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());			
	}

	public void show() {
		atlas = new TextureAtlas("ui/uiskin.atlas");
		skin = new Skin(Gdx.files.internal("ui/uiskin.json"), atlas);
		stage = new Stage();
		table = new Table(skin);
		stage.addActor(table);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);
		

		buttonContinue = new TextButton("Retry from Check Point", skin);
		buttonContinue.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new GameScreen(game, gameState));
				dispose();				
			}
		});
		buttonSkip = new TextButton("Skip this Section", skin);
		buttonSkip.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				skipSection();
				game.setScreen(new GameScreen(game, gameState));
				dispose();				
			}
		});
		buttonMenu = new TextButton("Return to Main Menu", skin);
		buttonMenu.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
	        	game.setScreen(new MenuScreen(game));
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
		table.add(buttonContinue).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonSkip).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonMenu).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonExit).width(200).height(40);
		
	}
	
	public void hide() {
	}

	public void pause() {
	}

	public void resume() {
	}

	public void dispose() {
		stage.dispose();
		level.dispose();		
	}
	public void skipSection() {
		if (gameState.numLevel == 5 && gameState.checkPoint == 3) return;
		if (gameState.checkPoint < (gameState.getCheckpoints(gameState.numLevel)).length - 1) gameState.checkPoint++;
		else {
			gameState.checkPoint = 0;
			gameState.numLevel++;
		}
	}

}
