package com.haniel.Shooter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {

    final MyGdxGame game;    
    OrthographicCamera camera;


    public MainMenuScreen(final MyGdxGame gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
    }
    
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.font.draw(game.batch, "Grief: Surviving the Impossible", 400, 300);
        game.font.draw(game.batch, "A Haniel Dorton Game", 400, 250);
        game.font.draw(game.batch, "Click to begin", 400, 200);
        game.font.draw(game.batch, "Space for Credits", 400, 150);
        game.batch.end();

        if (Gdx.input.isTouched() || Gdx.input.isKeyPressed(Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
            dispose();
        }
        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            game.setScreen(new CreditsScreen(game));
            dispose();
        }
    }


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		//batch.dispose();
		
	}
}

