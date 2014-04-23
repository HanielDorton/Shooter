package com.haniel.Shooter.entities;

import java.util.List;

import com.haniel.Shooter.util.Coord;

public class AttackPattern {
	
	public enum patterns {
		alpha, beta, omega
	}
	
	
	
	
	
	/*
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

			
	}*/

}
