package lab06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LLQueueTest {

	@Test
	void testSingleAddPeek() {
		LLQueue<Character> alq = new LLQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.peek());
	}
	
	@Test
	void testSingleAddPoll() {
		LLQueue<Character> alq = new LLQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.poll());
	}
	
	@Test
	void testMultiAddPeek() {
		LLQueue<Character> alq = new LLQueue<Character>();
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
		LLQueue<Character> alq = new LLQueue<Character>();
		alq.offer('a');
		alq.offer('b');
		alq.offer('c');
		assertEquals((Character)'a', alq.poll());
		assertEquals((Character)'b', alq.poll());
		assertEquals((Character)'c', alq.poll());
	}
	
	@Test
	void testInterleavedAddPoll() {
		LLQueue<Character> alq = new LLQueue<Character>();
		alq.offer('a');
		assertEquals((Character)'a', alq.poll());
		alq.offer('b');
		assertEquals((Character)'b', alq.poll());
		alq.offer('c');
		assertEquals((Character)'c', alq.poll());
	}
	
	@Test
	void testComplexInteraction() {
		LLQueue<Character> alq = new LLQueue<Character>();
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