package linkedList;

import java.util.Iterator;

public class MyLinkedList<E> {
	private Node<E> head, tail;
	private int size = 0;
	
	public MyLinkedList() {
	}
		 
	public MyLinkedList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			addLast(objects[i]);
	}
		 
	
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		else {
			return head.element;
		}
	}
	
	public E getLast() {
		if (size == 0) {
			return null;
		} 
		else {
			return tail.element;
		}
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		newNode.next = head;
		head = newNode;
		size++;
		
		if (tail == null)
			tail = head;
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		
		if (tail == null) {
			head = tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
		
		size++;
	}
	
	public void add(int index, E e) {
		if (index == 0) addFirst(e);
		else if (index >= size) addLast(e);
		else {
			Node<E> current = head;
			for (int i = 1; i < index; i++)
				current = current.next;
			Node<E> temp = current.next;
			current.next = new Node<>(e);
			(current.next).next = temp;
			size++;
		}
	}
	
	public E removeFirst() {
		if (size == 0) return null;
		else {
			Node<E> temp = head;
			head = head.next;
			size--;
			if (head == null) tail = null;
			return temp.element;
		}
	}
	
	public E removeLast() {
		if (size == 0) return null;
		else if (size == 1) { 
			Node<E> temp = head;
			head = tail = null; 
			size = 0;
			return temp.element;
		}
		else {
			Node<E> current = head;
		
			for (int i = 0; i < size - 2; i++)
				current = current.next;
		
			Node<E> temp = tail;
			tail = current;
			tail.next = null;
			size--;
			return temp.element;
		}
	}
	
	public E remove(int index) {
		if (index < 0 || index >= size) return null; 
		else if (index == 0) return removeFirst();
		else if (index == size - 1) return removeLast();
		else {
			Node<E> previous = head;
		
			for (int i = 1; i < index; i++) {
				previous = previous.next;
			}
		
			Node<E> current = previous.next;
			previous.next = current.next;
			size--;
			
			return current.element;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
		
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			result.append(current.element);
			current = current.next;
			if (current != null) {
				result.append(", ");
			}
			else {
				result.append("]");
			}
		}
		
		return result.toString();
	}
	
	public void clear() {
		size = 0;
		head = tail = null;
	}
	
	public boolean contains(Object e) {
		Iterator<E> linkedListIterator = this.iterator();
		while(linkedListIterator.hasNext()) {
			if(linkedListIterator.next().equals(e))
				return true;
		}
		return false;
	}
	
	public E get(int index) {
		Node<E> current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		
		return current.element;
	}
	
	public int indexOf(Object e) {
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				return i;
			current = current.next;
		}
		return -1;
	}
	
	public int lastIndexOf(E e) {
		int index = -1;
		Node<E> current = head;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(e))
				index = i;
			current = current.next;
		}
		return index;
	}
	
	public E set(int index, E e) {
		Node<E> current = head;
		for (int i = 0; i < index; i++)
			current = current.next;
		
		current.element = e;
		return e;
	}
	
	public java.util.Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements java.util.Iterator<E> {
		private Node<E> current = head;
		private Node<E> previous = null;
		private Node<E> prePrevious = null;
		
		
		public boolean hasNext() {
			return (current != null);
		}
		
		public E next() {
			E e = current.element;
			prePrevious = previous;
			previous = current;
			current = current.next;
			return e;
			
		}
	
		public void remove() {
			if (previous == head) {
				head = head.next;
				return;
			}
			prePrevious.next = previous.next;
			size--;
		}
	}
	
	private static class Node<E> {
		E element;
		Node<E> next;
		
		public Node(E element) {
			this.element = element;
		}
	}
	
	public int size() {
		return size;
	}
}
