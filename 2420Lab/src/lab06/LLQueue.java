package lab06;

import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {

	private LinkedList<T> linked;
	
	public LLQueue()
	{
		// TODO:
		linked = new LinkedList<>();
	}
	
	@Override
	/**
	 * Implement without using LinkedList's addLast or offer methods
	 */
	public void offer(T element) {
		// TODO:
		linked.add(element);
	}

	@Override
	/**
	 * Implement without using poll, pollFirst, or removeFirst
	 */
	public T poll() {
		// TODO:
		return linked.remove(0);
	}

	@Override
	/**
	 * Implement without using peek, peekFirst, or getFirst
	 */
	public T peek() {
		// TODO:
		return linked.get(0);
	}

}
