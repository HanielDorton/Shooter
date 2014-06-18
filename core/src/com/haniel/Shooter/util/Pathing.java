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
	
	//Level Two First Enemies
	
	public static CatmullRomSpline<Vector2> leaveBottom = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(0, 525), new Vector2(375, 200), new Vector2(0, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottom2 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 525), new Vector2(375, 200), new Vector2(800, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottomLeft = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(400, 525), new Vector2(0, 200), new Vector2(400, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottomRight = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(400, 525), new Vector2(750, 200), new Vector2(600, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottom3 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(100, 525), new Vector2(400, 200), new Vector2(100, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottom4 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(700, 525), new Vector2(300, 200), new Vector2(700, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottomLeft2 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(300, 525), new Vector2(0, 200), new Vector2(300, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottomRight2 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(600, 525), new Vector2(750, 200), new Vector2(600, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottom5 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(200, 525), new Vector2(400, 200), new Vector2(200, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottom6 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(600, 525), new Vector2(400, 200), new Vector2(600, -500)}, true);
	
	public static CatmullRomSpline<Vector2> leaveBottomLeft3 = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(200, 525), new Vector2(0, 200), new Vector2(200, -500)}, true);
	
	//Level Two Cargo Craft
	
	public static CatmullRomSpline<Vector2> goRight = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(-100, 500), new Vector2(400, 300), new Vector2(1400, 500)}, true);
	
	public static CatmullRomSpline<Vector2> goLeft = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(800, 300), new Vector2(400, 440), new Vector2(-600, 300)}, true);
	
	//Level Two Boss
	
	public static CatmullRomSpline<Vector2> bottomToTopMiddle = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(240, -700), new Vector2(250, 400), new Vector2(240, 2000)}, true);
	
	public static CatmullRomSpline<Vector2> hoverAtTop = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(240, 400), new Vector2(260, 390), new Vector2(260, 400),
			new Vector2(240, 390), new Vector2(220, 400), new Vector2(220, 390)}, true);
	
	public static CatmullRomSpline<Vector2> goUpLeft = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(0, -80), new Vector2(100, 240), new Vector2(0, 1000)}, true);
	
	public static CatmullRomSpline<Vector2> goUpRight = new CatmullRomSpline<Vector2>(new Vector2[] 
			{new Vector2(770, -80), new Vector2(670, 240), new Vector2(770, 1000)}, true);

}
