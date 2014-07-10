package com.hackbulgaria.corejava.game2048;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import com.hackbulgaria.corejava.game2048.GameBoard.MoveDirection;

public class GameBoard {
	public static final int BOARD_SIZE = 4;
	private static final int GAME_WIN_NUMBER = 2048;
	private final int[][] board;

	public enum MoveDirection {
		MOVE_UP(0, -1), MOVE_DOWN(0, 1), MOVE_LEFT(-1, 0), MOVE_RIGHT(1, 0);
		private MoveDirection(int xAdd, int yAdd) {
			this.xAddition = xAdd;
			this.yAddition = yAdd;
		}

		private final int xAddition;
		private final int yAddition;
	}

	public enum GameResult {
		WIN, LOSE, UNDETERMINED
	}

	public GameBoard() {
		board = new int[BOARD_SIZE][BOARD_SIZE];
		initOneSquare();
		initOneSquare();
	}

	private void initOneSquare() {
		int x = random();
		int y = random();

		// loop until we get a free square
		while (!isEmpty(y, x)) {
			x = random();
			y = random();
		}

		board[y][x] = twoOrFour();
	}

	private boolean isEmpty(int y, int x) {
		return board[y][x] == 0;
	}

	private static int random() {
		return random(BOARD_SIZE);
	}

	private static int random(int n) {
		return GlobalRandom.INSTANCE.nextInt(n);
	}

	private static Iterable<Point> pointIterator(MoveDirection direction) {
		List<Point> points = new ArrayList<>();
		switch (direction) {
		case MOVE_RIGHT:
			for (int y = 0; y < BOARD_SIZE; y++) {
				for (int x = BOARD_SIZE - 1; x >= 0; x--) {
					points.add(new Point(x, y));
				}
			}
			break;
		case MOVE_LEFT:
			for (int y = 0; y < BOARD_SIZE; y++) {
				for (int x = 0; x < BOARD_SIZE; x++) {
					points.add(new Point(x, y));
				}
			}
			break;
		case MOVE_UP:
			for (int x = 0; x < BOARD_SIZE; x++) {
				for (int y = 0; y < BOARD_SIZE; y++) {
					points.add(new Point(x, y));
				}
			}
			break;
		case MOVE_DOWN:
			for (int x = 0; x < BOARD_SIZE; x++) {
				for (int y = BOARD_SIZE - 1; y >= 0; y--) {
					points.add(new Point(x, y));
				}
			}
			break;
		}

		return points;
	}

	public GameResult move(MoveDirection direction) {
		int xAddition = direction.xAddition;
		int yAddition = direction.yAddition;
		for (Point p : pointIterator(direction)) {
			if (isEmpty(p.y, p.x)) {
				continue; // skip empty points
			}
			int cx = p.x;
			int cy = p.y;
			do {
				cx += xAddition;
				cy += yAddition;
			} while (isInBounds(cy, cx) && isEmpty(cy, cx));

			// we've gotten out of bounds
			if (!isInBounds(cx, cy)) {
				board[cy - yAddition][cx - xAddition] = board[p.y][p.x];
				if (p.x != cx - xAddition || p.y != cy - yAddition) {
					board[p.y][p.x] = 0;
				}
				continue;
			}

			// we've reached another square
			else if (!isEmpty(cy, cx)) {
				if (board[cy][cx] == board[p.y][p.x]) {
					board[cy][cx] *= 2;
					board[p.y][p.x] = 0;
				} else {
					board[cy - yAddition][cx - xAddition] = board[p.y][p.x];
					if (p.x != cx - xAddition || p.y != cy - yAddition) {
						board[p.y][p.x] = 0;
					}
				}
			}
		}

		GameResult result = checkBoardState();
		if (result == GameResult.UNDETERMINED) {
			initOneSquare();
		}

		return result;
	}

	private GameResult checkBoardState() {
		boolean hasEmpty = false;
		for (int y = 0; y < BOARD_SIZE; y++) {
			for (int x = 0; x < BOARD_SIZE; x++) {
				if (board[y][x] == GAME_WIN_NUMBER) {
					return GameResult.WIN;
				}
				if (isEmpty(y, x)) {
					hasEmpty = true;
				}
			}
		}
		return hasEmpty ? GameResult.UNDETERMINED : GameResult.LOSE;
	}

	private boolean isInBounds(int cy, int cx) {
		return cx >= 0 && cy >= 0 && cx < BOARD_SIZE && cy < BOARD_SIZE;
	}

	// 90% chance to initialize with 2, 10% with 4
	private int twoOrFour() {
		return random(10) == 9 ? 4 : 2;
	}

	public int getValue(int y, int x) {
		return board[y][x];
	}

	public boolean canMove(MoveDirection direction) {
		Iterable<Point> iterable = pointIterator(direction);
		for (Point candidate : iterable) {
			boolean isRealPoint = !isEmpty(candidate.y, candidate.x);
			if (!isRealPoint) {
				continue;// discard 0's
			}

			int destY = candidate.y + direction.yAddition;
			int destX = candidate.x + direction.xAddition;
			boolean isDestInBounds = isInBounds(destY, destX);
			boolean isDestEmpty = isDestInBounds && isEmpty(destY, destX);
			boolean canUpScore = isDestInBounds && board[destY][destX] == board[candidate.y][candidate.x];

			if (isDestInBounds && (isDestEmpty || canUpScore)) {
				return true;
			}
		}
		return false;
	}
}
