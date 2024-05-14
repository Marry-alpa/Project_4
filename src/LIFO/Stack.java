package LIFO;

import java.util.NoSuchElementException;

public class Stack<T> {
    private Node<T> top;
    private int size;

    // Constructor
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Push operation to add an item to the top of the stack
    public void push(T item) {
        Node<T> newNode = new Node<>(item, top);
        top = newNode;
        size++;
    }

    // Pop operation to remove and return the top item from the stack
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    // Peek operation to return the top item from the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Test cases
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Size of the stack: " + stack.size());
        System.out.println("Top item: " + stack.peek());
        System.out.println("Pop item: " + stack.pop());
        System.out.println("Size after pop: " + stack.size());
    }
}

