package com.haniel.Shooter.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;

public abstract class Entity{
	
	protected float x, y, speed;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	//protected Level level;
	protected final Random rand = new Random();
	protected Rectangle rectangle;
	protected double time;
	
	//all entity textures so they are only loaded once:
	
	protected final Texture enemy1Texture = new Texture(Gdx.files.internal("entities/enemy_1.png"));
	
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	protected Direction dir;
	
	public Entity() {
		
	}
		
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
		
		while (xa != 0) {
			if(Math.abs(xa) > 1) {
				this.x += abs(xa);
				xa -= abs(xa);
			}
			else {
				this.x += xa;
				xa = 0;
			}
		}
		
		while (ya != 0) {
			if(Math.abs(ya) > 1) {
				this.y += abs(ya);
				ya -= abs(ya);
			} else {
				this.y += ya;
				ya = 0;
			}
		}
		
	}
	
	private int abs(double value) {
		if (value < 0) return -1;
		else return 1;
	}
	
	public void update(GameScreen gameScreen) {
		
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
	
	/*
	public void init(Level level) {
		this.level = level;
	}*/

}
