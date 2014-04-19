package com.haniel.Shooter.graphics;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Graphic {
	protected float x, y;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected Rectangle rectangle;
	
	
	
	public Graphic() {
		
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

}
