public class LLQueue {

    private Node front;
    private Node back;
    private int size;

    private LLQueue(Node front, Node back, int size) {
        this.front = front;
        this.back = back;
        this.size = size;
    }

    //a static method that returns an empty queue.
    public static LLQueue emptyQueue() {
        return new LLQueue(null, null, 0);
    }

    // a void method that accepts a string and adds it to the end of the queue.
    public void enqueue(String newData) {
        // Add to the beginning of the back list.
        back = new Node(newData, back);
        size++;
    }

    // a method that returns a count of the number of elements currently in the queue
    public int size() {
        return size;
    }


    // a method that returns true when the queue contains no elements.
    public boolean is_empty() {
        return size == 0;
    }

    // Reverse the back list so the oldest element comes first.
    private void prepareFront() {
        if (front == null) {
            while (back != null) {
                front = new Node(back.value(), front);
                back = back.next();
            }
        }
    }
    //a method that returns the element at the front of the queue, without removing it. If there is no such element,raises an IndexError exception.
    public String peek() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }

        prepareFront();
        return front.value();
    }

    //a method that removes and returns the element at the front of the queue. If there is no such element, raises an IndexError exception.
    public String dequeue() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }

        prepareFront();

        String poppedValue = front.value();
        front = front.next();
        size--;

        return poppedValue;
    }
}