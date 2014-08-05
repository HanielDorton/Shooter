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
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.util.GameState;

public class LevelCompleteScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonContinue;
	private Label score, grade, deaths, skips;
	private TextureAtlas atlas;
	private GameState gameState;
	private Level level;
	private int levelSkips, levelContinues;
	
	public LevelCompleteScreen (final MyGdxGame gam, GameState gameState, Level level) {
    	this.game = gam;
    	this.gameState = gameState;
    	this.level = level;
    	gameState.scores[gameState.numLevel-2] = gameState.score;
    	gameState.tempScore = 0;
    	gameState.score = 0;
    	this.levelSkips = gameState.numSkipsTemp;
    	gameState.numSkipsTemp = 0;
    	this.levelContinues = gameState.numContinuesTemp;
    	gameState.numContinuesTemp = 0;
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
		atlas = new TextureAtlas("uiskin.atlas");
		skin = new Skin(Gdx.files.internal("uiskin.json"), atlas);
		stage = new Stage();
		table = new Table(skin);
		stage.addActor(table);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());
		Gdx.input.setInputProcessor(stage);
		
		deaths = new Label("Deaths: " + levelContinues, skin);
		skips = new Label("Sections Skipped: " + levelSkips, skin);
		
		score =new Label("Score: " + gameState.scores[gameState.numLevel-2], skin);
		grade = new Label("Grade " + getGrade(), skin);
				
		buttonContinue = new TextButton("Continue", skin);
		buttonContinue.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				if (gameState.numLevel == 6) game.setScreen(new BeatGameScreen(game, gameState));
				else game.setScreen(new GameScreen(game, gameState));
				dispose();				
			}
		});
		table.add(deaths).padBottom(30);
		table.row();
		table.add(skips).padBottom(30);
		table.row();
		table.add(score).padBottom(30);
		table.row();
		table.add(grade).padBottom(30);
		table.row();
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
		level.dispose();
	}
	private String getGrade() {
		int tempScore = gameState.scores[gameState.numLevel-2] - gameState.levelMaxes[gameState.numLevel-2];
			if (tempScore > 0) return "A++";
			else if (tempScore > (-.15 * gameState.levelMaxes[gameState.numLevel-2]) ) return "A";
			else if (tempScore > (-.35 * gameState.levelMaxes[gameState.numLevel-2]) ) return "B";
			else if (tempScore > (-.55 * gameState.levelMaxes[gameState.numLevel-2]) ) return "C";
			else if (tempScore > (-.75 * gameState.levelMaxes[gameState.numLevel-2]) ) return "D";
			else return "F";
	}

}
