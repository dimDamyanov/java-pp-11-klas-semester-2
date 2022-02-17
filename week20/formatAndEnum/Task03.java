package formatAndEnum;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		String[][] board = new String[3][3];
		 int gameStatus = 0, turn = 0;
		 while (gameStatus == 0) {
			 turn++;
			 printBoard(board);
			 if (turn % 2 == 0)
				 promptAndSetPosition("O", board);
			 else 
				 promptAndSetPosition("X", board);
			 gameStatus = determineBoardStatus(board);
		 }
		 
		 printBoard(board);
		 switch (gameStatus) {
		 case 1:
			 System.out.print("X player won");
			 break;
		 case -1:
			 System.out.print("O player won");
			 break;
		 default:
			 System.out.print("Draw");
		 }
	}
	
	public static void promptAndSetPosition(String player, String[][] board) {
		@SuppressWarnings("resource")
		Scanner sysInput = new Scanner(System.in);
		int row, column;
		System.out.printf("Enter a row (0, 1, 2) for a player %s: ", player);
		row = sysInput.nextInt();
		System.out.printf("Enter a column (0, 1, 2) for a player %s: ", player);
		column = sysInput.nextInt();
		
		if (board[row][column] == null)
			board[row][column] = player;
	}
	
	public static void printBoard(String[][] board) {
		for (int i = 0; i < 3; i++) {
			System.out.print(".............\n");
			System.out.printf("| %1s | %1s | %1s |\n", board[i][0] == null ? " " : board[i][0], board[i][1] == null ? " " : board[i][1], board[i][2] == null ? " " : board[i][2]);
		}
		System.out.print(".............\n");
	}
	
	public static int determineBoardStatus(String[][] board) {
		int xCurrent = 0, oCurrent = 0, total = 0;
		// Check rows
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == "X")
					xCurrent++;
				else if (board[i][j] == "O")
					oCurrent++;
			}
			if (xCurrent == 3)
				return 1;
			else if (oCurrent == 3)
				return -1;
			xCurrent = 0;
			oCurrent = 0;
		}
		
		// Check columns
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[j][i] == "X")
					xCurrent++;
				else if (board[j][i] == "O")
					oCurrent++;
			}
			if (xCurrent == 3)
				return 1;
			else if (oCurrent == 3)
				return -1;
			xCurrent = 0;
			oCurrent = 0;
		}

		// Check main diagonal
		for (int i = 0; i < 3; i++) {
			if (board[i][i] == "X")
				xCurrent++;
			else if (board[i][i] == "O")
				oCurrent++;
		}
		
		if (xCurrent == 3)
			return 1;
		else if (oCurrent == 3)
			return -1;

		xCurrent = 0;
		oCurrent = 0;
		
		// Check secondary diagonal
		for (int i = 0; i < 3; i++) {
			if (board[i][2-i] == "X")
				xCurrent++;
			else if (board[i][2-i] == "O")
				oCurrent++;
		}
		
		if (xCurrent == 3)
			return 1;
		else if (oCurrent == 3)
			return -1;

		// Check if all positions are used
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != null)
					total++;
			}
		}
		
		if (total != 9)
			return 0;
		else
			return -2;
	}
}
