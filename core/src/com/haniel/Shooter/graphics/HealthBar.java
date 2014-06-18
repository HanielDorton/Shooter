package com.haniel.Shooter.graphics;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.haniel.Shooter.entities.Entity;

	
public class HealthBar extends MyGraphics {
	
	private float maxHealth;
	private float health = 0;
	private Entity boss;
	
	public HealthBar(Entity boss, int y) {
		super(y);
		this.maxHealth = boss.getHealth();
		this.x = 152;
		this.y = 455;
		this.texture = healthBarTexture;
		this.sprite = new Sprite(texture);
		this.boss = boss;
		this.width = 596;
		this.height = 20;
	}
	
	public void update() {
		if (health < boss.getHealth()) health++;
		if (health > boss.getHealth()) health--;
		this.width = (int) ((health/maxHealth) * 596);
		if (this.width < 0) this.width = 0;
		sprite.setScale(width, 20);
	}

}
