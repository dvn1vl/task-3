import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        testMyLinkedList();
        testMyStack();
        testMyQueue();
        testMyMinHeap();
    }

    private static void testMyLinkedList() {
        MyList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println("Testing MyLinkedList:");
        System.out.println("Size: " + linkedList.size());
        System.out.println("Contains 2: " + linkedList.contains(2));
        System.out.println("Contains 4: " + linkedList.contains(4));
        System.out.println();
    }

    private static void testMyStack() {
        MyStack<Integer> stack = new MyStack<>(new MyArrayList<>());
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Testing MyStack:");
        System.out.println("Size: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size after pop: " + stack.size());
        System.out.println();
    }

    private static void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>(new MyArrayList<>());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Testing MyQueue:");
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size after dequeue: " + queue.size());
        System.out.println();
    }

    private static void testMyMinHeap() {
        MyMinHeap<Integer> minHeap = new MyMinHeap<Integer>(new MyArrayList<Integer>());
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);

        System.out.println("Testing MyMinHeap:");
        System.out.println("Size: " + minHeap.size());
        System.out.println("Min element: " + minHeap.getMin());
        System.out.println("Extracted min element: " + minHeap.extractMin());
        System.out.println("Size after extraction: " + minHeap.size());
        System.out.println();
    }


}