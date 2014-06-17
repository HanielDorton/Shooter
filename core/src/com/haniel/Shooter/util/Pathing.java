package com.haniel.Shooter.util;

import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;

public class Pathing {
	
	//Level One, First Small Enemies
	public static CatmullRomSpline<Vector2> topRightMiddleLeaveTop = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 480), new Vector2(460, 250), new Vector2(400, 1000)}, true);
	
	public static CatmullRomSpline<Vector2> topLeftMiddleLeaveTop = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-60, 480), new Vector2(280, 250), new Vector2(340, 1000)}, true);
	
	public static CatmullRomSpline<Vector2> topArcLeft = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 480), new Vector2(240, 200), new Vector2(-700, 880)}, true);
	
	public static CatmullRomSpline<Vector2> TopArcRight = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(120, 480), new Vector2(420, 300), new Vector2(1000, 880)}, true);
	
	//Level One slow UFO enemies	
	public static CatmullRomSpline<Vector2> circlesTopRightThenLeaves = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 175), new Vector2(420, 375), new Vector2(550, 415),
			new Vector2(650, 375), new Vector2(550, 340),new Vector2(420, 375), new Vector2(550, 415),
			new Vector2(1500, 340)}, true);
	
	public static CatmullRomSpline<Vector2> circlesTopLeftThenLeaves = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-150, 175), new Vector2(230, 375), new Vector2(100, 415),
			new Vector2(0, 375), new Vector2(100, 340),new Vector2(230, 375), new Vector2(100, 415),
			new Vector2(-850, 340)}, true);
	
	//Level One Quick Enemies
	public static CatmullRomSpline<Vector2> goingLeftUpAndDown = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(860, 175), new Vector2(600, 300), new Vector2(400, 175),
			new Vector2(200, 300), new Vector2(0, 300), new Vector2(-500, 175)}, true);
	
	public static CatmullRomSpline<Vector2> goingRightUpAndDown = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-60, 300), new Vector2(200, 175), new Vector2(400, 300),
			new Vector2(600, 175), new Vector2(800, 300), new Vector2(1500, 300)}, true);
	
	public static CatmullRomSpline<Vector2> goingLeftUpAndDownHigher = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(860, 275), new Vector2(600, 400), new Vector2(400, 275),
			new Vector2(200, 400), new Vector2(0, 400), new Vector2(-500, 275)}, true);
	
	public static CatmullRomSpline<Vector2> goingRightUpAndDownHigher = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-60, 400), new Vector2(200, 275), new Vector2(400, 400),
			new Vector2(600, 275), new Vector2(800, 400), new Vector2(1500, 400)}, true);
	//Level One Boss
	public static CatmullRomSpline<Vector2> bossCircles = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(350, 220), new Vector2(600, 270), new Vector2(600, 220),
			new Vector2(350, 270), new Vector2(50, 220), new Vector2(50, 270)}, true);
	
	

}
