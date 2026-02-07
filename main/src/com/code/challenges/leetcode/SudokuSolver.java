package com.code.challenges.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuSolver {
	
	public static void solveSudoku(char[][] board) {
		solveSudoku(board, 0, 0);
    }
	
	public static boolean solveSudoku(char[][] board, int row, int col) {
        if (row == 8 && col == 9) {
        	return true;
        } else if (col == 9) {
        	col = 0;
        	row++;	
        }
        if (Character.isDigit(board[row][col])) {
        	return solveSudoku(board, row, col + 1);
        }
        List<Integer> nums = possibleNumbers(board, row, col);
        for (int it : nums){
        	board[row][col] = Character.forDigit(it, 10);
        	if (solveSudoku(board, row, col+1)) {
        		return true;
        		
        	} else {
        		board[row][col] = '.';
        	}
        }
        return false;
    }
	
	static List<Integer> possibleNumbers(char[][] item, int index, int jndex){
		List<Integer> response = new ArrayList<>(); 
		boolean [] taken = new boolean [9];
		for (int i = 0; i < item.length; i++) {
			int col = 0;
			char row = item[index][i];
			if (Character.isDigit(row)) {
				col = row - '0';
				taken[col-1] = true;
			}
			char colu = item[i][jndex];
			if (Character.isDigit(colu)) {
				col = colu - '0';
				taken[col-1] = true;
			}
		}
		int startRow = index - (index % 3) , startCol = jndex - (jndex % 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (Character.isDigit( item[i + startRow][j + startCol])) {
					int col = item[i + startRow][j + startCol] - '0';
					taken[col - 1] = true;
				}
			}
		}
		for (int i = 0; i < taken.length; i++) {
			if (taken[i] == false) {
				response.add(i+1);
			}
		}
		return response;
	}
	
	public static void main(String[] args) {
		char [][] sudoku = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		solveSudoku(sudoku);
		System.out.println(Arrays.deepToString(sudoku));
	}

}
