import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class StackTests {
    /*Along with your standard testing, let’s do some timing. Here’s a short piece of Java code that measures the time it takes to run a function ‘f‘:

    long startTime = System.nanoTime();
    f();
    long endTime = System.nanoTime();

    long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
    IO.println("calling f took "+duration+" milliseconds.\n");

    Building on this code, write a function in the testing class that accepts a number ‘t‘,
    and tries to determine the largest number ‘n‘ for which pushing and then popping ‘n‘ elements takes less than ‘t‘ milliseconds.
    This testing function should start with a list of length 1, and then consider a list that is twice as big,
    and twice as big again, to examine successive elements of the exponential sequence 2^n.
    When it finds that a computation has taken more than ‘t‘ milliseconds, it should report the prior value of the sequence 2^n.

    Use this function to determine the number of elements that can be pushed and then popped in less than 1/10 of a second,
    2/10 of a second, 3/10 of a second, and so forth up to 1 second.

    You may notice some "jitter"; running the function twice with the same input may produce different outputs.

    Plot your outputs by hand on a piece of paper, with ‘pushes and pops‘ on the x axis and seconds on the y axis. Does it look linear?*/
    public void timingArrayNumbers(int t){
        int n = 1;
        while(true){
            AStack timedList = AStack.emptyStack();
            long startTime = System.nanoTime();

            for(int i = 0; i < n; i++){
                timedList.push("test");
            }
            for(int i = 0; i < n; i++){
                timedList.pop();
            }

            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            //System.out.println("calling array f took "+duration+" milliseconds.\n");

            if(duration > t){
                System.out.println(n/2);
                break;
            }
            n *= 2;
        }
    }


    public void timingLListNumbers(int t){
        int n = 1;
        while(true){
            LLStack timedList = LLStack.emptyStack();
            long startTime = System.nanoTime();

            for(int i = 0; i < n; i++){
                timedList.push("test");
            }
            for(int i = 0; i < n; i++){
                timedList.pop();
            }

            long endTime = System.nanoTime();
            long duration = ((endTime - startTime) / 1000000);  //divide by 1000000 to get milliseconds.
            //System.out.println("calling linkedlist f took "+duration+" milliseconds.\n");

            if(duration > t){
                System.out.println(n/2);
                break;
            }
            else{
                n *= 2;
            }
        }
    }

    @Test
    void testSize() {
        AStack first = AStack.emptyStack();
        LLStack second = LLStack.emptyStack();

        assertEquals(0, first.size());
        assertEquals(0, second.size());

        first.push("Hello");
        second.push("Hello");

        assertEquals(1, first.size());
        assertEquals(1, second.size());
    }

    @Test
    void testIsEmpty(){
        AStack first = AStack.emptyStack();
        LLStack second = LLStack.emptyStack();

        assertTrue(first.is_empty());
        assertTrue(second.is_empty());

        first.push("Hello");
        second.push("Hello");

        assertFalse(first.is_empty());
        assertFalse(second.is_empty());
    }

    @Test
    void testPush(){
        AStack first = AStack.emptyStack();
        LLStack second = LLStack.emptyStack();

        first.push("Hello");
        second.push("Hello");

        assertEquals(1, first.size());
        assertEquals(1, second.size());

        assertFalse(first.is_empty());
        assertFalse(second.is_empty());
    }

    @Test
    void testPeek(){
        AStack first = AStack.emptyStack();
        LLStack second = LLStack.emptyStack();

        first.push("Hello");
        second.push("Hello");
        first.push("World");
        second.push("World");

        assertEquals(first.peek(), "World");
        assertEquals(second.peek(), "World");
    }

    @Test
    void testPop(){
        AStack first = AStack.emptyStack();
        LLStack second = LLStack.emptyStack();

        first.push("Hello");
        second.push("Hello");
        first.push("World");
        second.push("World");

        assertEquals(first.pop(), "World");
        assertEquals(second.pop(), "World");
    }

    void main(){
        timingArrayNumbers(700);
        timingLListNumbers(700);
        //100: Array 2097152, List 524288
        //200: Array 4194304, List 2097152
        //300: Array 4194304, List 4194304
        //400: Array 16777216, List 8388608
        //500: Array 16777216, List 8388608
        //600: Array 16777216, List 8388608
        //700: Array 16777216, List 8388608
    }

}