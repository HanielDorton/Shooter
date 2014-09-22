package com.haniel.Shooter.entities;

import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.haniel.Shooter.Assets;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.PlayerGun;

public class Player extends Entity{
	
	private List<Sprite> playerSprites = new LinkedList<Sprite>();
	
    private boolean shooting = false;;
    private int maxSpeed;
    private GameScreen gameScreen;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();
	private float tilt, tiltSpeed;
	private int currentSprite;
	private boolean movingLeft, movingRight;
	private float leftKeyboardSpeed = 0;
	private float rightKeyboardSpeed = 0;
	private float upKeyboardSpeed = 0;
	private float downKeyboardSpeed = 0;
	private float topKeyboardSpeed = 18;
	private float baseKeyboardSpeed = 5;
	private float keyboardAcc = .2f;
	private boolean touchLeft, touchRight, touchUp, touchDown;
	private Vector3 touchPos = new Vector3();
	private int shipMiddle;
	


	
	public Player(Level level) {
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship-5.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship-4.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship-3.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship-2.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship-1.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship0.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship1.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship2.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship3.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship4.png", Texture.class)));
		playerSprites.add(new Sprite(Assets.manager.get("entities/player/ship5.png", Texture.class)));
		
		this.level = level;
		this.x = 400;
		this.y = 20;
		this.width = 30;
		this.height = 25;
		this.xOffset = 10;
		this.yOffset = 10;
		this.currentSprite = 5;
		this.sprite = playerSprites.get(currentSprite);
		this.rectangle = new Rectangle((float) x + xOffset, (float) y + yOffset, width, height);
		this.speed = 30;
		this.maxSpeed = 40;
		this.lastShot= 0;
		this.health = 1;
		this.tilt = 0;
		this.tiltSpeed = 0.02f;
		this.movingLeft = false;
		this.movingRight = false;
		this.weapon = new PlayerGun(level);
		this.engine1Effect.load(Gdx.files.internal("PlayerEngine.p"), Gdx.files.internal(""));
		this.engine1Effect.setPosition((int)x + 21,(int) y + 5);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("PlayerEngine.p"), Gdx.files.internal(""));
		this.engine2Effect.setPosition((int)x + 26,(int) y + 5);
		level.particleEffects.add(engine2Effect);
		
		switch (Gdx.app.getType()) {
		
			case Android: {
				topKeyboardSpeed = 30;
				baseKeyboardSpeed = 5;
				keyboardAcc = .4f;
			}
			default: {
				
			}
		}
	}
	public void update() {
		touchLeft = false;
		touchRight = false;
		touchUp = false;
		touchDown = false;
		switch (Gdx.app.getType()) {
		
			case Android: {
				
				if (Gdx.input.isTouched()) {
					startShooting();
				    touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
				    gameScreen.camera.unproject(touchPos);
				    shipMiddle = (int) this.x + ((height +xOffset*2)/2);
					if ((touchPos.x - shipMiddle) > 5)
					    touchRight = true;
					else if ((touchPos.x - shipMiddle) < -5)
					    touchLeft = true;
					if ((touchPos.y - (this.y + ((width + yOffset*2)/2))) > 5)
					    touchUp = true;
					else if ((touchPos.y - (this.y + ((width + yOffset*2)/2))) < -5)
					    touchDown = true;
				}
				else {
					stopShooting();
				}
				break;
			}
			default: {
			}
		}
				if (touchLeft || Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A)) {
					if (leftKeyboardSpeed > -topKeyboardSpeed) leftKeyboardSpeed -= keyboardAcc;
					movePlayer((int) leftKeyboardSpeed , 0);
					movingLeft = true;	        
				}
				else {
					leftKeyboardSpeed = -baseKeyboardSpeed;
				}
			    if (touchRight || Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
					if (rightKeyboardSpeed < topKeyboardSpeed) rightKeyboardSpeed += keyboardAcc;
			    	movePlayer((int) rightKeyboardSpeed , 0);
			    	movingRight = true;	    	
			    }
			    else {
			    	rightKeyboardSpeed = baseKeyboardSpeed;
				}
			    if (touchUp || Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
					if (upKeyboardSpeed < topKeyboardSpeed) upKeyboardSpeed += keyboardAcc;
			    	movePlayer(0, (int) upKeyboardSpeed );			
			    }
			    else {
			    	upKeyboardSpeed = baseKeyboardSpeed;
				}
			    if (touchDown || Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S)) {
					if (downKeyboardSpeed > -topKeyboardSpeed) downKeyboardSpeed -= keyboardAcc;
			    	movePlayer(0, (int) downKeyboardSpeed );			
			    }
			    else {
			    	downKeyboardSpeed = -baseKeyboardSpeed;
				
			
		}
		
	    if (shooting ||  Gdx.input.isKeyPressed(Keys.ENTER)) {
	    	if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y+30);
	    		weapon.shoot(x + 12, y + 25, angle);
	    		weapon.shoot(x + 36, y + 25, angle);
	    		weapon.shoot(x, y + 25, angle);
	    		weapon.shoot(x + width + xOffset * 2, y + 25, angle);
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
	    engine1Effect.setPosition((int)x + 21,(int) y + 5);
	    engine2Effect.setPosition((int)x + 26,(int) y + 5);
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
		explosion.load(Gdx.files.internal("PlayerExplosion.p"), Gdx.files.internal(""));
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
		this.engine1Effect.load(Gdx.files.internal("PlayerEngine.p"), Gdx.files.internal(""));
		this.engine1Effect.setPosition((int)x + 21,(int) y + 5);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("PlayerEngine.p"), Gdx.files.internal(""));
		this.engine2Effect.setPosition((int)x + 26,(int) y + 5);
		level.particleEffects.add(engine2Effect);		
	}
}
