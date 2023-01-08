package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and SETH POLEVOI and MIKE PHELPS
 * Implements the Collection interface using an array as storage.
 * The array must grow as needed.
 * An ArrayCollection can not contain duplicates.
 * All methods should be implemented as defined by the Java API, unless otherwise specified.
 * 
 * It is your job to fill in the missing implementations and to comment this class. 
 * Every method should have comments (Javadoc-style prefered). 
 * The comments should at least indicate what the method does, 
 * what the arguments mean, and what the returned value is. 
 * It should specify any special cases that the method
 * handles. Any code that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	private T data[]; // Storage for the items in the collection
	private int size; // Keep track of how many items this collection holds

	// There is no clean way to convert between T and Object, so we suppress the warning.
	@SuppressWarnings("unchecked")  
	public ArrayCollection()
	{
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper method specific to ArrayCollection
	 * Doubles the size of the data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow()
	{
		// Initialize new larger array
		T newData[] = (T[]) new Object[ size*2 ];
		
		//copy data from smaller array to larger array
		for (int index = 0; index < size; index++) {
			newData[index] = data[index];
		}
		
		//sets this.data reference to reference the larger data
		data = newData;
	}
	
	/**
	 * This method was used to check and test the grow and size methods
	 * 
	 * @return int value of capacity of the ArrayCollection
	 */
	public int getCap() {
		return data.length;
	}


	/**
	 * Adds a given value to the first available spot(the end) 
	 * of an ArrayCollection
	 * 
	 * @return false if value is already in ArrayCollection, 
	 * 		   true if value was added
	 */
	public boolean add(T arg0) {
		//search if already contains value
		if( contains(arg0) ) {
			return false;
		}
		
		//check if capacity is large enough
		if (size >= data.length) {
			//if capacity is too small, grows the ArrayCollection
			grow();
		}
		
		//add value to first available spot and update size
		data[size++] = arg0;

		//value was added
		return true;
	}

	/**
	 * Takes in an ArrayCollection and adds each value that is not 
	 * already in the instance ArrayCollection. 
	 * 
	 * @input arg0 ArrayCollection with values that you want to add 
	 * 			other ArrayCollection
	 * @return true if any items were added
	 * 			false if no items were added
	 */
	public boolean addAll(Collection<? extends T> arg0) {
		//save size to check if anything was added
		int initialSize = size;
		
		//add every value from input
		for(T value : arg0) {
			add(value);
		}
		
		//return true if items were added
		return (initialSize < size);
	}

	/**
	 * Clears all values from ArrayCollection.
	 * Makes ArrayCollection empty
	 *
	 */
	public void clear() {
		size = 0;
	}

	/**
	 * Method tells you if an input value/object is 
	 * in our ArrayCollection
	 * 
	 * @return	false if value is not in our ArrayCollection
	 * 			true if value is value is in our ArrayCollection
	 *
	 */
	public boolean contains(Object arg0) {
		//check if empty
		if(this.size < 1)
			return false;
		
		//check if arg0 is in the collection
		for (int index = 0; index < size; index++) {
			if(data[index].equals(arg0))
				return true;
		}
		
		//if arg0 is not in our collection
		return false;
	}

	
	/**
	 * Method returns true if all the values in the input 
	 * ArrayCollection are in the testing ArrayCollection
	 * 
	 * @params ArrayCollection with values to compare
	 * @returns bool if all the values are in the array or nott
	 *
	 */
	public boolean containsAll(Collection<?> arg0) {
		//for all values in arg0
		for(Object val: arg0) {
			//if this ArrayCollection does not contain a value in arg0
			if(!contains(val)) {
				return false;
			}
		}
		
		//all values from arg0 are in the ArrayCollection
		return true;
	} 

	/**
	 * Method check if the ArrayCollection has any data
	 * 
	 * @returns boolean true if it is empty
	 *
	 */
	public boolean isEmpty() {
		return (size < 1);
	}

	public Iterator<T> iterator() {
		
		return new ArrayCollectionIterator(); 
	}

	/**
	 * Removes a given value from an ArrayCollection
	 * 
	 * @returns false if no value was removed
	 * 			true if a value was removed
	 *
	 */
	public boolean remove(Object arg0) {
		//initialize index of item to remove
		int indexLocation=0;
		
		//if ArrayCollection doesn't have value, return false
		if(!contains(arg0)) {
			return false;
		}
		//arrayCollection has the value
		
		//find the index of value
		for(int i = 0; i < size; i++) {
			if(data[i].equals(arg0)) {
				indexLocation = i;
				break;
			}
		}
		
		//shift all elements after arg0 up one element to erase arg0
		for(int i = indexLocation; i < size; i++) {
			data[i] = data[i + 1];
		}
		
		//update size
		size --;
		return true;
	}

	/**
	 * Removes all items from our ArrayCollection that are also in
	 * the input ArrayCollection
	 * 
	 * @param	Items you want to remove from our ArrayCollection
	 *
	 * @returns false if no value was removed
	 * 			true if a value was removed	
	 */
	public boolean removeAll(Collection<?> arg0) {
		//initialize counter to see how many times something was removed
		int counter = 0;
		
		//remove each element of arg0
		for(Object val : arg0) {
			if(remove(val)) {
				counter++;
			}
		}
		
		//if any items were removed
		if(counter > 0) {
			return true;
		}
		
		//if no items were removes
		return false;
	}

	/**
	 * Removes all items from our ArrayCollection that are not also in
	 * the input ArrayCollection 
	 * 
	 * @param	Items you want to keep in our ArrayCollection
	 *
	 * @returns false if no values were removed
	 * 			true if any values were removed	
	 *
	 */
	public boolean retainAll(Collection<?> arg0) {
		//create an iterator
		Iterator<T> itr = iterator();
		
		//save size of ArrayCollection before retaining
		int oldSize = size;
		
		//go through all elements in our collection
		while ( itr.hasNext() ) {
			
			//remove element if the current element is not also an element in arg0
			 if ( arg0.contains(itr.next()) != true ) {
				 itr.remove();
			 }
			 
		}
		//return true if items removed
		return (size < oldSize);
	}

	/**
	 * Returns size of arrayCollection
	 *
	 */
	public int size() {
		return size;
	}

	/**
	 * turns our ArrayCollection into an Object Array
	 *
	 */
	public Object[] toArray() {
		//initialize an object array the same size as our arrayCollection
		Object[] arrayCopy = new Object[size];
		
		//add each value to the object array
		for(int index = 0; index < size; index++) {
			arrayCopy[index] = data[index];
		}
		
		//return object array
		return arrayCopy;
	}

	/* 
	 * Don't implement this method (unless you want to).
	 * It must be here to complete the Collection interface.
	 * We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {
		return null;
	}



	/*
     
	*/
	/**
	 * Sorting method specific to ArrayCollection - not part of the Collection interface.
     	Must implement a selection sort (see Assignment 2 for code).
     	Must not modify this ArrayCollection.
	 * @param cmp - the comparator that defines item ordering
	 * @return - the sorted list
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp)
	{
		ArrayList<T> sortedAList = new ArrayList<T>();
		
		for(int i = 0; i < size; i++) {
			sortedAList.add(data[i]);
		}
		
		for(int i = 0; i < size - 1; i++) {
			int j, minIndex;
			for(j = i + 1, minIndex = i; j < size; j++)
				if(cmp.compare(sortedAList.get(j), sortedAList.get(minIndex)) < 0)
					minIndex = j;
			T temp = sortedAList.get(i);
			sortedAList.set(i, sortedAList.get(minIndex));
			sortedAList.set(minIndex, temp);
		}
		return sortedAList;
	}


	/**
	 * 
	 * @author  SETH POLEVOI and MIKE PHELPS
	 * Describe your ArrayCollectionIterator class here.
	 *
	 */
	private class ArrayCollectionIterator implements Iterator<T>
	{
		//global variable
		int location;
		boolean removeState;
		
		public ArrayCollectionIterator()
		{
			location = 0; 		//keeps track of our location in ArrayCollection
			removeState = false;//keeps track if item was recently returned
		}

		public boolean hasNext() {
			return (location < size);
		}

		/**
		 * Returns the next value of in our ArrayCollection
		 * 
		 * @throws an exception if there is no next value
		 * 
		 * @returns the next value in the ArrayCollection
		 *
		 */
		public T next() throws NoSuchElementException{
			//if no next value is available
			if (location >= size)
				throw new NoSuchElementException();
			
			removeState = true;
			//return element and update location
			return data[location++];
		}

		/**
		 * Removes value that was most recently sent out
		 * 
		 * @throws exception if removed is used twice in a row
		 *
		 */
		public void remove()  throws IllegalStateException{
			if( removeState ) {
				//removes element from ArrayCollection
				ArrayCollection.this.remove( data[location-1] );
				//update location
				location--;
				removeState = false;
			} else //if remove() is called twice in a row
				throw new IllegalStateException();
			
		}

	}

}