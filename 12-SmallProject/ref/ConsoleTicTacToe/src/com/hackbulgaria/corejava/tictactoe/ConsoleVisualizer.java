package com.hackbulgaria.corejava.tictactoe;

public class ConsoleVisualizer {

	private final GameBoard gameBoard;

	public ConsoleVisualizer(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public void printGame() {
		final StringBuilder board = new StringBuilder();
		for (int y = 0; y < GameBoard.BOARD_LENGTH; y++) {
			for (int x = 0; x < GameBoard.BOARD_LENGTH; x++) {
				if (gameBoard.isOwnedByP1(y, x)) {
					board.append("X");
				}
				if (gameBoard.isOwnedByP2(y, x)) {
					board.append("O");
				} else if (gameBoard.isEmpty(y, x)) {
					board.append(".");
				}
			}
			board.append(System.lineSeparator());
		}
		System.out.println(board);

	}
}
