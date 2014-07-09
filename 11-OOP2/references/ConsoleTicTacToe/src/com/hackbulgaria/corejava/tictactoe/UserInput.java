package com.hackbulgaria.corejava.tictactoe;

import java.awt.Point;

public class UserInput {
	public enum InputType {
		NORMAL, QUIT, UNDO, REDO;
	}

	private static final Point INVALID_POINT = new Point(-1, -1);

	private final Point inputPoint;
	private final InputType type;

	public UserInput(int x, int y) {
		inputPoint = new Point(x, y);
		type = InputType.NORMAL;
	}

	public UserInput(InputType type) {
		inputPoint = INVALID_POINT;
		this.type = type;
	}

	public Point getPoint() {
		return inputPoint;
	}

	public InputType getType() {
		return this.type;
	}

}
