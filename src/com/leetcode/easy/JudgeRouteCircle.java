package com.leetcode.easy;
/*
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, 
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character. 
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down). 
 * The output should be true or false representing whether the robot makes a circle.
 */
public class JudgeRouteCircle {
	 public boolean judgeCircle(String moves) {
	      int x=0,y=0;
	      char[] mv=moves.toCharArray();
	      for(int i=0;i<mv.length;i++) {
	    	  switch(mv[i]) {
	    	  case 'U':y++;break;
	    	  case 'D':y--;break;
	    	  case 'R':x++;break;
	    	  case 'L':x--;break;
	    	  }
	      }
	      return (x==0)&&(y==0);
	 }
} 
