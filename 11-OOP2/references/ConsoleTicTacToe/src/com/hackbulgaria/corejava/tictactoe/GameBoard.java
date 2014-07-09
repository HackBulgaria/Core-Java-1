package com.hackbulgaria.corejava.tictactoe;


public final class GameBoard {
	public static final int BOARD_LENGTH = 3;

	private static final int PLAYER_1 = 1;
	private static final int PLAYER_2 = 0;

	private static final int UNSET = -1;

	private int currentPlayer = PLAYER_1;

	private final int[][] board;

	public GameBoard() {
		this.board = (new int[BOARD_LENGTH][BOARD_LENGTH]);
		for (int y = 0; y < BOARD_LENGTH; y++) {
			for (int x = 0; x < BOARD_LENGTH; x++) {
				getBoard()[y][x] = UNSET;
			}
		}
	}

	public GameState play(UserInput input) {
		switch (input.getType()) {
		case NORMAL:
			return doPlay(input);
		case UNDO:
			return undo(input);
		case REDO:
			return redo(input);
		default:
			return GameState.PLAYING;
		}
	}

	private GameState redo(UserInput input) {
		// nooope, you' ll write this one yourself
		return GameState.PLAYING;
	}

	private GameState undo(UserInput input) {
		// nooope, you' ll write this one yourself
		return GameState.PLAYING;
	}

	private GameState doPlay(UserInput input) {
		if (canPlace(input.getPoint().y, input.getPoint().x)) {

			getBoard()[input.getPoint().y][input.getPoint().x] = currentPlayer;
			
			GameState gameState = fetchGameState();
			if (gameState == GameState.PLAYING) {
				switchPlayers();
			}
			return gameState;
		}
		return GameState.PLAYING;
	}

	private GameState fetchGameState() {
		// check rows
		for (int y = 0; y < BOARD_LENGTH; y++) {
			int first = getBoard()[y][0];
			boolean allInRowAreSame = true;
			for (int x = 1; x < BOARD_LENGTH; x++) {
				allInRowAreSame &= (getBoard()[y][x] != UNSET && getBoard()[y][x] == first);
			}
			if (allInRowAreSame) {
				return chooseWinner(first);
			}
		}

		// check cols
		for (int x = 0; x < BOARD_LENGTH; x++) {
			int first = getBoard()[0][x];
			boolean allInColAreSame = true;
			for (int y = 1; y < BOARD_LENGTH; y++) {
				allInColAreSame &= (getBoard()[y][x] != UNSET && getBoard()[y][x] == first);
			}
			if (allInColAreSame) {
				return chooseWinner(first);
			}
		}

		// check diagonals
		int firstOnD1 = getBoard()[0][0];
		int firstOnD2 = getBoard()[0][BOARD_LENGTH - 1];
		boolean d1AreAllTheSame = true;
		boolean d2AreAllTheSame = true;
		for (int d = 0; d < BOARD_LENGTH; d++) {
			d1AreAllTheSame &= (getBoard()[d][d] != UNSET && getBoard()[d][d] == firstOnD1);
			d2AreAllTheSame &= (getBoard()[d][BOARD_LENGTH - 1 - d] != UNSET && getBoard()[d][BOARD_LENGTH - 1 - d] == firstOnD2);
		}
		if (d1AreAllTheSame) {
			return chooseWinner(firstOnD1);
		}
		if (d2AreAllTheSame) {
			return chooseWinner(firstOnD2);
		}

		return canPlaceAnywhere() ? GameState.PLAYING : GameState.DRAW;
	}

	public boolean canPlaceAnywhere() {
		// check still playable
		for (int y = 0; y < BOARD_LENGTH; y++) {
			for (int x = 0; x < BOARD_LENGTH; x++) {
				if (canPlace(y, x)) {
					return true;
				}
			}
		}
		return false;

	}

	private GameState chooseWinner(int boardValue) {
		return boardValue == PLAYER_1 ? GameState.PLAYER_1_WON : GameState.PLAYER_2_WON;
	}

	private void switchPlayers() {
		currentPlayer++;
		currentPlayer %= 2;
	}

	private boolean canPlace(int y, int x) {
		return inBounds(y, x) && !isOwnedByP1(y, x) && !isOwnedByP2(y, x);
	}

	private boolean inBounds(int y, int x) {
		return x >= 0 && y >= 0 && x < BOARD_LENGTH && y < BOARD_LENGTH;
	}

	public boolean isOwnedByP1(int y, int x) {
		return getBoard()[y][x] == PLAYER_1;
	}

	public boolean isOwnedByP2(int y, int x) {
		return getBoard()[y][x] == PLAYER_2;
	}

	public boolean isEmpty(int y, int x) {
		return getBoard()[y][x] == UNSET;
	}

	public int[][] getBoard() {
		return board;
	}
}
