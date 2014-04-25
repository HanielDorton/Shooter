package com.haniel.Shooter.util;

import java.util.Arrays;
import java.util.List;

public class Coord {
	private int x,y;

	
	public static final Coord middletop_right = new Coord(700, 400);
	public static final Coord middletop_farright = new Coord(750,350);
	public static final Coord abovemiddle_right = new Coord(700,300);
	public static final Coord abovemiddle_farleft = new Coord(50,300);
	public static final Coord middletop_farleft = new Coord(0,350);
	public static final Coord middletop_farleft2 = new Coord(50,400);
	public static final Coord top_right = new Coord(800, 480);
	public static final Coord top_left = new Coord(-60, 480);
	public static final Coord leave_by_topmiddleright = new Coord(400, 1000);
	public static final Coord leave_by_topmiddleleft = new Coord(340, 1000);
	public static final Coord middleright = new Coord(400, 225);
	public static final Coord middleleft = new Coord(340, 225);
	public static final Coord leavingscreentopright = new Coord(1500, 360);
	public static final Coord leavingscreentopleft = new Coord(-1500, 420);
	
	public static final List <Coord> circleTop = Arrays.asList(middletop_right, middletop_farright, abovemiddle_right, abovemiddle_farleft, middletop_farleft, middletop_farleft2);
	public static final List <Coord> topRightMiddleLeaveTop = Arrays.asList(top_right, middleright,leave_by_topmiddleright);
	public static final List <Coord> topLeftMiddleLeaveTop = Arrays.asList(top_left, middleleft, leave_by_topmiddleleft);
	public static final List <Coord> straightrightaroundtop = Arrays.asList(leavingscreentopright);
	public static final List <Coord> straightleftaroundtop = Arrays.asList(leavingscreentopleft);
	
	public static final Coord rightcircleleft = new Coord(400, 375);
	public static final Coord rightcircletop = new Coord(550, 415);
	public static final Coord rightcircleright = new Coord(650, 375);
	public static final Coord rightcirclebot = new Coord(550, 340);	
	public static final List <Coord> circlenearrighttopslowlyforawhilethenleave = Arrays.asList(rightcircleleft, rightcircletop, rightcircleright, rightcirclebot, rightcircleleft, rightcircletop, leavingscreentopright);
	
	public static final Coord leftcircleright = new Coord(250, 375);
	public static final Coord leftcircletop = new Coord(100, 415);
	public static final Coord leftcircleleft = new Coord(0, 375);
	public static final Coord leftcirclebot = new Coord(100, 340);	
	public static final List <Coord> circlenearlefttopslowlyforawhilethenleave = Arrays.asList(leftcircleright, leftcircletop, leftcircleleft, leftcirclebot, leftcircleright, leftcircletop, leavingscreentopleft);
	
	
	public static final Coord bossmiddletop = new Coord(125, 240);
	public static final Coord bossrighttop = new Coord(200, 280);
	public static final Coord bosslefttop = new Coord(25, 280);
	
	
	
	public static final List <Coord> bosscircles = Arrays.asList(bossmiddletop, bossrighttop,bosslefttop, bossmiddletop);
	
	
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
