package com.leetcode.medium;

import org.junit.Test;

public class BattleshipsinaBoard {
	  public int countBattleships(char[][] board) {
		int count=0;
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]!='X') {
					continue;
				}
				if((j-1<0||board[i][j-1]=='.')&&(i-1<0||board[i-1][j]=='.')) {
					count++;
				}
			}
		}
		return count; 
	}
	  @Test 
	  public  void test() {
		  char[][] board= {{'X','.', '.', 'X'}, {'.','.','.','X'},{'.','.','.','X'}};
		  System.out.println(countBattleships(board));
	  }
}
