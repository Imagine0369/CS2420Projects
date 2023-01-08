package lab11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Demonstration of Java's PriorityQueue class.
 * 
 * @author Erin Parker
 * @version April 9, 2021
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {
//		//PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//		pq.add(36);
//		pq.add(17);
//		pq.add(3);
//		pq.add(100);
//		pq.add(19);
//		pq.add(2);
//		pq.add(70);
//
//		 System.out.println("Array: " + Arrays.toString(pq.toArray()));
////		
////		PriorityQueue<String> pq = new PriorityQueue<String>(new ReverseStringComparator());
////		
////		pq.add("abc");
////		pq.add("aefv");
////		pq.add("zgre");
////		pq.add("iyjj");
////		pq.add("aaaaa");
//
//		System.out.println("First item removed: " + pq.remove());
//		System.out.println("Second item removed: " + pq.remove());
//		System.out.println("Third item removed: " + pq.remove());
//		System.out.println("Fourth item removed: " + pq.remove());
//		System.out.println("Fifth item removed: " + pq.remove());
//		System.out.println("Sixth item removed: " + pq.remove());
//		System.out.println("Seventh item removed: " + pq.remove());
		
		Random rand = new Random();
		
		// TODO Auto-generated method stub
	    // Do 10000 lookups and use the average running time.
	    int timesToLoop = 1000;
	    
	    // For each problem size n . . .
	    for (int n = 1000; n <= 20000; n += 1000) {

	      // Generate a new "random" stack of size n.
	    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	      long startTime, midpointTime, stopTime;

	      // First, spin computing stuff until one second has gone by.
	      // This allows this thread to stabilize.
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }

	      // Now, run the test.  
	      startTime = System.nanoTime();
	      


	     for (int i = 0; i < timesToLoop; i++) {
		    	  pq.add(rand.nextInt(100));
	     }

	      midpointTime = System.nanoTime();

	      // Run a loop to capture the cost of running the "timesToLoop" loop and 
	      // generating a random ISBN.
//	      for (int i = 0; i < timesToLoop; i++) { 
//	        generateIsbn();
//	      }
	      for (int i = 0; i < timesToLoop; i++) { 
	    		  rand.nextInt();
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
	
//	public class ReverseStringComparator implements Comparator<String> {
//	    public int compare(String arg0, String arg1) {
//	       return arg1.compareTo(arg0);
//	    }
//	}

