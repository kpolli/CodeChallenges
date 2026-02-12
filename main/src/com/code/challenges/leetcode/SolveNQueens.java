package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SolveNQueens {
	
	static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '.';
			}
		}
        List<List<String>> resp = new ArrayList<>();
        solveNQueens(board, 0, 0, 0, n, resp);
        return resp;
    }
	
	static boolean solveNQueens(char[][] board, int index, int jndex, int count, int n, List<List<String>>  resp){
		
		if (n == count && notReachable(board)) {
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < board.length; i++) {
				String word = new String(board[i]);
				temp.add(word);
				
			}
			resp.add(temp);
			return true;
		} else if (n == count) {
			return false;
		} else if (index >= board.length || jndex >= board[0].length) {
			return false;
		} else if (!notReachable(board)) {
			return false;
		}
		for (int i = index; i < board.length; i++) {
			for (int j = jndex; j < board[0].length; j++) {
					board[i][j] = 'Q';
					solveNQueens(board, i + 1, 0, count + 1, n, resp);
					board[i][j] = '.';
					
				}
		}
		return false;
	}
	
	static boolean notReachable(char [][] board) {
		char[][] temp1 = new char[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'Q' && (temp1[i][j] == 'Q')) {
					return false;
				} else if (board[i][j] == 'Q') {
					// fill all verticals and horizontals
					for (int k = 0; k < board.length; k++) {
						temp1[i][k] = 'Q';
						temp1[k][j] = 'Q';
					}
					// fill diagonals
					int k = i+1, l = j+1;
					while(k < board.length && l < board.length) {
						temp1[k++][l++]= 'Q';
					}
					int m = i+1, n = j-1;
					while(m < board.length && n > -1) {
						temp1[m++][n--]= 'Q';
					}
					
				}
				
			}
		}
		
		return true;
	}
	
	static int totalNQueens(char[][] board, int index, int jndex, int count, int n){
		
		if (n == count && notReachable(board)) {
			
			return 1;
		} else if (n == count) {
			return 0;
		} else if (index >= board.length || jndex >= board[0].length) {
			return 0;
		} else if (!notReachable(board)) {
			return 0;
		}
		int resp = 0;
		for (int i = index; i < board.length; i++) {
			for (int j = jndex; j < board[0].length; j++) {
					board[i][j] = 'Q';
					resp += totalNQueens(board, i + 1, 0, count + 1, n);
					board[i][j] = '.';
					
				}
		}
		return resp;
	}
	
	static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '.';
			}
		}
        int resp = totalNQueens(board, 0, 0, 0, n);
        return resp;
    }

	public static void main(String[] args) {
		List<List<String>> resp= solveNQueens(8);
		System.out.println(resp);
		System.out.println(resp.size());
		
		System.out.println(totalNQueens(9));
	}
}
