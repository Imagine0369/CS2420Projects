package assign06;

import java.util.Random;


public class TESTER {
	
	public static Random rand = new Random();
	
	public static ArrayStack<Integer> generateArrayStack(int n){
		ArrayStack<Integer> aStack = new ArrayStack<Integer>();
		for(int i = 0; i < n; i++) {
			aStack.push(rand.nextInt(100));
		}
		
		return aStack;
	}
	
	public static LinkedListStack<Integer> generateLinkedListStack(int n){
		LinkedListStack<Integer> llStack = new LinkedListStack<Integer>();
		for(int i = 0; i < n; i++) {
			llStack.push(rand.nextInt(100));
		}
		
		return llStack;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Do 10000 lookups and use the average running time.
	    int timesToLoop = 100;
	    
	    // For each problem size n . . .
	    for (int n = 1000; n <= 10000; n += 1000) {

	      // Generate a new "random" stack of size n.
	     LinkedListStack<Integer> stack = generateLinkedListStack(n);

	      long startTime, midpointTime, stopTime;

	      // First, spin computing stuff until one second has gone by.
	      // This allows this thread to stabilize.
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }

	      // Now, run the test.  
	      startTime = System.nanoTime();
	      


	     // for (int i = 0; i < timesToLoop; i++) {
		      for(int j = 0; j < n; n++) {
		    	  stack.push(rand.nextInt(100));
		    	  }
	     // }

	      midpointTime = System.nanoTime();

	      // Run a loop to capture the cost of running the "timesToLoop" loop and 
	      // generating a random ISBN.
//	      for (int i = 0; i < timesToLoop; i++) { 
//	        generateIsbn();
//	      }
	      for (int i = 0; i < timesToLoop; i++) { 
	    	  for(int j = 0; j < n; n++) {
	    		  rand.nextInt();
	    	  }
		      }

	      stopTime = System.nanoTime();

	      // Compute the time, subtract the cost of running the loop
	      // from the cost of running the loop and doing the lookups.
	      // Average it over the number of runs.
	      double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
	          / (double) timesToLoop;

	      System.out.println(n + "\t" + averageTime);
	  }

	}

}
