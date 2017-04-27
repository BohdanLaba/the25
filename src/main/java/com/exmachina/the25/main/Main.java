package com.exmachina.the25.main;

import java.util.Random;

import com.exmachina.the25.models.Board;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();
		for(int i =0; i< 100; i++) {
			int value = random.nextInt(Board.WIDTH) + 1;
			System.out.print(value + " ");
		}
	}

}
