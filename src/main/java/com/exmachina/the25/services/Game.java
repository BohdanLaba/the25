package com.exmachina.the25.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public final void runGameAutomatic(long times) {
		Map<String, Long> playersMapLoses = new HashMap<String, Long>();
		playersMapLoses.put(playerList.get(0).getNickName(), 0L);
		playersMapLoses.put(playerList.get(1).getNickName(), 0L);

		for (int i = 0; i < times; i++) {
			boolean gameEnd = false;
			while (!gameEnd) {
				gameEnd = runTurnsAutomatic();
			}
			playersMapLoses.put(lastPlayer.getNickName(), playersMapLoses.get(lastPlayer.getNickName()) + 1);
			board = new Board();
		}

		System.out.println(String.format("Player %s won %d times.", playerList.get(0).getNickName(),
				playersMapLoses.get(playerList.get(1).getNickName())));
		System.out.println(String.format("Player %s won %d times.", playerList.get(1).getNickName(),
				playersMapLoses.get(playerList.get(0).getNickName())));
	}

	private boolean runTurnsAutomatic() {
		for (Player player : playerList) {
			boolean end = player.doTurn(board);
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
