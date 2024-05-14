import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int numElements = 100000;
        DecimalFormat formatter = new DecimalFormat("#,###");

        // Test insertion into beginning for ArrayList
        long arrayListInsertionStartTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < numElements; i++) {
            arrayList.add(0, i);
        }
        long arrayListInsertionEndTime = System.nanoTime();
        long arrayListInsertionTime = arrayListInsertionEndTime - arrayListInsertionStartTime;
        System.out.println("ArrayList insertion into beginning time: " + formatter.format(arrayListInsertionTime) + " ns");

        // Test insertion into beginning for LinkedList
        long linkedListInsertionStartTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < numElements; i++) {
            linkedList.addFirst(i);
        }
        long linkedListInsertionEndTime = System.nanoTime();
        long linkedListInsertionTime = linkedListInsertionEndTime - linkedListInsertionStartTime;
        System.out.println("LinkedList insertion into beginning time: " + formatter.format(linkedListInsertionTime) + " ns");

        // Test accessing elements by index for ArrayList
        long arrayListAccessStartTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.get(i);
        }
        long arrayListAccessEndTime = System.nanoTime();
        long arrayListAccessTime = arrayListAccessEndTime - arrayListAccessStartTime;
        System.out.println("ArrayList access by index time: " + formatter.format(arrayListAccessTime) + " ns");

        // Test accessing elements by index for LinkedList
        long linkedListAccessStartTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.get(i);
        }
        long linkedListAccessEndTime = System.nanoTime();
        long linkedListAccessTime = linkedListAccessEndTime - linkedListAccessStartTime;
        System.out.println("LinkedList access by index time: " + formatter.format(linkedListAccessTime) + " ns");

        // Test removing first element for ArrayList
        long arrayListRemoveStartTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            arrayList.remove(0);
        }
        long arrayListRemoveEndTime = System.nanoTime();
        long arrayListRemoveTime = arrayListRemoveEndTime - arrayListRemoveStartTime;
        System.out.println("ArrayList remove first element time: " + formatter.format(arrayListRemoveTime) + " ns");

        // Test removing first element for LinkedList
        long linkedListRemoveStartTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            linkedList.removeFirst();
        }
        long linkedListRemoveEndTime = System.nanoTime();
        long linkedListRemoveTime = linkedListRemoveEndTime - linkedListRemoveStartTime;
        System.out.println("LinkedList remove first element time: " + formatter.format(linkedListRemoveTime) + " ns");
    }
}
