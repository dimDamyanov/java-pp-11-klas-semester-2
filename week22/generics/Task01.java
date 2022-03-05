package generics;

import java.util.ArrayList;
import java.util.Random;

public class Task01 {
	//The main method is only for testing purposes
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Random random = new Random();
		for(int i = 0; i < 10; i++)
			arrayList.add(random.nextInt(100));
		
		shuffle(arrayList);
		printArrayList(arrayList);
		System.out.println(min(arrayList));
		sort(arrayList);
		printArrayList(arrayList);
	}
	
	public static <E> void shuffle(ArrayList<E> list) {
		Random random = new Random();
		for (int i = list.size() - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			
			E temp = list.get(i);
			list.set(i, list.get(j));
			list.set(j, temp);
		}
	}
	
	public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < list.size() - i; j++) {
				if (list.get(j - 1).compareTo(list.get(j)) > 0) {
					E temp = list.get(j - 1);
					list.set(j - 1, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> E min(ArrayList<E> list) {
		E currentMin = list.get(0);
		for (int i = 1; i < list.size(); i++)
			if (list.get(i).compareTo(currentMin) < 0)
				currentMin = list.get(i);
		return currentMin;
	}
	
	//The printArrayList method is only for testing purposes
	public static <E> void printArrayList(ArrayList<E> list) {
		System.out.print("[");
		for (int i = 0; i < list.size() - 1; i++)
			System.out.printf("%s, ", list.get(i).toString());
		System.out.printf("%s]\n", list.get(list.size() - 1).toString());
	}
}
