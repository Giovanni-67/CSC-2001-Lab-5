class main() {
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

    public int timingNumbers(int t, int n){
        LLStack timedList = LLStack.emptyStack();
        for(int i = 0; i < n; i++){
            timedList.push("test");
        }
        for(int i = 0; i < n; i++){
            timedList.pop();
        }
        AStack timedList2 = AStack.emptyStack();

    }
}