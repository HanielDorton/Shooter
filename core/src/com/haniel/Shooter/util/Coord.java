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
	public static final Coord leavetopmiddle = new Coord(350, 1000);
	
	public static final List <Coord> circleTop = Arrays.asList(middletop_right, middletop_farright, abovemiddle_right, abovemiddle_farleft, middletop_farleft, middletop_farleft2);
	public static final List <Coord> straightrightaroundtop = Arrays.asList(leavingscreentopright);
	public static final List <Coord> straightleftaroundtop = Arrays.asList(leavingscreentopleft);
	public static final List <Coord> leavescreentopmiddle = Arrays.asList(leavetopmiddle);
	
	public static final Coord bossmiddletop = new Coord(125, 240);
	public static final Coord bossrighttop = new Coord(200, 280);
	public static final Coord bosslefttop = new Coord(25, 280);	
	public static final List <Coord> bosscircles = Arrays.asList(bossmiddletop, bossrighttop,bosslefttop, bossmiddletop);
	
	
	// Level two:
	public static final Coord bottommid = new Coord(375, -100);
	public static final Coord leavebottommid = new Coord(375, -1000);
	public static final List<Coord> leavebottom = Arrays.asList(bottommid,leavebottommid);
	
	public static final Coord bottomleft = new Coord(0, -20);
	public static final Coord leavebottomleft = new Coord(0, -1000);
	public static final List<Coord> leavebottomleftlist = Arrays.asList(bottomleft, leavebottomleft);
	
	public static final Coord bottomright = new Coord(800, -20);
	public static final Coord leavebottomright = new Coord(800, -1000);
	public static final List<Coord> leavebottomrightlist = Arrays.asList(bottomright, leavebottomright);
	
	public static final Coord bossleavetopmiddle = new Coord(325, 4000);
	public static final List<Coord> leavetopmiddlelist = Arrays.asList(bossleavetopmiddle);
	
	public static final Coord bossstayinmiddle = new Coord(325, 420);
	public static final List<Coord> bossstayinmiddlelist = Arrays.asList(bossstayinmiddle);
	
	//level three
	public static final Coord bossfarright = new Coord(375, 280);
	public static final List<Coord> superJet = Arrays.asList(bosslefttop, bossmiddletop, bossfarright);
	
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
