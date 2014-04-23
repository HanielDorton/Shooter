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
	
	public static final List <Coord> circleTop = Arrays.asList(middletop_right, middletop_farright, abovemiddle_right, abovemiddle_farleft, middletop_farleft, middletop_farleft2);
	public static final List <Coord> topRightMiddleLeaveTop = Arrays.asList(top_right, middleright,leave_by_topmiddleright);
	public static final List <Coord> topLeftMiddleLeaveTop = Arrays.asList(top_left, middleleft, leave_by_topmiddleleft);
	
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
