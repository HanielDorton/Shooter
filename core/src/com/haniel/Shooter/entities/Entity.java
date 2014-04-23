package com.haniel.Shooter.entities;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;
import com.haniel.Shooter.weapons.Weapon;
public abstract class Entity{
	
	protected double x, y, speed, destX, destY;
	protected double angle;
	protected int xOffset, yOffset;
	protected int position;
	protected int width, height;
	protected Texture texture;
	protected boolean removed = false;
	protected Level level;
	protected final Random random = new Random();
	protected Rectangle rectangle;
	protected float health;
	protected Weapon weapon;
	protected double lastShot;
	
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
		ya *= Gdx.graphics.getDeltaTime();//  * speed);
		xa *= Gdx.graphics.getDeltaTime();//  * speed);
		

		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
		
		
		this.x += xa;
		this.y += ya;
		/*while (xa != 0) {
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
		}*/
		
	}
	
	protected int myAbs(double value) {
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
        if (y < 0 - this.height - 500) remove();
        if (y > level.getHeight() + this.height + 500) remove();
        if (x > level.getWidth() + this.width + 500) remove();
        if (x < 0 - this.width - 500) remove();
        if (health < 0) remove();
		
	}

	
	public void remove() {
		removed = true;
	}
	
	public double getX() {
		return x;	
	}
	
	public double getY() {
		return y;
	}
	
	public double getMidX() {
		return x + xOffset + (width / 2);
		
	}
	public double getMidY() {
		return y + yOffset + (width / 2);
		
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
	
	public void init(Level level) {
		this.level = level;
	}
	public double getAngleTo(double x, double y, double destX, double destY) {
		return (Math.atan2(destY - y, destX - x));	


				
		
		
	}	
}