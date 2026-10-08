public class LLQueue {

    private Node head;
    private Node tail;
    private int size;

    public LLQueue(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public static LLQueue emptyQueue() {
        return new LLQueue(null, null, 0);
    }

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

    public int size() {
        return size;
    }

    public boolean is_empty() {
        return size == 0;
    }

    public String peek() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }
        return head.value;
    }

    public String dequeue() {
        if (is_empty()) {
            throw new IndexOutOfBoundsException("There is no such element");
        }

        String poppedValue = head.value;
        head = head.next;
        size--;

        if (is_empty()) {
            tail = null;
        }

        return poppedValue;
    }
}