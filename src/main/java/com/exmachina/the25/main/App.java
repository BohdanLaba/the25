package com.exmachina.the25.main;

import com.exmachina.the25.algorithm.RandomStrategy;
import com.exmachina.the25.draw.BoardDrawer;
import com.exmachina.the25.models.Board;
import com.exmachina.the25.models.HumanPlayer;
import com.exmachina.the25.models.Player;
import com.exmachina.the25.services.Game;
import com.exmachina.the25.services.MessageOperator;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Printer.print("Hello Player(s) in 'the25' !");
		MessageOperator operator = new MessageOperator();

		Board board = new Board();
		BoardDrawer drawer = new BoardDrawer();
		drawer.printBoard(board);

		Game game25 = new Game();
		game25.addBoard(board);
		game25.addDrawer(new BoardDrawer());

//		HumanPlayer human = new HumanPlayer();
//		operator.askForNickName(human);
//		game25.addPlayer(human);
//
//		HumanPlayer human1 = new HumanPlayer();
//		operator.askForNickName(human1);
//		game25.addPlayer(human1);

		 Player pcPlayer0 = new Player();
		 pcPlayer0.setNickName("dummy0");
		 pcPlayer0.setStrategy(new RandomStrategy());
		 game25.addPlayer(pcPlayer0);

		 Player pcPlayer1 = new Player();
		 pcPlayer1.setNickName("dummy1");
		 pcPlayer1.setStrategy(new RandomStrategy());
		 game25.addPlayer(pcPlayer1);

		game25.runGame();

	}
}
