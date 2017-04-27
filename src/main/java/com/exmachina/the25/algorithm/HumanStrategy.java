package com.exmachina.the25.algorithm;

import com.exmachina.the25.main.Printer;
import com.exmachina.the25.models.Board;
import com.exmachina.the25.models.Row;
import com.exmachina.the25.services.MessageOperator;
import com.exmachina.the25.services.Utils;
import com.exmachina.the25.services.Validator;

public class HumanStrategy extends BasicStrategy {

	@Override
	public void pullStones(Board board) {
		MessageOperator operator = new MessageOperator();
		Row row = null;
		boolean valid = false;
		while (!valid) {
			row = operator.askForPullInput();
			valid = Validator.validateTake(row, board);
			if (!valid) {
				Printer.print("Invalid stones taken.");
			}
		}

		board.setRow(row.getRowNum(), Utils.andResult(board.getRow(row.getRowNum()), row.getValues()));
	}

}
