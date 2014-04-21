package com.haniel.Shooter.particles;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.GameScreen;

public abstract class Particle {
	
	private int life;
	private int time = 0;
	private boolean removed = false;	
	protected double x, y;
	protected double xa, ya;
	protected Texture texture;
	protected Random random = new Random();
	protected GameScreen gameScreen;
	protected Rectangle rectangle;
	
	//Textures here so they are loaded only once:
	protected static final Texture blueParticleTexture = new Texture(Gdx.files.internal("textures/particles/blueparticle.png"));
	protected static final Texture brownParticleTexture = new Texture(Gdx.files.internal("textures/particles/brownparticle.png"));
	
	public Particle(int x, int y, int life) {
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.life = life + (random.nextInt(30));
		this.xa = random.nextGaussian() * 40;
		this.ya = random.nextGaussian() * 40;

	}

	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		move((x + xa), (y + ya));
	}
	
	
	private void move(double x, double y) {
		float g = Gdx.graphics.getDeltaTime();
		this.x += xa * g;
		this.y += ya * g;

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
