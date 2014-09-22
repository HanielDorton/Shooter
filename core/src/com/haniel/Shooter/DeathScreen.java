package com.haniel.Shooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.haniel.Shooter.util.ActionResolver;
import com.haniel.Shooter.util.GameState;

public class DeathScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private Label score;
	private TextButton buttonContinue, buttonSkip, buttonMenu, buttonExit, buttonScores, buttonAchievements;
	private TextureAtlas atlas;
	private GameState gameState;
	private int highScore;
	private ActionResolver actionResolver;
	
    public DeathScreen(final MyGdxGame gam, GameState gameState, ActionResolver actionResolve) {
    	this.game = gam;
    	this.gameState = gameState;
    	this.actionResolver = actionResolve;
    	gameState.numContinues += 1;
    	this.highScore = gameState.score;
    	gameState.score = 0;
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
		if (actionResolver.getSignedInGPGS()) {
			 actionResolver.submitScoreGPGS(highScore);
		}
		atlas = new TextureAtlas("uiskin.atlas");
		skin = new Skin(Gdx.files.internal("uiskin.json"), atlas);
		stage = new Stage();
		table = new Table(skin);
		stage.addActor(table);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);		

		score =new Label("Score: " + highScore, skin);
		
		buttonContinue = new TextButton("Retry from Check Point", skin);
		buttonContinue.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new GameScreen(game, gameState, actionResolver));
				dispose();				
			}
		});
		buttonSkip = new TextButton("Skip this Section", skin);
		buttonSkip.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				skipSection();
				game.setScreen(new GameScreen(game, gameState, actionResolver));
				dispose();				
			}
		});
		buttonMenu = new TextButton("Return to Main Menu", skin);
		buttonMenu.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
	        	game.setScreen(new MenuScreen(game, actionResolver));
	            dispose();				
			}
		});
		buttonExit = new TextButton("Exit", skin);
		buttonExit.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
	            dispose();
	            Gdx.app.exit(); 				
			}
		});
		buttonScores = new TextButton("High Scores", skin);
		buttonScores.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.actionResolver.getLeaderboardGPGS();
			}
		});
		
		buttonAchievements = new TextButton("Achievements", skin);
		buttonAchievements.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.actionResolver.getAchievementsGPGS();
			}
		});
		table.add(score).padBottom(10);
		table.row();
		table.add(buttonContinue).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonSkip).padBottom(10).width(200).height(40);
		table.row();
		if (actionResolver.getSignedInGPGS()) {
			table.add(buttonScores).padBottom(10).width(200).height(40);
			table.row();
			table.add(buttonAchievements).padBottom(10).width(200).height(40);
			table.row();
		}
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
	}
	public void skipSection() {
		if (gameState.numLevel == 5 && gameState.checkPoint == 3) return;
		if (gameState.checkPoint < (gameState.getCheckpoints(gameState.numLevel)).length - 1) {
			gameState.checkPoint++;
			gameState.numSkips += 1;

		}
		else {
			gameState.checkPoint = 0;
			gameState.numLevel++;
			gameState.numSkips += 1;
			
		}
	}

}
