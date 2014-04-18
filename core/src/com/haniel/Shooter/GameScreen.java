
package com.haniel.Shooter;
 

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
//import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.haniel.Shooter.entities.Enemy_1;
import com.haniel.Shooter.entities.Entity;

public class GameScreen implements Screen {
    final MyGdxGame game;

    Texture bucketImage;
   // Sound dropSound;
    Music rainMusic;
    OrthographicCamera camera;
    Rectangle bucket;
    Array<Rectangle> raindrops;
    private List<Entity> entities = new ArrayList<Entity>();
    long lastDropTime;
    int dropsGathered;

    public GameScreen(final MyGdxGame gam) {
        this.game = gam;

        // load the images for the droplet and the bucket, 64x64 pixels each
        bucketImage = new Texture(Gdx.files.internal("entities/player.png"));

        // load the drop sound effect and the rain background "music"
        //dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("music/black_vortex.mp3"));
        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // create a Rectangle to logically represent the bucket
        bucket = new Rectangle();
        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
                        // the bottom screen edge
        bucket.width = 20;
        bucket.height = 24;

        // create the array and spawn the first raindrop
        raindrops = new Array<Rectangle>();
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
        // of the color to be used to clear the screen.
        //Gdx.gl.glClearColor(0, 0, 0.2f, 1);
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
        game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);
        game.batch.draw(bucketImage, bucket.x, bucket.y);
        for (Entity entity : entities) {
        	game.batch.draw(entity.getTexture(), entity.getX(), entity.getY());
        }
        game.batch.end();

        // process user input
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            bucket.x = touchPos.x - 64 / 2;
        }
        if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
            bucket.x += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W))
            bucket.y += 200 * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S))
            bucket.y -= 200 * Gdx.graphics.getDeltaTime();

        // make sure the player stays within the screen bounds
        if (bucket.x < 0) bucket.x = 0;
        if (bucket.x > 800 - 64) bucket.x = 800 - 64;
        if (bucket.y < 0) bucket.y = 0;
        if (bucket.y > 480) bucket.y = 480;

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
        bucketImage.dispose();
        //dropSound.dispose();
        rainMusic.dispose();
    }

}

