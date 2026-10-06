import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTests {

    public void timingArrayNumbers(int t){
        int n = 1;
        while(true){
            AQueue timedList = AQueue.emptyQueue(n);
            long startTime = System.nanoTime();

            for(int i = 0; i < n; i++){
                timedList.enqueue("test");
            }
            for(int i = 0; i < n; i++){
                timedList.dequeue();
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
            LLQueue timedList = LLQueue.emptyQueue();
            long startTime = System.nanoTime();

            for(int i = 0; i < n; i++){
                timedList.enqueue("test");
            }
            for(int i = 0; i < n; i++){
                timedList.dequeue();
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
        AQueue first = AQueue.emptyQueue(10);
        LLQueue second = LLQueue.emptyQueue();

        assertEquals(0, first.size());
        assertEquals(0, second.size());
        first.enqueue("Hello");
        second.enqueue("Hello");

        assertEquals(1, first.size());
        assertEquals(1, second.size());
    }

    @Test
    void testIsEmpty(){
        AQueue first = AQueue.emptyQueue(10);
        LLQueue second = LLQueue.emptyQueue();

        assertTrue(first.is_empty());
        assertTrue(second.is_empty());

        first.enqueue("Hello");
        second.enqueue("Hello");

        assertFalse(first.is_empty());
        assertFalse(second.is_empty());
    }

    @Test
    void testEnqueue() {
        AQueue first = AQueue.emptyQueue(10);
        LLQueue second = LLQueue.emptyQueue();

        first.enqueue("Hello");
        first.enqueue("World");
        first.enqueue("Again");

        second.enqueue("Hello");
        second.enqueue("World");
        second.enqueue("Again");

        assertEquals(3, first.size());
        assertEquals(3, second.size());

        assertEquals("Hello", first.dequeue());
        assertEquals("World", first.dequeue());
        assertEquals("Again", first.dequeue());

        assertEquals("Hello", second.dequeue());
        assertEquals("World", second.dequeue());
        assertEquals("Again", second.dequeue());

        assertTrue(first.is_empty());
        assertTrue(second.is_empty());
    }

    @Test
    void testPeek(){
        AQueue first = AQueue.emptyQueue(10);
        LLQueue second = LLQueue.emptyQueue();

        first.enqueue("Hello");
        second.enqueue("Hello");
        first.enqueue("World");
        second.enqueue("World");

        assertEquals("Hello", first.peek());
        assertEquals("Hello", second.peek());
    }

    @Test
    void testDequeue(){
        AQueue first = AQueue.emptyQueue(10);
        LLQueue second = LLQueue.emptyQueue();

        first.enqueue("Hello");
        second.enqueue("Hello");
        first.enqueue("World");
        second.enqueue("World");

        assertEquals("Hello", first.dequeue());
        assertEquals("Hello", second.dequeue());
    }

    void main(){
        timingArrayNumbers(700);
        timingLListNumbers(700);
        //100:
        //200:
        //300:
        //400:
        //500:
        //600:
        //700:
    }

}
