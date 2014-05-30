package com.haniel.Shooter;

import java.util.LinkedList;

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
import com.haniel.Shooter.util.GameState;

public class LevelIntroScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonContinue;
	private Label levelName, text1, text2, text3, text4, text5;
	private TextureAtlas atlas;
	private GameState gameState;
	
	public LevelIntroScreen (final MyGdxGame gam, GameState gameState) {
    	this.game = gam;
    	this.gameState = gameState;
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
		
		LinkedList<String> levelText = getLevelText();
		levelName = new Label(levelText.get(0), skin);
		text1 = new Label(levelText.get(1), skin);
		text2 = new Label(levelText.get(2), skin);
		text3 = new Label(levelText.get(3), skin);
		text4 = new Label(levelText.get(4), skin);
		text5 = new Label(levelText.get(5), skin);
		
		
		
		
		table.add(levelName).padBottom(60);
		table.row();
		table.add(text1);
		table.row();
		table.add(text2);
		table.row();
		table.add(text3);
		table.row();
		table.add(text4);
		table.row();
		table.add(text5).padBottom(30);
		table.row();
		buttonContinue = new TextButton("Begin", skin);
		buttonContinue.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new GameScreen(game, gameState));
				dispose();				
			}
		});
		
		
		table.add(buttonContinue).width(200).height(40);
	}
	
	private LinkedList<String> getLevelText() {
		LinkedList<String> levelText = new LinkedList<String>();
		switch (gameState.numLevel) {
		case 1: {
			levelText.add("Level 2: Anger");
			levelText.add("You intercept a coded signal from a covert military branch nicknamed ENSA.");
			levelText.add("You were wrong. The aliens didn't destory Earth.");
			levelText.add("The destruction you witnessed was an unprovoked attack on a peaceful alien civilization.");
			levelText.add("They brainwashed and used you to carry out the attack.");
			levelText.add("They are now sending their attack carrier to silence you.");
		}
		case 2: {
			levelText.add("Level 3: Bargaining");
			levelText.add("With the attack carrier destroyed, you are free to race home to expose the illegal operations of ENSA");
			levelText.add("But your sensors pick up the signals of the remnants of the alien fleet.");
			levelText.add("They are regrouping in a nearby sector to counterattack.");
			levelText.add("Little do they know, the sector they are regrouping in is sorrounded by cloaked Earth fleets.");
			levelText.add("If you can only save them...");
		}
		case 3: {
			levelText.add("Level 4: Depression");
			levelText.add("You are too late.");
			levelText.add("Blown up bits of the alien fleet float all around you.");
			levelText.add("There is no one left to save now.");
			levelText.add("And after attacking the Earth fleet, there is no home to retreat to.");
			levelText.add("You cut your engines.");
		}
		case 4: {
			levelText.add("Level 5: Acceptance");
			levelText.add("");
			levelText.add("");
			levelText.add("");
			levelText.add("");
			levelText.add("");
		}
		default: {
			levelText.add("Level 1 : Denial");
			levelText.add("You wake up in your cockpit just in time to witness the obliteration of Earth. ");
			levelText.add("No friendly ships are in sight.");
			levelText.add("You are alone.");
			levelText.add("An unknown enemy fleet bears down on you as you attempt escape.");
			levelText.add("");
		}
		}
		return levelText;
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
