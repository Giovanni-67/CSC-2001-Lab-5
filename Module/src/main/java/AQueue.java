public class AQueue {
    private String[] data;
    private int size = 0;
    private int front = 0;
    private int back = 0;

    public AQueue(int arraySize) {
        data = new String[arraySize];
        size = 0;
        front = 0;
        back = 0;
    }

    public static AQueue emptyQueue(int arraySize) {
        if(arraySize <= 0){
            throw new IllegalArgumentException("Array size must be greater than zero");
        }
        return new AQueue(arraySize);
    }

    //A method that adds new data onto the queue
    public void enqueue(String newData){
        if(size == data.length){
            throw new IllegalStateException("There is no more room");
        }
        if(back == data.length){
            back = 0;
        }

        data[back] = newData;
        size++;
        back++;
    }

    //A method that returns the number of elements in the queue.
    public int size(){
        return size;
    }

    //A method that returns true when the queue contains no elements.
    public boolean is_empty(){
        return size == 0;
    }

    //A method that returns the front element, but does not remove it. If there is no such element, raises an IndexError exception.
    public String peek(){
        if(size == 0){
            throw new IndexOutOfBoundsException("This is an index error");
        }
        return data[front];
    }

    //A method that removes and returns the front element. If there is no such element, raises an IndexError exception.
    public String dequeue(){
        if(size == 0) {
            throw new IndexOutOfBoundsException("This is an index error");
        }
        String popped = data[front];
        data[front] = null;
        if(front == data.length-1){
            front = 0;
        }
        else{
            front++;
        }
        size--;
        return popped;
    }
}
