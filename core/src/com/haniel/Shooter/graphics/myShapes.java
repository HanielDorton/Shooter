package com.haniel.Shooter.graphics;

import java.util.Random;

public class myShapes {
	protected int colorR, colorG, colorB, colorA;
	protected int x, y;
	protected boolean removed = false;	
	protected int width, height;
	protected final Random rand = new Random();
	
	
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
	
	public boolean isRemoved() {
		return removed;
	}
}
