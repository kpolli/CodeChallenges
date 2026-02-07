package com.code.challenges.google;

import java.util.Random;

public class MineSweeper {
	
	private int [][] mine;
	private int numMines;
	private char [][] maskedMine;
	
	public MineSweeper(int m, int n, int num) {
		mine = new int[m][n];
		maskedMine = new char[m][n];
		numMines = num;
		buildMineMatrix();
	}
	
	void buildMineMatrix() {	
		populateMatrix();
		shuffleMatrix();
		setNeighborCount();
	}
	
	void shuffleMatrix() {
		Random ran = new Random();
		int numShuffles = 99, initial = 0;;
		while(initial < numShuffles) {
			int x = ran.nextInt(mine.length);
			int y = ran.nextInt(mine[0].length);
			
			int a = ran.nextInt(mine.length);
			int b = ran.nextInt(mine[0].length);
			
			if (x != a && b != y) {
				int temp = mine[x][y];
				mine[x][y] = mine[a][b];
				mine[a][b] = temp;
			}
			initial++;
		}
	}
	
	void populateMatrix() {
		int count = 0;
		int totalCells = mine.length * mine[0].length;
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine[i].length; j++) {
				if (count < numMines) {
					int num = totalCells > numMines * 2 ? 9 : 0;
					mine[i][j] = num;
					count++;
					if (count == numMines) {
						break;
					}
				}
			}
		}
	}
	
	void setNeighborCount() {
		for (int i = 0; i < mine.length; i++) {
			for (int j = 0; j < mine[i].length; j++) {
				if (mine[i][j] == 9) {
					break;
				}
				if (j +1 < mine[i].length - 1 && mine[i][j + 1] == 9) {
					mine[i][j] += 1;
				}
				if (i +1 < mine.length - 1 && mine[i + 1][j] == 9) {
					mine[i][j] += 1;
				}
				if (i +1 < mine.length - 1 && j +1 < mine[i].length - 1 && mine[i+1][j + 1] == 9) {
					mine[i][j] += 1;
				}
				if (j>0 && i > 0 && mine[i - 1][j-1] == 9) {
					mine[i][j] += 1;
				}
				if (j > 0 && mine[i][j - 1] == 9) {
					mine[i][j] += 1;
				}
				if (i > 0 && mine[i-1][j] == 9) {
					mine[i][j] += 1;
				}
			}
			
		}
	}
	
	void initializeMaskedMine() {
		for (int i = 0; i < maskedMine.length; i++) {
			for (int j = 0; j < maskedMine[i].length; j++) {
				maskedMine[i][j] = '-';
			}
		}
	}

}
