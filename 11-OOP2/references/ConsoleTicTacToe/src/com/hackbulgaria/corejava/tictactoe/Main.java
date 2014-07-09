package com.hackbulgaria.corejava.tictactoe;

import com.hackbulgaria.corejava.tictactoe.UserInput.InputType;

public class Main {
	public static void main(String[] args) {
		UserInputFetcher inputFetcher = new ConsoleInputFetcher();
		GameBoard gameBoard = new GameBoard();
		ConsoleVisualizer visualizer = new ConsoleVisualizer(gameBoard);

		UserInput input;
		do {
			visualizer.printGame();
			input = inputFetcher.fetchUserInput();
			GameState gameState = gameBoard.play(input);
			if (gameState != GameState.PLAYING) {
				System.out.println(pickMessage(gameState));
				return;
			}

		} while (input.getType() != InputType.QUIT);
	}

	private static String pickMessage(GameState gameState) {
		switch (gameState) {
		case PLAYER_1_WON:
			return "Player 1 won!";
		case PLAYER_2_WON:
			return "Player 2 won!";
		case DRAW:
			return "Its a draw!";
		default:
			return "";
		}
	}
}
