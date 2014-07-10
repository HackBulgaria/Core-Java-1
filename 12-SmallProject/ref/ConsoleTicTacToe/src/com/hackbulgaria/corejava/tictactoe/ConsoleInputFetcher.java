package com.hackbulgaria.corejava.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.hackbulgaria.corejava.tictactoe.UserInput.InputType;

public class ConsoleInputFetcher implements UserInputFetcher {

	private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public UserInput fetchUserInput() {
		String userInput;
		try {
			userInput = bufferedReader.readLine();
			if (userInput.trim().equals("u")) {
				return new UserInput(InputType.UNDO);
			} else if (userInput.trim().equals("r")) {
				return new UserInput(InputType.REDO);
			} else if (userInput.trim().equals("q")) {
				return new UserInput(InputType.QUIT);
			}

			Scanner scanner = new Scanner(userInput);
			int y = scanner.nextInt();
			int x = scanner.nextInt();
			scanner.close(); // just a good style, but this is not necessary
								// here.

			return new UserInput(x, y);
		} catch (InputMismatchException badInput) {
			badInput.printStackTrace();
			return new UserInput(InputType.QUIT);
		} catch (IOException e) {
			e.printStackTrace();
			return new UserInput(InputType.QUIT);
		}
	}

}
