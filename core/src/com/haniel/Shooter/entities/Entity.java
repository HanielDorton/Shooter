package com.haniel.Shooter.entities;

import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.util.Coord;
public abstract class Entity{
	
	protected int x, y, speed;
	protected int xOffset, yOffset;
	protected int position;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected GameScreen gameScreen;
	protected final Random random = new Random();
	protected Rectangle rectangle;
	protected double time;
	protected float health;
	
	//all entity textures so they are only loaded once:
	
	protected static final Texture enemy1Texture = new Texture(Gdx.files.internal("entities/enemy_1.png"));
	protected static final Sound matches2 = Gdx.audio.newSound(Gdx.files.internal("sounds/paper-rip-4.wav"));
	
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
		
		xa *= Gdx.graphics.getDeltaTime();
		ya *= Gdx.graphics.getDeltaTime();
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
		
		while (xa != 0) {
			if(Math.abs(xa) > 1) {
				this.x += myAbs(xa);
				xa -= myAbs(xa);		
			}
			else {
				this.x += xa;
				xa = 0;

			}
			
		}	
		
		while (ya != 0) {
			if(Math.abs(ya) > 1) {
				this.y += myAbs(ya) ;
				ya -= myAbs(ya);
			} else {
				this.y += ya;
				ya = 0;
			}
		}
		
	}
	
	private int myAbs(double value) {
		if (value < 0) return -1;
		else return 1;
	}
	
	public void damage(double damage) {
		health -= damage;
		particles();
	}
				
	public void particles() {
		System.out.println("No particles set up");
	}
	
	public void update() {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public int getX() {
		return x;	
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight() {
		return height;
	}	
    // tell the camera to update its matrices.
	public Texture getTexture() {
		return texture;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public void init(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public void pattern(int tempX, int tempY, List <Coord> positions) {
		int pX = positions.get(position).getX();
		int pY = positions.get(position).getY();
		
		
		if (tempX < pX) move(speed, 0);
		else if (tempX > pX) move(-speed, 0);
		if (tempY < pY) move(0, speed);
		else if (tempY > pY) move(0, -speed);	
		
		if ((Math.abs(tempX - pX) < 10) &&
			(Math.abs(tempY - pY) < 10)) {
			position++;
			if (position > positions.size() - 1) this.position = 0;

			
		}
				
		
		
	}	
}