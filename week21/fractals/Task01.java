package fractals;

import java.util.Scanner;

public class Task01 {
	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		scanner.close();
		turnOnFirstLights(n);
	}
	
	public static void turnOn(int n) {
		System.out.printf("+%d\n", n);
	}
	
	public static void turnOff(int n) {
		System.out.printf("-%d\n", n);
	}
	
	public static void turnOnFirstLights(int n) {
		if (n == 1)
			turnOn(1);
		else if (n == 2) {
			turnOn(1);
			turnOn(2);
		}
		else {
			turnOnLight(n - 1);
			turnOn(n);
			turnOnFirstLights(n - 2);
		}
	}
	
	public static void turnOnLight(int n) {
		if (n == 1)
			turnOn(1);
		else {
			turnOnLight(n - 1);
			turnOn(n);
			turnOffFirstLights(n - 1);
		}
	}
	
	public static void turnOffFirstLights(int n) {
		if (n == 1)
			turnOff(1);
		else {
			turnOnLight(n - 1);
			turnOff(n);
			turnOffFirstLights(n-1);
		}		
	}
}
