public class LLQueue {

    private Node head;
    private Node tail;
    private int size;

    public LLQueue(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    //a static method that returns an empty queue.
    public static LLQueue emptyQueue() {
        return new LLQueue(null, null, 0);
    }

    // a void method that accepts a string and adds it to the end of the queue.
    public void enqueue(String newData) {
        Node newNode = new Node(newData, null);

        if (is_empty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
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

    //a method that returns the element at the front of the queue, without removing it. If there is no such element,raises an IndexError exception.
    public String peek() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }
        return head.value();
    }

    //a method that removes and returns the element at the front of the queue.If there is no such element, raises an IndexError exception.
    public String dequeue() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }

        String poppedValue = head.value();
        head = head.next();
        size--;

        if (is_empty()) {
            tail = null;
        }

        return poppedValue;
    }
}