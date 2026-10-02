import java.util.*;

public class AStack {
    private String[] data;
    private int size = 0;

    public AStack(String[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public static AStack emptyStack() {
        String[] emptyData = new String[10];
        return new AStack(emptyData, 0);
    }

    //A method that adds new data onto the stack
    public void push(String newData){
        if(size >= data.length){
            String[] biggerData = new String[data.length*2];
            for(int i = 0; i < data.length; i++){
                biggerData[i] = data[i];
            }
            data = biggerData;
        }

        data[size] = newData;
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
        if(size == 0){
            throw new IndexOutOfBoundsException("This is an index error");
        }
        return data[size-1];
    }

    //A method that removes and returns the top element. If there is no such element, raises an IndexError exception.
    public String pop(){
        if(size == 0) {
            throw new IndexOutOfBoundsException("This is an index error");
        }
        String popped = data[size-1];
        data[size-1] = null;
        size--;
        return popped;
    }
}

