package com.haniel.Shooter.util;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.haniel.Shooter.entities.Player;

public class MyInputProcessor implements InputProcessor {
	
		private Player player;
	
		public MyInputProcessor(Player player){
			this.player = player;
		}
	
	   @Override
	   public boolean keyDown (int keycode) {
	      return false;
	   }

	   @Override
	   public boolean keyUp (int keycode) {
	      return false;
	   }

	   @Override
	   public boolean keyTyped (char character) {
	      return false;
	   }

	   @Override
	   public boolean touchDown (int x, int y, int pointer, int button) {
		   if (button == Buttons.LEFT) {
			   player.startShooting();
		   }
	      return false;
	   }

	   @Override
	   public boolean touchUp (int x, int y, int pointer, int button) {
		   if (button == Buttons.LEFT) {
			   player.stopShooting();
		   }
	      return false;
	   }

	   @Override
	   public boolean touchDragged (int x, int y, int pointer) {
		  mouseMoved(x, y);
	      return false;
	   }

	   public boolean touchMoved (int x, int y) {
	      return false;
	   }

	   @Override
	   public boolean scrolled (int amount) {
	      return false;
	   }

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
				if (screenX > 400) player.movePlayer(1 * (screenX - 400), 0);
				else if (screenX < 400) player.movePlayer(-1 * (400 - screenX), 0);
				  
				if (screenY < 240) player.movePlayer(0, 1 * (240 - screenY));
				else if (screenY > 240) player.movePlayer(0, -1 * (screenY - 240));
		
				Gdx.input.setCursorPosition(400, 240);
			return false;
			
		}
	}
	
