package com.haniel.Shooter.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;
import com.haniel.Shooter.particles.BlueParticle;

public abstract class Entity{
	
	protected float x, y, speed;
	protected int position;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected GameScreen gameScreen;
	protected final Random rand = new Random();
	protected Rectangle rectangle;
	protected double time;
	protected int health;
	
	//all entity textures so they are only loaded once:
	
	protected final Texture enemy1Texture = new Texture(Gdx.files.internal("entities/enemy_1.png"));
	Sound matches2 = Gdx.audio.newSound(Gdx.files.internal("sounds/paper-rip-4.wav"));
	
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}

	protected Direction dir;
	
	public Entity() {
		
	}
		
	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa * Gdx.graphics.getDeltaTime(), 0);
			move(0, ya * Gdx.graphics.getDeltaTime());
			return;
		}
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
				//circle around top
				
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
		if (health < 0) {
			remove();
			for (int i = 0; i <20; i++)
				gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 15, speed));
			gameScreen.enemiesDestroyed++;
			matches2.play();
		}
		for (int i = 0; i <2; i++)
			gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 30, speed));
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
	
	public void init(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	//Attack Patterns here (I guess):
	
	public void backAndForthAtTop(int tempX, int tempY) {
		List <Integer> xPositions = Arrays.asList(700, 750, 700, 50, 0, 60);
		List <Integer> yPositions = Arrays.asList(400, 350, 300, 300, 350, 400);		
		pattern(tempX, tempY, xPositions, yPositions);
	}
	
	public void pattern(int tempX, int tempY, List <Integer> xPositions, List <Integer> yPositions) {
		if (tempX < xPositions.get(position)) move(speed, 0);
		else if (tempX > xPositions.get(position)) move(-speed, 0);
		if (tempY < yPositions.get(position)) move(0, speed);
		else if (tempY > yPositions.get(position)) move(0, -speed);	
		
		if ((Math.abs(tempY - yPositions.get(position)) < 10) &&
			(Math.abs(tempX - xPositions.get(position)) < 10)) {
			position++;
			if (position > xPositions.size() - 1) this.position = 0;

			
		}
				
		
		
	}	
}

		
		
		
		
		
		
		
		
		//circle around top
		/*
		switch (position){
			
			case 0: {
				if (y > 300) move(0, -speed*1.25);
				if (tempX < 700) move(speed, 0);
				else position = 1;
				break;
			}
						
			case 1: {
				if (tempY < 400) move(0, speed*1.25);
				if  (tempX > 100) move(-speed, 0);
				else position = 0;
				break;
			}
	
		}*/
