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

public class LevelCompleteScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonContinue, buttonScores, buttonAchievements;;
	private Label score, deaths, skips;
	private TextureAtlas atlas;
	private GameState gameState;
	private ActionResolver actionResolver;
	
	public LevelCompleteScreen (final MyGdxGame gam, GameState gameState, ActionResolver actionResolve) {
    	this.game = gam;
    	this.gameState = gameState;
    	this.actionResolver = actionResolve;
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
			 actionResolver.submitScoreGPGS(gameState.score);
		}
		atlas = new TextureAtlas("uiskin.atlas");
		skin = new Skin(Gdx.files.internal("uiskin.json"), atlas);
		stage = new Stage();
		table = new Table(skin);
		stage.addActor(table);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		deaths = new Label("Deaths: " + gameState.numContinues, skin);
		skips = new Label("Sections Skipped: " + gameState.numSkips, skin);		
		score =new Label("Score: " + gameState.score, skin);
				
		buttonContinue = new TextButton("Continue", skin);
		buttonContinue.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if (gameState.numLevel == 6) game.setScreen(new BeatGameScreen(game, gameState, actionResolver));
				else game.setScreen(new GameScreen(game, gameState, actionResolver));
				dispose();				
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
		table.add(deaths).padBottom(30);
		table.row();
		table.add(skips).padBottom(30);
		table.row();
		table.add(score).padBottom(30);
		table.row();
		if (actionResolver.getSignedInGPGS()) {
			table.add(buttonScores).padBottom(10).width(200).height(40);
			table.row();
			table.add(buttonAchievements).padBottom(10).width(200).height(40);
			table.row();
		}
		table.add(buttonContinue).width(200).height(40);
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

}
