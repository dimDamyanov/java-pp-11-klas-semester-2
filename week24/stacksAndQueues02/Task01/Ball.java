package stacksAndQueues02;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

class Ball implements Comparable<Ball> {
	int x = 0;
	int y = 0; // Current ball position
	int dx = 2; // Increment on ball's x-coordinate
	int dy = 2; // Increment on ball's y-coordinate
	int radius = ThreadLocalRandom.current().nextInt(2, 20); // Ball radius
	Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));

	@Override
	public int compareTo(Ball ball) {
		return this.radius - ball.radius;
	}
}