package com.exmachina.the25.models;

public class Board {
	public static final int WIDTH = 5;
	public static final int HEIGHT = 5;

	private boolean[][] board;

	public Board(boolean[][] board) {
		super();
		this.board = board;
	}

	public Board() {
		this.board = new boolean[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++) {
				this.board[i][j] = true;
			}
	}

	public boolean[][] getBoard() {
		return board;
	}

	public boolean[] getRow(int number) {
		if (number >= 0 && number < HEIGHT) {
			return this.board[number];
		} else {
			throw new IndexOutOfBoundsException("wrong inputs");
		}
	}

	public void setRow(int rowNum, boolean[] row) {
		board[rowNum] = row;
	}

	public void setBoard(boolean[][] board) {
		this.board = board;
	}

	public boolean getCellValue(int i, int j) {
		if (i < HEIGHT && i >= 0 && j < WIDTH && j >= 0) {
			return this.board[i][j];
		} else {
			throw new IndexOutOfBoundsException("wrong inputs");
		}
	}
}
