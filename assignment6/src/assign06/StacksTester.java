package assign06;

import java.util.Random;

public class StacksTester {

	private static Random rand;
	
	
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		long startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Time adding N values to different kinds of stacks
//		for(int N = 1000; N <= 20000; N += 1000)
//		{
//			//timeAddN(N);
//		}

		// Time adding then removing N values to different kinds of stacks
		for(int N = 1000; N <= 20000; N += 1000)
		{
			timePeekN(N);
			//timeRemoveN(N);
		}

	}
	
	private static void timePeekN(int N)
	{
		double startTime, midpointTime, stopTime;
		int timesToLoop = 2000000000;
		//int timesToLoop = 500;

		LinkedListStack<Integer> s = new LinkedListStack<Integer>();
		//ArrayStack<Integer> s = new ArrayStack<Integer>();
		
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();
		
		for(int j : testVals)
			s.push(j);
		
		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
				s.peek();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
	
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;

		System.out.println(N + "\t"+ averageTime);
	}
	
	
	private static void timeAddN(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 10000;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		LinkedListStack<Integer> s;
		//ArrayStack<Integer> s;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals)
				s.push(j);
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals) {}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;

		System.out.println(N + "\t"+ averageTime);
	}
	
	private static void timeRemoveN(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 10000;
		//int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		LinkedListStack<Integer> s;
		//ArrayStack<Integer> s;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals)
				s.push(j);
			for(int j = 0; j < N; j++)
				s.pop();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals) 
			{
				s.push(j); // subtract the offer time since we are timing pop
			}
			for(int j = 0; j < N; j++) {
				
			}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;

		System.out.println(N + "\t"+ averageTime);
	}
	
	private static void timePeekNOther(int N)
	{
		long startTime, midpointTime, stopTime;
		int timesToLoop = 10000;
		//int timesToLoop = 500;

		// Generate random input before starting the timer
		int[] testVals = new int[N];
		for(int i=0; i < N; i++)
			testVals[i] = randomInteger();

		LinkedListStack<Integer> s;
		//ArrayStack<Integer> s;

		startTime = System.nanoTime();

		for (int i = 0; i < timesToLoop; i++)
		{
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals)
				s.push(j);
			for(int j = 0; j < N; j++)
				s.peek();
		}

		midpointTime = System.nanoTime();

		// Run an loop to capture the cost of the overhead
		for (long i = 0; i < timesToLoop; i++) {
			s = new LinkedListStack<Integer>();
			//s = new ArrayStack<Integer>();
			for(int j : testVals) 
			{
				s.push(j); // subtract the offer time since we are timing pop
			}
			for(int j = 0; j < N; j++) {
				
			}
		}

		stopTime = System.nanoTime();

		// Subtract the cost of running the loop
		// from the cost of running the loop plus the real work.
		// Average it over the number of runs.
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime))
				/ timesToLoop;

		System.out.println(N + "\t"+ averageTime);
	}

	public static Integer randomInteger()
	{
		return rand.nextInt();
	}


}
