package generics;

public class Task02 {
	//This file is only for testing purposes
	public static void main(String[] args) {
		Queue<Character> queue = new Queue<Character>();
		for (char i = 'a'; i <= 'z'; i++) {
			queue.enqueue(i);
		}
		System.out.println(queue.toString());
		System.out.println(queue.getSize());
		System.out.println(queue.isEmpty());
		while (!queue.isEmpty())
			System.out.printf("%s, ", queue.dequeue().toString());
		System.out.println();
		System.out.println(queue.toString());
		System.out.println(queue.getSize());
		System.out.println(queue.isEmpty());
	}
}
