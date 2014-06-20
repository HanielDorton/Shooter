package com.haniel.Shooter.util;

public class GameState {
	public int numContinues, numKills, checkPoint, numLevel, tempScore, score;
	public int [] scores = {0, 0, 0, 0, 0};
	public int [] levelMaxes ={900,900,800,900,900};
	
	public GameState(int numLevel, int checkPoint, int numKills, int numContinues) {
		this.numContinues = numContinues;
		this.numKills = numKills;
		this.checkPoint = checkPoint;
		this.numLevel = numLevel;
	}

}
