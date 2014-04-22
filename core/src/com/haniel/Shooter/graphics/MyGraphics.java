package com.haniel.Shooter.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;

public abstract class MyGraphics {
	protected float x, y;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected Rectangle rectangle;
	protected Level level;
	
	//load all images here so they are only loaded once:
	
	protected static final Texture starTexture = new Texture(Gdx.files.internal("textures/particles/yellowparticle.png"));
	
	
	
	public MyGraphics() {
		
	}
	
	public void update() {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public boolean isSolid() {
		return false;
	}
	public void init(Level level) {
		this.level = level;
	}

}
