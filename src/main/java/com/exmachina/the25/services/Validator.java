package com.exmachina.the25.services;

import java.util.regex.Pattern;

import com.exmachina.the25.draw.BoardDrawer;
import com.exmachina.the25.main.Printer;
import com.exmachina.the25.models.Board;
import com.exmachina.the25.models.Row;

public class Validator {
	private static Pattern letterPattern = Pattern.compile("[a-zA-Z]");
	private static Pattern digitPattern = Pattern.compile("[\\d]");

	public static boolean validateTake(Row row, Board board) {
		boolean[] boardRow = board.getRow(row.getRowNum());
		for (int i = 0; i < boardRow.length; i++) {
			if (!boardRow[i] && !row.getValues()[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean validiate(String[] args) {
		return validateLength(args) && validateTypes(args) && validateLetterOrder(args) && validateIndexSize(args);
	}

	private static boolean validateLength(String[] args) {
		if (args == null || args.length < 3) {
			System.out.println("Parameters count must be 3.");
			return false;
		}
		return true;
	}

	private static boolean validateTypes(String[] args) {
		if (!digitPattern.matcher(args[0]).matches()) {
			Printer.print("1st parameter must be digit.");
			return false;
		}

		if (!letterPattern.matcher(args[1]).matches() || !letterPattern.matcher(args[2]).matches()) {
			Printer.print("2nd and 3rd parameters must be letters.");
			return false;
		}
		return true;
	}

	private static boolean validateLetterOrder(String[] args) {
		if (BoardDrawer.ALPHABET.indexOf(args[1]) > BoardDrawer.ALPHABET.indexOf(args[2])) {
			Printer.print("Invalid order of letters.");
			return false;
		}
		return true;
	}

	private static boolean validateIndexSize(String[] args) {
		int value = Integer.valueOf(args[0]);
		if (value < 1 || value > Board.HEIGHT) {
			Printer.print("Invalid height.");
			return false;
		}
		if (BoardDrawer.ALPHABET.indexOf(args[1]) + 1 > Board.WIDTH
				|| BoardDrawer.ALPHABET.indexOf(args[2]) + 1 > Board.WIDTH) {
			Printer.print("Invalid width.");
			return false;
		}
		return true;
	}

}
