package Linked;
import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    // Constructor
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // Node class
    private static class Node<T> {
        private T data;
        private Node<T> prev;
        private Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    // Iterator class
    private class ListIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    // Methods
    public void add(T e) {
        Node<T> newNode = new Node<>(e, last, null);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void add(int index, T e) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == size) {
            add(e);
            return;
        }
        Node<T> current = getNode(index);
        Node<T> newNode = new Node<>(e, current.prev, current);
        if (current.prev != null) {
            current.prev.next = newNode;
        } else {
            first = newNode;
        }
        current.prev = newNode;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getNode(index).data;
    }

    public void remove(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.data.equals(e)) {
                removeNode(current);
                return;
            }
            current = current.next;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        removeNode(getNode(index));
    }

    public void removeAll(T e) {
        Node<T> current = first;
        while (current != null) {
            if (current.data.equals(e)) {
                Node<T> next = current.next;
                removeNode(current);
                current = next;
            } else {
                current = current.next;
            }
        }
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e, null, first);
        if (size == 0) {
            last = newNode;
        } else {
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private void removeNode(Node<T> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            first = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            last = node.prev;
        }
        size--;
    }

    // Test cases
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(0);
        list.add(2, 10);
        System.out.println("List: " + list);
        System.out.println("Size: " + list.getSize());
        System.out.println("Element at index 2: " + list.get(2));
        list.remove(1);
        System.out.println("List after removing element at index 1: " + list);
        list.removeAll(10);
        System.out.println("List after removing all occurrences of 10: " + list);
        System.out.println("Size after removal: " + list.getSize());
    }
}
