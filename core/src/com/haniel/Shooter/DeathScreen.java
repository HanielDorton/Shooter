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
import com.haniel.Shooter.projectiles.Projectile;
import com.haniel.Shooter.weapons.Weapon;

public class DeathScreen implements Screen{
	final MyGdxGame game; 
	private Stage stage;
	private Skin skin;
	private Table table;
	private TextButton buttonContinue, buttonMenu, buttonExit;
	private TextureAtlas atlas;
	private int numContinues, checkPoint, numLevel;
	
    public DeathScreen(final MyGdxGame gam, int numContinues, int checkPoint, int numLevel) {
    	this.game = gam;
    	this.numContinues = numContinues;
    	this.checkPoint = checkPoint;
    	this.numLevel = numLevel;
    }

	@Override
	public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	stage.act(Gdx.graphics.getDeltaTime());
    	stage.draw();			
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		table.setBounds(0, 0, stage.getWidth(), stage.getHeight());			
	}

	@Override
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
				game.setScreen(new GameScreen(game, numContinues, checkPoint, numLevel));
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
				Projectile.dispose();
	        	MyGraphics.dispose();
	        	Entity.dispose();
	        	Weapon.dispose();
	            dispose();
	            Gdx.app.exit(); 				
			}
		});
		table.add(buttonContinue).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonMenu).padBottom(10).width(200).height(40);
		table.row();
		table.add(buttonExit).padBottom(10).width(200).height(40);
		
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
		stage.dispose();
		
	}

}
