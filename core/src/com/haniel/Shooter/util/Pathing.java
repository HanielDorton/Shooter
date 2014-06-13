package com.haniel.Shooter.util;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;

public class Pathing {
	
	public static CatmullRomSpline<Vector2> topRightMiddleLeaveTop = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 480), new Vector2(460, 250), new Vector2(400, 1000)}, true);
	
	public static CatmullRomSpline<Vector2> topLeftMiddleLeaveTop = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-60, 480), new Vector2(280, 250), new Vector2(340, 1000)}, true);
	

}
