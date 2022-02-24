package recursion;

import java.util.*;

public class Task06 {
	public static ArrayList<String> moves = new ArrayList<String>();
	
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of disks: ");
		int n = input.nextInt();
		input.close();
		
		// Find the solution recursively
		moveDisks(n, 'A', 'B', 'C');
		System.out.printf("The minimum amount of moves is %d\n", moves.size());
		System.out.println("The moves are:");
		for(String move: moves)
			System.out.println(move);
	}
	 /** The method for finding the solution to move n disks from fromTower to toTower with auxTower */
	
	public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
		if (n == 1) // Stopping condition
			moves.add("Move disk " + n + " from " + fromTower + " to " + toTower);
		else {
			moveDisks(n-1, fromTower, auxTower, toTower);
			moves.add("Move disk " + n + " from " + fromTower + " to " + toTower);
			moveDisks(n-1, auxTower, toTower, fromTower);
		}
	}
}
