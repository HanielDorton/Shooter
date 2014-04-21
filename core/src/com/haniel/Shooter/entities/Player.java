package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
//import com.badlogic.gdx.math.Vector3;
import com.haniel.Shooter.projectiles.BasicGun;
import com.haniel.Shooter.projectiles.Projectile;

public class Player extends Entity{
	
	private double lastShot;
	Sound gunSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gunshot01.wav"));
	
	public Player() {
		this.x = 800 / 2 - 24 / 2;
		this.y = 20;
		this.width = 15;
		this.height = 15;
		this.xOffset = 6;
		this.yOffset = 6;
		this.texture = new Texture(Gdx.files.internal("entities/player.png"));
		this.rectangle = new Rectangle(x + xOffset, y + yOffset, width, height);
		this.speed = 175;
		this.time = 0;
		this.lastShot= 0;
		this.health = 1;
	}
	public void update() {
	time += Gdx.graphics.getDeltaTime();
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
		
		// Keyboard Movement not used:
	if (Gdx.input.isKeyPressed(Keys.LEFT) || Gdx.input.isKeyPressed(Keys.A))
        x -= speed * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
        x += speed * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W))
        y += speed * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S))
        y -= speed * Gdx.graphics.getDeltaTime();

    if (x < 0) x = 0;
    if (x > gameScreen.getWidth() - 30) x = 800 - 30;
    if (y < 0) y = 0;
    if (y > gameScreen.getHeight() - 30) y = 480 - 30;
    rectangle.setPosition(x + xOffset, y + yOffset);
    
    if(Gdx.input.isKeyPressed(Keys.ENTER)) {
    	shoot();
    }
		
	}

	public void shoot() {
		if (time - lastShot > Projectile.basicGunFiringRate) {
			gunSound.play();
			lastShot = time;
			this.gameScreen.add(new BasicGun(this.x, this.y, 0));
			this.gameScreen.add(new BasicGun(this.x + 27, this.y, 0));
		}
	}
	public int getHealth() {
		return health;
	}
}
