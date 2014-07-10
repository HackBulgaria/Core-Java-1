package com.hackbulgaria.corejava.game2048;

import java.io.IOException;

import jline.Terminal;

import com.hackbulgaria.corejava.game2048.GameBoard.GameResult;
import com.hackbulgaria.corejava.game2048.GameBoard.MoveDirection;

public class ConsoleVisualizer {
	private static final int VIRTUAL_DOWN = 14;
	private static final int VIRTUAL_UP = 16;
	private static final int VIRTUAL_RIGHT = 6;
	private static final int VIRTUAL_LEFT = 2;
	private final GameBoard gameBoard;

	public ConsoleVisualizer(GameBoard gameBoard) {
		this.gameBoard = gameBoard;

		printBoard();
		GameResult result = GameResult.UNDETERMINED;

		while (result == GameResult.UNDETERMINED) {
			MoveDirection direction = getPlayerMove();

			if (gameBoard.canMove(direction)) {
				result = gameBoard.move(direction);
			}
			printBoard();
		}

		if (result == GameResult.WIN) {
			System.out.println("You won!");
		} else {
			System.out.println("Sorry, you lost :(");
		}
	}

	private MoveDirection getPlayerMove() {
		MoveDirection moveDirection = null;
		try {
			Terminal terminal = Terminal.setupTerminal();
			int c = terminal.readVirtualKey(System.in);
			if (c == VIRTUAL_LEFT) {
				moveDirection = MoveDirection.MOVE_LEFT;
			} else if (c == VIRTUAL_RIGHT) {
				moveDirection = MoveDirection.MOVE_RIGHT;
			} else if (c == VIRTUAL_UP) {
				moveDirection = MoveDirection.MOVE_UP;
			} else if (c == VIRTUAL_DOWN) {
				moveDirection = MoveDirection.MOVE_DOWN;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moveDirection;
	}

	private void printBoard() {
		for (int y = 0; y < GameBoard.BOARD_SIZE; y++) {
			for (int x = 0; x < GameBoard.BOARD_SIZE; x++) {
				System.out.print(gameBoard.getValue(y, x) + "          ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
