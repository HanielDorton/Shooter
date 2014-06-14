package com.haniel.Shooter.entities;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.PlayerGun;


public class Player extends Entity{
	
	private List<Sprite> playerSprites = new LinkedList<Sprite>();
	
    private boolean shooting = false;;
    private int maxSpeed;
    private int keyboardSpeed;
    private GameScreen gameScreen;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();
	private float tilt, tiltSpeed;
	private int currentSprite;
	private boolean movingLeft, movingRight;


	
	public Player(Level level) {
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship-5.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship-4.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship-3.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship-2.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship-1.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship0.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship1.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship2.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship3.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship4.png"))));
		playerSprites.add(new Sprite(new Texture(Gdx.files.internal("entities/player/ship5.png"))));
		
		this.level = level;
		this.x = 400;
		this.y = 20;
		this.width = 40;
		this.height = 35;
		this.xOffset = 5;
		this.yOffset = 5;
		this.currentSprite = 5;
		this.sprite = playerSprites.get(currentSprite);
		this.rectangle = new Rectangle((float) x + xOffset, (float) y + yOffset, width, height);
		this.speed = 30;
		this.keyboardSpeed = 11;
		this.maxSpeed = 40;
		this.lastShot= 0;
		this.health = 1;
		this.tilt = 0;
		this.tiltSpeed = 0.02f;
		this.movingLeft = false;
		this.movingRight = false;
		this.weapon = new PlayerGun(level, true);
		this.engine1Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 22,(int) y + 5);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 27,(int) y + 5);
		level.particleEffects.add(engine2Effect);
	}
	public void update() {
		/*	
		if (Gdx.input.isTouched()) {
		        //touchPos = new Vector3();GameScreen g
		        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
		}
	
		if (touchPos.x < x)
	        x -= 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.x > x)
	        x += 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.y < y)
	        y += 200 * Gdx.graphics.getDeltaTime();
	    if (touchPos.y > y)
	        y -= 200 * Gdx.graphics.getDeltaTime();
	     */

		if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) {
			movePlayer(-keyboardSpeed , 0);
			movingLeft = true;
	        
		}
	    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
	    	movePlayer(keyboardSpeed , 0);
	    	movingRight = true;
	    	
	    }
	    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
	    	movePlayer(0, keyboardSpeed );
			
	    }
	    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S)) {
	    	movePlayer(0, -keyboardSpeed );
			
	    }
		
	    if (shooting ||  Gdx.input.isKeyPressed(Keys.ENTER)) {
	    	if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y+30);
	    		weapon.shoot(x - 1, y + 25, angle);
	    		weapon.shoot(x + width + xOffset, y + 25, angle);
	    		lastShot = level.getTime();
	    		weapon.playSound();
	    	}
	    }
	
	    //keep player in bounds:
	    if (x < 0) x = 0;
	    if (x > gameScreen.getWidth() - (width + xOffset * 2)) x = gameScreen.getWidth() - (width + xOffset * 2);
	    if (y < 0) y = 0;
	    if (y > gameScreen.getHeight() - (height + yOffset * 2)) y = gameScreen.getHeight() - (height + yOffset *2);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    // reset engines	    
	    engine1Effect.setPosition((int)x + 22,(int) y + 5);
	    engine2Effect.setPosition((int)x + 27,(int) y + 5);
	    // tilt player based on direction moved
	    if (tilt > 0) tilt -= Gdx.graphics.getDeltaTime();
	    else if (movingLeft){
	    	tilt = tiltSpeed;
	    	if (currentSprite > 0) currentSprite--;
	    	movingLeft = false;
	    }else if (movingRight){
	    	tilt = tiltSpeed;
	    	if (currentSprite < 10) currentSprite++;
	    	movingRight = false;
	    }else{
	    	//if not movingleftor right reposition back to center
	    	if (currentSprite < 5) {
	    		tilt = tiltSpeed;
	    		currentSprite++;	    		
	    	} else if (currentSprite > 5) {
	    		tilt = tiltSpeed;
	    		currentSprite--;		    		
	    	}
	    }
	    this.sprite = playerSprites.get(currentSprite);
	    

	}
	
	public void movePlayer(int moveX, int moveY) {
		if (Math.abs(moveX) > maxSpeed) moveX = (maxSpeed * myAbs(moveX));
		if (Math.abs(moveY) > maxSpeed) moveY = (maxSpeed * myAbs(moveY));
		move(speed * moveX, speed * moveY);	
		if (moveX > 0) movingRight = true;
		else if (moveX < 0) movingLeft = true;
	}
	
	public void startShooting() {
		shooting = true;
	}
	public void stopShooting() {
		shooting = false;
	}

	public void particles(){
		//on death:
		engine1Effect.allowCompletion();
		engine2Effect.allowCompletion();
		engine1Effect.dispose();
		engine2Effect.dispose();
		
		
		ParticleEffect explosion = new ParticleEffect();
		explosion.load(Gdx.files.internal("particles/PlayerExplosion.p"), Gdx.files.internal("particles/"));
		explosion.setPosition((int)x + xOffset + (width / 2),(int) y + yOffset + (height / 2));
		level.particleEffects.add(explosion);
		explosion.start();
		matches2.play();
	} 		
	
	public float getHealth() {
		return health;
	}
	
	public void setHealth() {
		health = 1;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	public void init(GameScreen gameScreen) {		
		this.gameScreen = gameScreen;
	}
	public void damage(double damage) {
		health -= damage;
	}
	public void resetEngines() {
		this.engine1Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 22,(int) y + 5);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 27,(int) y + 5);
		level.particleEffects.add(engine2Effect);		
	}
}
