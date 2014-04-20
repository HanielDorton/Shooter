package com.haniel.Shooter.particles;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;

public abstract class Particle {
	
	private int life;
	private int time = 0;
	private float speed;
	private boolean removed = false;	
	protected double x, y;
	protected double xa, ya;
	protected Texture texture;
	protected Random random = new Random();
	protected GameScreen gameScreen;
	protected Rectangle rectangle;
	
	//Textures here so they are loaded only once:
	protected final Texture blueParticleTexture = new Texture(Gdx.files.internal("textures/blueparticle.png"));
	protected final Texture blueParticleTexture2x2 = new Texture(Gdx.files.internal("textures/blueparticle2x2.png"));
	
	public Particle(int x, int y, int life, float speed) {
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.life = life + (random.nextInt(40) - 20);
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.speed = speed;
	}

	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		move((x + xa), (y + ya));
	}
	
	
	private void move(double x, double y) {
		this.x += xa;
		this.y += ya;
		this.y -= (speed * Gdx.graphics.getDeltaTime()); //0.2
	}
	public void remove() {
		//Remove from level
		removed = true;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public boolean isRemoved() {
		return removed;
	}
	public Texture getTexture() {
		return texture;
	}
	
	public void init(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
}
