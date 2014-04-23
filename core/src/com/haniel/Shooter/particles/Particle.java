package com.haniel.Shooter.particles;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.level.Level;

public abstract class Particle {
	
	private int life;
	private int time = 0;
	private boolean removed = false;	
	protected double x, y;
	protected double xa, ya;
	protected Texture texture;
	protected Random random = new Random();
	protected Level level;
	protected Rectangle rectangle;
	
	//Textures here so they are loaded only once:
	protected static final Texture blueParticleTexture = new Texture(Gdx.files.internal("textures/particles/blueparticle.png"));
	protected static final Texture brownParticleTexture = new Texture(Gdx.files.internal("textures/particles/brownparticle.png"));
	protected static final Texture purpleParticleTexture = new Texture(Gdx.files.internal("textures/particles/purpleparticle.png"));
	protected static final Texture orangeParticleTexture = new Texture(Gdx.files.internal("textures/particles/orangeparticle.png"));
	protected static final Texture whiteParticleTexture = new Texture(Gdx.files.internal("textures/particles/whiteparticle.png"));
	
	public Particle(double x, double y, int life) {
		this.rectangle = new Rectangle();
		this.x = x;
		this.y = y;
		this.life = life + (random.nextInt(life*2));
		this.xa = random.nextGaussian() * 40;
		this.ya = random.nextGaussian() * 40;

	}
	public Particle(double x, double y, int life, double xa, double ya){
		this(x, y, life);
		if (xa != 0) this.xa = xa;
		if (ya != 0) this.ya = ya;
		
	}

	public void update() {
		time++;
		if (time > 7400) time = 0;
		if (time > life) remove();
		move((x + xa), (y + ya));
		xa *= .97;
		ya *=.97;
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
	
	public void init(Level level) {
		this.level = level;
	}
	
}
