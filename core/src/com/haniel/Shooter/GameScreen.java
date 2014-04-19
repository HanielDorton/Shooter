
package com.haniel.Shooter;
 

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
//import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.haniel.Shooter.entities.Enemy_1;
import com.haniel.Shooter.entities.Entity;
import com.haniel.Shooter.entities.Player;
import com.haniel.Shooter.graphics.BackgroundImage;
import com.haniel.Shooter.graphics.Graphic;
import com.haniel.Shooter.graphics.Star;
import com.haniel.Shooter.level.Level;

public class GameScreen implements Screen {
    final MyGdxGame game;
   // Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<Graphic> graphics = new ArrayList<Graphic>();
    long lastDropTime;
    int shipsDestroyed;
    Random rand = new Random();
    public double gameTime = 0;
    Level level = new Level();

    public GameScreen(final MyGdxGame gam) {
        this.game = gam;

        // load the drop sound effect and the rain background "music"
        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
        //Background
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 0, .5f));
        graphics.add(new BackgroundImage("levels/space_background2.png", 0, 960, .5f));
        
        for (int i = 0; i < 500; i++) {Level
        	graphics.add(new Star(rand.nextInt(480) + 1));
        }
        
        //Player
        entities.add(new Player());
        
        //first enemy
        spawnEnemy_1();

    }
    
    private void spawnEnemy_1() {
    	Enemy_1 enemy_1 = new Enemy_1(MathUtils.random(0, 800), 480);
    	entities.add(enemy_1);
        lastDropTime = TimeUtils.nanoTime();
    }

    @Override
    public void render(float delta) {
        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be usGdx.graphics.getDeltaTime()ed to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);

        // begin a new batch and draw the bucket and
        // all drops
        game.batch.begin();
        for (Graphic graphic : graphics) {
        	game.batch.draw(graphic.getTexture(), graphic.getX(), graphic.getY());
        }
        game.font.draw(game.batch, "Ships Destroyed: " + shipsDestroyed, 0, 480);
        for (Entity entity : entities) {
        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY());
        }
        game.batch.end();

        
        // check if we need to create a new raindrop
        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
            //spawnRaindrop();
        	spawnEnemy_1();
        
        // move the raindrops, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we increase the 
        // value our drops counter and add a sound effect.
        /*
        Iterator<Rectangle> iter = raindrops.iterator();
        while (iter.hasNext()) {
            Rectangle raindrop = iter.next();
            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (raindrop.y + 64 < 0)
                iter.remove();
            if (raindrop.overlaps(bucket)) {
                dropsGathered++;
               // dropSound.play();
                iter.remove();
            }
*/
        for (int i = 0; i < entities.size(); i++) {
        	entities.get(i).update();
        	if (entities.get(i).isRemoved()) {
        		entities.remove(entities.get(i));
        	}
        }
        for (int i = 0; i < graphics.size(); i++) {
        	graphics.get(i).update();
        	if (graphics.get(i).isRemoved()) {
        		if (graphics.get(i) instanceof Star) graphics.add(new Star(480));
        		graphics.remove(graphics.get(i));
        	}
        }
        
        
        //System.out.println(Gdx.graphics.getDeltaTime());
        gameTime += Gdx.graphics.getDeltaTime();
        if (gameTime > 1) {
        	//System.out.println(gameTime);
        	level.update();
        	gameTime--;
        }
        

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
        rainMusic.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        //dropSound.dispose();
        rainMusic.dispose();
    }

}

