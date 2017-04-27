package com.exmachina.the25.models;

public class Row {
	private int lineNum;
	private boolean[] values;

	public int getRowNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

	public boolean[] getValues() {
		return values;
	}

	public void setValues(boolean[] values) {
		this.values = values;
	}

}
