package com.haniel.Shooter.android;

import android.content.Intent;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.GameHelper;
import com.google.example.games.basegameutils.GameHelper.GameHelperListener;
import com.haniel.Shooter.MyGdxGame;
import com.haniel.Shooter.util.ActionResolver;

public class AndroidLauncher extends AndroidApplication implements ActionResolver{
	
	private GameHelper _gameHelper;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		_gameHelper = new GameHelper(this, GameHelper.CLIENT_GAMES);
		_gameHelper.enableDebugLog(false);

		GameHelperListener gameHelperListener = new GameHelper.GameHelperListener() {
			
			@Override
			public void onSignInSucceeded() {
				
			}
			
			@Override
			public void onSignInFailed() {
				System.out.println(_gameHelper.getSignInError());
				
			}
		};
		
		_gameHelper.setup(gameHelperListener);
		
		
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new MyGdxGame(this), config);
	}

	@Override
	protected void onStart()
	{
	super.onStart();
	_gameHelper.onStart(this);
	}

	@Override
	protected void onStop()
	{
	super.onStop();
	_gameHelper.onStop();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
	super.onActivityResult(requestCode, resultCode, data);
	_gameHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean getSignedInGPGS() {
		return _gameHelper.isSignedIn();
	}

	@Override
	public void loginGPGS() {
		try {
			runOnUiThread(new Runnable(){
				public void run() {
					_gameHelper.beginUserInitiatedSignIn();
				}
			});
		} catch (final Exception ex) {
		}		
	}

	@Override
	public void submitScoreGPGS(float score) {
		Games.Leaderboards.submitScore(_gameHelper.getApiClient(), "CgkIsKvMj-4TEAIQAA", (long) score);		
	}

	@Override
	public void unlockAchievementGPGS(String achievementId) {
		Games.Achievements.unlock(_gameHelper.getApiClient(), achievementId);		
	}

	@Override
	public void getLeaderboardGPGS() {
		if (_gameHelper.isSignedIn()) {
			startActivityForResult(Games.Leaderboards.getLeaderboardIntent(_gameHelper.getApiClient(), "CgkIsKvMj-4TEAIQAA"), 100);
			}
			else if (!_gameHelper.isConnecting()) {
			loginGPGS();
			}		
	}

	@Override
	public void getAchievementsGPGS() {
		 if (_gameHelper.isSignedIn()) {
			 startActivityForResult(Games.Achievements.getAchievementsIntent(_gameHelper.getApiClient()), 101);
			 }
			 else if (!_gameHelper.isConnecting()) {
			 loginGPGS();
			 }
		
	}
}
