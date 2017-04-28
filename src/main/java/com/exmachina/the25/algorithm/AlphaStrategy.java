package com.exmachina.the25.algorithm;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.exmachina.the25.models.Board;
import com.exmachina.the25.services.Utils;

public class AlphaStrategy extends BasicStrategy {

	private static Random random = new Random((new Date()).getTime());
	private Set<Integer> generalRowIndexes;

	public AlphaStrategy() {
		generalRowIndexes = createSet();
	}

	@Override
	public void pullStones(Board board) {
		boolean rowHasStones = false;
		boolean[] row = new boolean[0];
		int rowNum = -1;

		Set<Integer> rowIndexes = createSet();

		// remove only central elements at the beginning
		while (!generalRowIndexes.isEmpty()) {
			rowNum = random.nextInt(Board.HEIGHT);
			if (generalRowIndexes.contains(rowNum)) {
				row = board.getRow(rowNum);
				if (Utils.rowIsFull(row)) {
					board.setRow(rowNum, grabCentralStone(row));
					return;
				} else {
					generalRowIndexes.remove(rowNum);
				}
			}
		}

		// if not found - begin random strategy
		while (!rowHasStones) {
			rowNum = random.nextInt(Board.HEIGHT);

			if (rowIndexes.contains(rowNum)) {
				row = board.getRow(rowNum);
				rowHasStones = !Utils.checkRowIsEmpty(row);
				if (!rowHasStones) {
					rowIndexes.remove(rowNum);
				}
			}
		}

		board.setRow(rowNum, grabStones(row));
	}

	private boolean[] grabStones(boolean[] row) {
		boolean succesfulGrab = false;

		while (!succesfulGrab) {
			int position = Utils.rowHasXValuesStraight(row, 2);
			if (position != -1) {
				succesfulGrab = true;
				for (int i = position; i < position + 2; i++) {
					row[i] = false;
				}

			} else {

				int takeCount = random.nextInt(Board.WIDTH) + 1;

				// here I check whether can take exact stone amount from this
				// row
				for (int i = 0; i < Board.WIDTH + 1 - takeCount; i++) {
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
		}
		return row;
	}

	private boolean[] grabCentralStone(boolean[] row) {
		row[Board.WIDTH / 2] = false;
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
