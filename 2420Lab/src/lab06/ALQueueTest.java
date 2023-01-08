package lab06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ALQueueTest {

	@Test
	void testSingleAddPeek() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.peek());
	}
	
	@Test
	void testSingleAddPoll() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.poll());
	}
	
	@Test
	void testMultiAddPeek() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		alq.offer('b');
		alq.offer('c');
		assertEquals((Character)'a', alq.peek());
		alq.poll();
		assertEquals((Character)'b', alq.peek());
		alq.poll();
		assertEquals((Character)'c', alq.peek());
	}
	
	@Test
	void testMultiAddPoll() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		alq.offer('b');
		alq.offer('c');
		assertEquals((Character)'a', alq.poll());
		assertEquals((Character)'b', alq.poll());
		assertEquals((Character)'c', alq.poll());
	}
	
	@Test
	void testInterleavedAddPoll() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.poll());
		alq.offer('b');
		assertEquals((Character)'b', alq.poll());
		alq.offer('c');
		assertEquals((Character)'c', alq.poll());
	}
	
	@Test
	void testComplexInteraction() {
		ALQueue<Character> alq = new ALQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.peek());
		alq.offer('b');
		assertEquals((Character)'a', alq.poll());
		alq.offer('c');
		alq.offer('d');
		assertEquals((Character)'b', alq.peek());
		assertEquals((Character)'b', alq.poll());
		assertEquals((Character)'c', alq.peek());
		assertEquals((Character)'c', alq.poll());
	}

}
