package com.haniel.Shooter.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool.PooledEffect;
import com.badlogic.gdx.math.Rectangle;

public class ShipPiece extends MyGraphics{

	private double xSpeed, ySpeed;
	private float life = random.nextFloat();
	private float start;
	protected float rotation = 0;
	private float rotationSpeed;
	
	public ShipPiece(Texture texture, double  x, double y, double xSpeed, double ySpeed) {
		super((int)x, (int) y, (float) xSpeed);
		this.sprite = new Sprite(texture);
		this.rectangle = new Rectangle();
		this.xSpeed = (xSpeed / 3) - random.nextInt(2);
		this.ySpeed = (ySpeed / 3) - random.nextInt(2);
		this.start = 0;
		this.rotates = true;
		this.width = sprite.getRegionWidth();
		this.height = sprite.getRegionHeight();
		this.rotationSpeed = random.nextFloat() - .5f;
		if (random.nextInt(2) > 0) this.xSpeed *=-1;
		if (random.nextInt(2) > 0) this.ySpeed *=-1;
	}
	public void update() {
		if (rotation == 0) rotation = 360f;
		if (rotation > 360f) rotation = 0;
		rotation += rotationSpeed;
		sprite.setRotation(rotation);
		move(xSpeed, ySpeed);
		start += Gdx.graphics.getDeltaTime() *1;
		if (start > life) {
			remove();		
		}
	}

}
