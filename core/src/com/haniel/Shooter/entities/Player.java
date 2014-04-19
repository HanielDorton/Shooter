package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Player extends Entity{
	
	Vector3 touchPos= new Vector3(x, y, 0);
	
	public Player() {
		this.x = 800 / 2 - 24 / 2;
		this.y = 20;
		this.width = 20;
		this.height = 24;
		this.texture = new Texture(Gdx.files.internal("entities/player.png"));
		this.rectangle = new Rectangle();
	}
	public void update() {

	/*	
	if (Gdx.input.isTouched()) {
	        //touchPos = new Vector3();
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
        x -= 200 * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.RIGHT) || Gdx.input.isKeyPressed(Keys.D))
        x += 200 * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.UP) || Gdx.input.isKeyPressed(Keys.W))
        y += 200 * Gdx.graphics.getDeltaTime();
    if (Gdx.input.isKeyPressed(Keys.DOWN) || Gdx.input.isKeyPressed(Keys.S))
        y -= 200 * Gdx.graphics.getDeltaTime();

    //- 64 / 2;
    if (x < 0) x = 0;
    if (x > 800 - 30) x = 800 - 30;
    if (y < 0) y = 0;
    if (y > 480 - 30) y = 480 - 30;
		
	}

}
