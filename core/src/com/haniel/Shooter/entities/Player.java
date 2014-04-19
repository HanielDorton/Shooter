package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
//import com.badlogic.gdx.math.Vector3;
import com.haniel.Shooter.projectiles.BasicGun;
import com.haniel.Shooter.projectiles.Projectile;

public class Player extends Entity{
	
	private double lastShot;
	
	public Player() {
		this.x = GameScreen.screenWidth / 2 - 24 / 2;
		this.y = 20;
		this.width = 20;
		this.height = 24;
		this.texture = new Texture(Gdx.files.internal("entities/player.png"));
		this.rectangle = new Rectangle(x, y, width, height);
		this.speed = 100;
		this.time = 0;
		this.lastShot= 0;
	}
	public void update(GameScreen g) {
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
    if (x > GameScreen.screenWidth - 30) x = 800 - 30;
    if (y < 0) y = 0;
    if (y > GameScreen.screenHeight - 30) y = 480 - 30;
    //rectangle.setPosition(x, y);
    
    if(Gdx.input.isKeyPressed(Keys.ENTER)) {
    	shoot(g);
    }
		
	}

	public void shoot(GameScreen g) {
		if (time - lastShot > Projectile.basicGunFiringRate) {
			lastShot = time;
			g.add(new BasicGun(this.x, this.y, 0));
			g.add(new BasicGun(this.x + 27, this.y, 0));
		}
	}
}
