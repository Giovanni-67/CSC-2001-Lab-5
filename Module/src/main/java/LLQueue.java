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

    public LLQueue(LLQueue.Node head, int size) {
        this.head = head;
        this.size = size;
    }

    //This static method takes no arguments and returns an empty stack.
    public static LLQueue emptyQueue() {
        LLQueue empty = new LLQueue(null,0);
        return empty;
    }


    //A method that adds new data onto the stack
    public void push(String newData){
        LLQueue.Node newNode = new LLQueue.Node(newData, head);
        head = newNode;
        size++;

    }

    //A method that returns the number of elements in the stack.
    public int size(){
        return size;
    }

    //A method that returns true when the stack contains no elements.
    public boolean is_empty(){
        return size == 0;
    }

    //A method that returns the top element, but does not remove it. If there is no such element, raises an IndexError exception.
    public String peek(){
        if(is_empty()){
            throw new IndexOutOfBoundsException("There is no such element");
        }
        return head.value;
    }


    //A method that removes and returns the top element. If there is no such element, raises an IndexError exception.
    public String pop(){
        if(is_empty()){
            throw new IndexOutOfBoundsException("There is no such element");
        }

        String poppedValue = head.value;
        head = head.next;
        size--;
        return poppedValue;
    }
}
