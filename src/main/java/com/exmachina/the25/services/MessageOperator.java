package com.exmachina.the25.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.exmachina.the25.draw.BoardDrawer;
import com.exmachina.the25.main.Printer;
import com.exmachina.the25.models.Board;
import com.exmachina.the25.models.Row;
import com.exmachina.the25.models.Player;

public class MessageOperator {

	public void askForNickName(Player player) {
		Printer.print("Please, enter your nick : ");
		player.setNickName(readLine());
		Printer.print("Hi, " + player.getNickName());
	}

	// get coordinates - e.g. 3 a d
	public Row askForPullInput() {

		boolean validRead = false;
		String[] values = null;
		while (!validRead) {
			System.out.print("pull : ");
			String value = readLine().toLowerCase();
			values = value.split(BoardDrawer.SPACE);
			trimParams(values);
			validRead = Validator.validiate(values);
			if (!validRead) {
				Printer.print("e.g. valid input: '3 a d' or '1 e e'.");
			}
		}

		Row line = new Row();
		line.setLineNum(Integer.valueOf(values[0]) - 1);
		int start = BoardDrawer.ALPHABET.indexOf(values[1]);
		int end = BoardDrawer.ALPHABET.indexOf(values.length > 2 ? values[2] : values[1]) + 1;

		boolean[] row = new boolean[Board.WIDTH];
		Arrays.fill(row, true);
		int i = start;
		while (i < end) {
			row[i] = false;
			i++;
		}
		line.setValues(row);

		return line;
	}

	private String readLine() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void trimParams(String[] args) {
		for (int i = 0; i < args.length; i++) {
			args[i] = args[i].trim();
		}
	}
}
