package lab06;

/**
 * 
 * @author Daniel Kopta
 * 
 * A queue is a first-in, first-out data structure
 * The only modifiers are:
 *  
 * offer (add an item)
 * poll (remove an item)
 *
 * @param <T>
 */
public interface Queue <T> {

	/**
	 * Adds an element to the end of the queue
	 */
	public void offer(T element);
	
	/**
	 * Removes and returns the next element from the queue
	 */
	public T poll();
	
	/**
	 * Returns, but does not remove the next element in the queue
	 */
	public T peek();
	
}
