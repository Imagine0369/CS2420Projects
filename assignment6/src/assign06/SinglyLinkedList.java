package assign06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class creates a SinglyLinkedList Data Structure.
 * 
 * @author Mike Phelps
 *
 * @param <T>
 */
public class SinglyLinkedList<T> implements List<T> {

	private Node<T> head;
	private int size;

	/**
	 * Constructor used to create a SinglyLinkedList starting with a head and
	 * therefore a size of 1
	 * 
	 * @param head
	 */
	public SinglyLinkedList(Node<T> head) {
		this.head = head;
		size = 1;
	}

	/**
	 * Default Constructor used to create an empty SinglyLinkedList
	 */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Inserts an element at the beginning of the SinglyLinkedList.
	 *
	 * @param element - the element to add
	 */
	@Override
	public void insertFirst(T element) {
		// Creates new node
		Node<T> newNode = new Node<T>(element);
		// Places new node at beginning of list
		newNode.next = head;
		head = newNode;
		size++;
	}

	/**
	 * Inserts an element at a specific position in the SinglyLinkedList.
	 *
	 * @param index   - the specified position
	 * @param element - the element to add
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index > size())
	 */
	@Override
	public void insert(int index, T element) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Attempting to insert at element out of bounds");
		} else if (index == 0) {
			insertFirst(element);
		}

		else {
			Node<T> newNode = new Node<T>(element);
			Node<T> beforeNode = getNode(index - 1);
			if (index == size) {
				newNode.next = null;
			} else {
				newNode.next = beforeNode.next;
			}

			beforeNode.next = newNode;
			size++;
		}

	}

	/**
	 * Gets the first element in the SinglyLinkedList.
	 *
	 * @return the first element in the SinglyLinkedList
	 * @throws NoSuchElementException if the SinglyLinkedList is empty
	 */
	@Override
	public T getFirst() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		} else if (head.data == null) {
			throw new NoSuchElementException();
		}

		else {
			return head.data;
		}
	}

	/**
	 * Gets the element at a specific position in the SinglyLinkedList.
	 *
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	@Override
	public T get(int index) throws IndexOutOfBoundsException {
		return getNode(index).data;
	}

	/**
	 * Deletes and returns the first element from the SinglyLinkedList.
	 *
	 * @return the first element
	 * @throws NoSuchElementException if the SinglyLinkedList is empty
	 */
	@Override
	public T deleteFirst() throws NoSuchElementException {
		T returnElement;
		if (this.isEmpty()) {
			throw new NoSuchElementException("Cant delete the first item of an empty array");
		}

		else if (size == 1) {
			returnElement = head.data;
			head = null;
			size--;
		} else {
			returnElement = head.data;
			head = head.next;
			size--;
		}

		return returnElement;
	}

	/**
	 * Deletes and returns the element at a specific position in the
	 * SinglyLinkedList.
	 *
	 * @param index - the specified position
	 * @return the element at the position
	 * @throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 *                                   index >= size())
	 */
	@Override
	public T delete(int index) throws IndexOutOfBoundsException {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		else if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}

		else if (index == 0) {
			return deleteFirst();
		} else if (index == size - 1) {
			T returnVal = getNode(index).data;
			Node<T> before = getNode(index - 1);
			before.next = null;
			size--;
			return returnVal;
		}

		else {
			T returnVal = getNode(index).data;
			Node<T> before = getNode(index - 1);
			Node<T> after = getNode(index + 1);

			before.next = after;
			size--;
			return returnVal;
		}
	}

	/**
	 * Determines the index of the first occurrence of the specified element in the
	 * SinglyLinkedList, or -1 if this SinglyLinkedList does not contain the
	 * element.
	 * 
	 * @param element - the element to search for
	 * @return the index of the first occurrence; -1 if the element is not found
	 */
	@Override
	public int indexOf(T element) {
		for (int i = 0; i < size; i++) {
			if (getNode(i).data.equals(element)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Method used to return the size of the SinglyLinkedList
	 *
	 * @return the number of elements in this list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Returns boolean value true if SinglyLinkedList is empty, false otherwise.
	 *
	 * @return true if this collection contains no elements; false, otherwise
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Removes all of the elements from this SinglyLinkedList
	 */
	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	/**
	 * Generates an array containing all of the elements in this SinglyLinkedList in
	 * proper sequence (from first element to last element).
	 * 
	 * @return an array containing all of the elements in this SinglyLinkedList, in
	 *         order
	 */
	@Override
	public Object[] toArray() {
		if (size <= 0) {
			Object[] emptyArray = new Object[0];
			return emptyArray;
		}

		Object[] oArray = new Object[size];
		for (int i = 0; i < size; i++) {
			oArray[i] = get(i);
		}
		return oArray;
	}

	/**
	 * Returns an iterator used to interface with SinglyLinkedList Collection
	 *
	 * @return Iterator object
	 */
	@Override
	public Iterator<T> iterator() {
		return new linkedIterator();
	}

	/**
	 * Helper method used to get node at a given index
	 * 
	 * @param index location of node being retrieved
	 * @return node at index
	 */
	public Node<T> getNode(int index) throws IndexOutOfBoundsException {

		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("attempting to get the node of an index out of bounds");
		}

		Node<T> temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}

		return temp;
	}

	/**
	 * @author Mike Phelps
	 * 
	 *         Node class used to store data and reference to next node;
	 *
	 * @param <T>
	 */
	private class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
			next = null;
		}
	}

	/**
	 * @author Mike Phelps
	 * 
	 *         Iterator class used to interface with SinglyLinkedList
	 *
	 */
	private class linkedIterator implements Iterator<T> {

		private Node<T> location;
		private boolean removeState;
		private Node<T> beforePrevious;
		private Node<T> previous;

		/**
		 * Constructor for linkedIterator
		 */
		public linkedIterator() {
			location = head;
			removeState = false;
			previous = null;
			beforePrevious = null;

		}

		/**
		 * Returns true if there is a next value to be returned. Otherwise, returns
		 * false.
		 *
		 * @return boolean value T or F depending on if ther is a next value or not.
		 */
		@Override
		public boolean hasNext() {
			return (location != null);
		}

		/**
		 * Returns the next item in the collection. First call of next returns item at
		 * index 0.
		 *
		 * @return T value within collection
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			removeState = true;

			Node<T> temp = location;
			beforePrevious = previous;
			previous = location;
			location = location.next;

			return temp.data;
		}

		/**
		 * Deletes the last returned next value. Can only be called once every call to
		 * next().
		 *
		 */
		public void remove() throws IllegalStateException {
			if (previous == null || !removeState) {
				throw new IllegalStateException();
			}
			if (beforePrevious == null) {
				head = location;
			} else {
				beforePrevious.next = location;
				previous = beforePrevious;
			}
			size--;
			removeState = false;
		}

	}
}
