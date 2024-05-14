package FIFO;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    // Constructor
    public Queue() {
        this.front = null;
        this.rear = null;
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

    // Enqueue operation to add an item to the rear of the queue
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    // Dequeue operation to remove and return the front item from the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    // Peek operation to return the front item from the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Test cases
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Size of the queue: " + queue.size());
        System.out.println("Front item: " + queue.peek());
        System.out.println("Dequeue item: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
    }
}

