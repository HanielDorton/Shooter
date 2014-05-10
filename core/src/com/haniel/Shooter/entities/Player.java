package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.BasicGun;


public class Player extends Entity{
	
	Texture player_forward = new Texture(Gdx.files.internal("entities/player.png"));
	Texture player_left = new Texture(Gdx.files.internal("entities/player_left.png"));
	Texture player_right = new Texture(Gdx.files.internal("entities/player_right.png"));
    private boolean shooting = false;;
    private int maxSpeed;
    private int keyboardSpeed;
    private GameScreen gameScreen;
	private ParticleEffect engine1Effect = new ParticleEffect();
	private ParticleEffect engine2Effect = new ParticleEffect();


	
	public Player(Level level) {
		this.level = level;
		this.x = 400;
		this.y = 20;
		this.width = 21;
		this.height = 15;
		this.xOffset = 4;
		this.yOffset = 7;
		this.texture = player_forward;
		this.rectangle = new Rectangle((float) x + xOffset, (float) y + yOffset, width, height);
		this.speed = 30;
		this.keyboardSpeed = 8;
		this.maxSpeed = 40;
		this.lastShot= 0;
		this.health = 1;
		this.weapon = new BasicGun(level, true);
		this.engine1Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 11,(int) y + 1);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 19,(int) y + 1);
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
			
	        
		}
	    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D)) {
	    	movePlayer(keyboardSpeed , 0);
	    	
	    }
	    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W)) {
	    	movePlayer(0, keyboardSpeed );
			
	    }
	    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S)) {
	    	movePlayer(0, -keyboardSpeed );
			
	    }
	    
		/*
		 * this.texture = player_left;
		 * this.texture = player_right;
		 * this.texture = player_forward;
		 * this.texture = player_forward;
		 */

		
	    if (shooting ||  Gdx.input.isKeyPressed(Keys.ENTER)) {
	    	if ((level.getTime() - lastShot) > weapon.getFiringRate()) {
	    		double angle = getAngleTo(x - 1, y, x - 1, y+10);
	    		weapon.shoot(x - 1, y - 1, angle);
	    		//angle = getAngleTo(x, y, x, y+10);
	    		weapon.shoot(x + width + xOffset, y, angle);
	    		lastShot = level.getTime();
	    		weapon.playSound();
	    	}
	    }
	
	    if (x < 0) x = 0;
	    if (x > gameScreen.getWidth() - (width + xOffset * 2)) x = gameScreen.getWidth() - (width + xOffset * 2);
	    if (y < 0) y = 0;
	    if (y > gameScreen.getHeight() - (height + yOffset * 2)) y = gameScreen.getHeight() - (height + yOffset *2);
	    rectangle.setPosition((float)x + xOffset, (float)y + yOffset);
	    
	    
	    engine1Effect.setPosition((int)x + 10,(int) y + 1);
	    engine2Effect.setPosition((int)x + 17,(int) y + 1);

	}
	
	public void movePlayer(int moveX, int moveY) {
		if (Math.abs(moveX) > maxSpeed) moveX = (maxSpeed * myAbs(moveX));
		if (Math.abs(moveY) > maxSpeed) moveY = (maxSpeed * myAbs(moveY));
		move(speed * moveX, speed * moveY);	
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
		//need to change level for weapon here too!!
	}
	public void init(GameScreen gameScreen) {		
		this.gameScreen = gameScreen;
	}
	public void damage(double damage) {
		health -= damage;
	}
	public void resetEngines() {
		this.engine1Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine1Effect.setPosition((int)x + 11,(int) y + 1);
		level.particleEffects.add(engine1Effect);
		this.engine2Effect.load(Gdx.files.internal("particles/PlayerEngine.p"), Gdx.files.internal("particles/"));
		this.engine2Effect.setPosition((int)x + 19,(int) y + 1);
		level.particleEffects.add(engine2Effect);		
	}
}
