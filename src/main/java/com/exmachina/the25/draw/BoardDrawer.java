package com.exmachina.the25.draw;

import com.exmachina.the25.main.Printer;
import com.exmachina.the25.models.Board;

public class BoardDrawer implements Drawer {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwyxz";
	public static final String SPACE = " ";
	public static final String CARET = "\n";

	public void printBoard(Board board) {
		// print indexes additionally
		StringBuilder builder = new StringBuilder();
		builder.append(SPACE).append(SPACE);
		for (int i = 0; i < Board.WIDTH; i++) {
			builder.append(ALPHABET.charAt(i)).append(SPACE);
		}
		builder.append(CARET);

		for (int i = 0; i < Board.HEIGHT; i++) {
			builder.append(i + 1).append(SPACE);
			for (int j = 0; j < Board.WIDTH; j++) {
				builder.append(drawCell(board.getCellValue(i, j))).append(SPACE);
			}
			builder.append(CARET);
		}
		Printer.print(builder.toString());
	}

	private char drawCell(boolean value) {
		return value ? '0' : '-';
	}
}
