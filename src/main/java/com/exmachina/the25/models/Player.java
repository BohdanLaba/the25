package com.exmachina.the25.models;

import com.exmachina.the25.algorithm.BasicStrategy;
import com.exmachina.the25.services.Utils;

public class Player {

	private String nickName;
	private BasicStrategy strategy;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public BasicStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(BasicStrategy strategy) {
		this.strategy = strategy;
	}

	// return end if was last turn in game
	public boolean doTurn(Board board) {
		strategy.pullStones(board);
		return Utils.checkBoardIsEmpty(board);
	}
}
