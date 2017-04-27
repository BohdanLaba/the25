package com.exmachina.the25.services;

import com.exmachina.the25.models.Board;

public class Utils {
	public static boolean checkBoardIsEmpty(Board board) {
		for (int i = 0; i < Board.WIDTH; i++)
			for (int j = 0; j < Board.HEIGHT; j++) {
				if (board.getCellValue(i, j)) {
					return false;
				}
			}
		return true;
	}

	public static boolean checkRowIsEmpty(boolean[] row) {
		for (int i  = 0; i < Board.WIDTH; i++) {
			if (row[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean[] andResult(boolean[] arg0, boolean[] arg1) {
		boolean[] result = new boolean[arg0.length];
		for (int i = 0; i < arg0.length; i++) {
			result[i] = arg0[i] & arg1[i];
		}
		return result;
	}
}
