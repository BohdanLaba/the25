package com.exmachina.the25.services;

import java.util.ArrayList;
import java.util.List;

import com.exmachina.the25.draw.Drawer;
import com.exmachina.the25.models.Board;
import com.exmachina.the25.models.Player;

public class Game {

	private Board board;
	private Player lastPlayer;
	private List<Player> playerList;
	private Drawer drawer;

	public Game() {
		playerList = new ArrayList<Player>();
	}
	
	public final void runGame() {
		boolean gameEnd = false;
		while (!gameEnd) {
			gameEnd = runTurns();
		}
		System.out.println(lastPlayer.getNickName() + " lost !");
	}

	private boolean runTurns() {
		for (Player player : playerList) {
			boolean end = player.doTurn(board);
			System.out.println(player.getNickName() + " turn result :");
			drawer.printBoard(board);

			if (end) {
				lastPlayer = player;
				return end;
			}
		}
		return false;
	}

	public void addPlayer(Player newPlayer) {
		playerList.add(newPlayer);
	}

	public void addDrawer(Drawer drawer) {
		this.drawer = drawer;
	}
	
	public void addBoard(Board board) {
		this.board = board;
	}
}
