package com.haniel.Shooter.entities;

import com.badlogic.gdx.Gdx; 
import com.badlogic.gdx.math.Rectangle;
import com.haniel.Shooter.particles.BlueParticle;

public class Enemy1 extends Entity{

	//int xa = 0;
	//int ya = 0;
	
	public Enemy1(int x, int y) {
		this.x = x;
		this.y = y;
		this.speed = 100;
		this.width = 64;
		this.height = 64;
		this.texture = enemy1Texture;
		this.rectangle = new Rectangle(x + 4, y + 20, width * 0.8f, height / 2);
		this.health =3;
	}
	public void update() {
		//time++;
		//if (time % 100== 0) {
		//}
        y -= speed * Gdx.graphics.getDeltaTime();
        
        if (y < 0 - this.height) remove(); 
        rectangle.setPosition(x + 4, y + 20);
	}
	
	public void damage(double damage) {
		health -= damage;
		if (health < 0) {
			remove();
			for (int i = 0; i <20; i++)
				gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 20, speed));
			gameScreen.enemiesDestroyed++;
			matches2.play();
		}
		for (int i = 0; i <5; i++)
			gameScreen.add(new BlueParticle((int) x + width / 2,(int) y + height / 2, 40, speed));
		
	}
	public void remove() {
		removed = true;

	}

}
