package assign06;

import java.util.NoSuchElementException;

/**
 * @author Mike Phelps
 * 
 *         Creates a Stack data structure with a SinglyLinkedList backing.
 *
 * @param <T>
 */
public class LinkedListStack<T> implements Stack<T> {

	private SinglyLinkedList<T> stackList;

	/**
	 * Default zero parameter constructor for stackList
	 */
	public LinkedListStack() {

		stackList = new SinglyLinkedList<T>();
	}

	/**
	 * Constructor for stack that takes in a list and sets it as the stackList
	 * 
	 * @param list SinglyLinkedList
	 */
	public LinkedListStack(SinglyLinkedList<T> list) {
		stackList = list;
	}

	/**
	 * Clears all items in the stack.
	 *
	 */
	@Override
	public void clear() {
		stackList.clear();

	}

	/**
	 * Checks if stack is empty. Returns true if it is empty, otherwise, false.
	 *
	 * @return boolean value T or F depending on if stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return stackList.isEmpty();
	}

	/**
	 * Returns the item on top of the stack
	 *
	 * @return T item on top of stack
	 */
	@Override
	public T peek() throws NoSuchElementException {
		return stackList.getFirst();
	}

	/**
	 * Deletes and returns the value on top of the stack.
	 * 
	 * @return T item deleted
	 */
	@Override
	public T pop() throws NoSuchElementException {
		return stackList.deleteFirst();
	}

	/**
	 * Places element on top of the stack
	 */
	@Override
	public void push(T element) {
		stackList.insertFirst(element);

	}

	/**
	 * Returns the size of the stack
	 *
	 * @return int size of the stack
	 */
	@Override
	public int size() {
		return stackList.size();
	}

}
