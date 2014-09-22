package com.haniel.Shooter.util;

public class DesktopActionResolver implements ActionResolver {

	public DesktopActionResolver(){
		
	}	
	@Override	
	public boolean getSignedInGPGS() {
		//System.out.println("Desktop Google Actions: getSignedInGPGS()");
		return false;
	}

	@Override
	public void loginGPGS() {
		//System.out.println("Desktop Google Actions: loginGPGS()");		
	}

	@Override
	public void submitScoreGPGS(float score) {
		//System.out.println("Desktop Google Actions: submitScoreGPGS(int score) :" + score);		
	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {
		//System.out.println("Desktop Google Actions: unlockAchievementGPGS(String achievementId): " + achievementId);		
	}

	@Override
	public void getLeaderboardGPGS() {
		//System.out.println("Desktop Google Actions: getLeaderboardGPGS()");		
	}

	@Override
	public void getAchievementsGPGS() {
		//System.out.println("Desktop Google Actions: getAchievementsGPGS()");		
	}
}

