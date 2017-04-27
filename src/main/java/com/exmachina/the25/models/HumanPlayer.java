package com.exmachina.the25.models;

import com.exmachina.the25.algorithm.HumanStrategy;

public class HumanPlayer extends Player {
	
	public HumanPlayer() {
		super();
		setStrategy(new HumanStrategy());
	}
}
