package com.haniel.Shooter.util;

public class GameState {
	public int numContinues, numKills, checkPoint, numLevel;
	
	public GameState(int numLevel, int checkPoint, int numKills, int numContinues) {
		this.numContinues = numContinues;
		this.numKills = numKills;
		this.checkPoint = checkPoint;
		this.numLevel = numLevel;
	}

}
