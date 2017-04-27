package com.exmachina.the25.algorithm;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.exmachina.the25.models.Board;
import com.exmachina.the25.services.Utils;

//random pulling algorithm
public class RandomStrategy extends BasicStrategy {

	private static Random random = new Random((new Date()).getTime());

	@Override
	public void pullStones(Board board) {
		boolean correctChosen = false;
		boolean[] row = new boolean[0];
		int rowNum = -1;

		Set<Integer> rowIndexes = createSet();

		while (!correctChosen) {
			rowNum = random.nextInt(Board.HEIGHT);

			if (rowIndexes.contains(rowNum)) {
				row = board.getRow(rowNum);
				correctChosen = !Utils.checkRowIsEmpty(row);
				rowIndexes.remove(rowNum);
				if(rowIndexes.size() == 0) {
					System.out.println("critical issue!");
					break;
				}
			}
		}
		board.setRow(rowNum, grabStones(row));
	}

	private boolean[] grabStones(boolean[] row) {
		boolean succesfulGrab = false;

		while (!succesfulGrab) {
			// problem possibly here
			// get a random num between 1 & 5
			int takeCount = random.nextInt(Board.WIDTH) + 1;

			// here I check whether can take exact stone amount from this row
			for (int i = 0; i < Board.WIDTH  + 1 - takeCount; i++) {
				boolean continuousSet = true;
				for (int j = 0; j < takeCount; j++) {
					continuousSet = continuousSet & row[i + j];
				}
				if (continuousSet) {
					for (int k = 0; k < takeCount; k++) {
						row[i + k] = false;
					}
					succesfulGrab = true;
					break;
				}
			}
		}
		return row;
	}

	private Set<Integer> createSet() {
		Set<Integer> rowIndexes = new HashSet<Integer>();
		rowIndexes.add(0);
		rowIndexes.add(1);
		rowIndexes.add(2);
		rowIndexes.add(3);
		rowIndexes.add(4);
		return rowIndexes;
	}
}
