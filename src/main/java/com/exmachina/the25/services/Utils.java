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
		for (int i = 0; i < Board.WIDTH; i++) {
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

	/**
	 * should retun starting index of row
	 * 
	 * @param row
	 * @param count
	 * @return
	 */
	public static int rowHasXValuesStraight(boolean[] row, int count) {
		if (count > Board.WIDTH) {
			return -1;
		}

		for (int i = 0; i < Board.WIDTH - count; i++) {
			boolean continuousLine = true;
			// check continuous line
			for (int j = i; j < i + count; j++) {
				continuousLine = continuousLine & row[j];
			}
			if (continuousLine) {
				return i;
			}
		}

		return -1;
	}

	public static boolean rowIsFull(boolean[] row) {
		for (int i = 0; i < Board.WIDTH; i++) {
			if (!row[i]) {
				return false;
			}
		}
		return true;
	}
}
