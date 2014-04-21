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
	
	public static final List <Coord> circleTop = Arrays.asList(middletop_right, middletop_farright, abovemiddle_right, abovemiddle_farleft, middletop_farleft, middletop_farleft2);
			
	
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
