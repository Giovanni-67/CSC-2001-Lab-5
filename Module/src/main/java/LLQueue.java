public class LLQueue {
    public class Node {
        String value;
        LLQueue.Node next;

        public Node(String value, LLQueue.Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private LLQueue.Node head;
    private int size;
    private LLQueue.Node tail;

    public LLQueue(LLQueue.Node head, LLQueue.Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    //This static method takes no arguments and returns an empty queue.
    public static LLQueue emptyQueue() {
        LLQueue empty = new LLQueue(null, null, 0);
        return empty;
    }


    //A method that adds new data onto the queue
    public void enqueue(String newData){
        LLQueue.Node newNode = new LLQueue.Node(newData, null);

        if(is_empty()){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;

    }

    //A method that returns the number of elements in the queue.
    public int size(){
        return size;
    }

    //A method that returns true when the stack contains no elements.
    public boolean is_empty(){
        return size == 0;
    }

    //A method that returns the front element, but does not remove it. If there is no such element, raises an IndexError exception.
    public String peek(){
        if(is_empty()){
            throw new IndexOutOfBoundsException("There is no such element");
        }
        return head.value;
    }


    //A method that removes and returns the front element. If there is no such element, raises an IndexError exception.
    public String dequeue(){
        if(is_empty()){
            throw new IndexOutOfBoundsException("There is no such element");
        }

        String poppedValue = head.value;
        head = head.next;
        size--;
        if(is_empty()){
            tail = null;
        }
        return poppedValue;
    }
}
