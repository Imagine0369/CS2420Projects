package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

class ArrayCollectionTest {

	ArrayCollection<Integer> intCol = new ArrayCollection();
	ArrayCollection<String> stringCol = new ArrayCollection();
	Iterator<Integer> itr1 = intCol.iterator();
	Iterator<String> itr2 = stringCol.iterator();

	ArrayCollection<String> stringArrCol = new ArrayCollection<String>();
	ArrayCollection<String> stringArrColDuplicate = new ArrayCollection<String>();

	ArrayCollection<Integer> intArrCol = new ArrayCollection<Integer>();
	ArrayCollection<Integer> intArrColDuplicate = new ArrayCollection<Integer>();
	ArrayCollection<Integer> intArrColUnique = new ArrayCollection<Integer>();

	ArrayCollection<Object> objArrCol = new ArrayCollection<Object>();
	ArrayCollection<Object> objArrColDuplicate = new ArrayCollection<Object>();

	ArrayCollection<String> emptyArrCol = new ArrayCollection<String>();
	ArrayCollection<Integer> emptyArrCol2 = new ArrayCollection<Integer>();
	ArrayCollection<Object> emptyArrCol3 = new ArrayCollection<Object>();

	@BeforeEach
	void setUp() throws Exception {
		intCol.add(0);
		intCol.add(1);
		intCol.add(2);
		intCol.add(3);
		intCol.add(4);
		intCol.add(5);
		intCol.add(6);

		stringCol.add("sam0");
		stringCol.add("sam1");
		stringCol.add("sam2");
		stringCol.add("sam3");
		stringCol.add("sam4");
		stringCol.add("sam5");
		stringCol.add("sam6");

		stringArrCol.add("Mike");
		stringArrCol.add("Seth");
		stringArrCol.add("John");
		stringArrCol.add("Miguel");
		stringArrColDuplicate.add("Mike");
		stringArrColDuplicate.add("Seth");
		stringArrColDuplicate.add("John");
		stringArrColDuplicate.add("Miguel");

		intArrCol.add(2);
		intArrCol.add(5);
		intArrCol.add(1);
		intArrCol.add(-2);
		intArrColDuplicate.add(2);
		intArrColDuplicate.add(5);
		intArrColDuplicate.add(1);
		intArrColDuplicate.add(-2);
		intArrColUnique.add(2);
		intArrColUnique.add(6);
		intArrColUnique.add(1);
		intArrColUnique.add(-2);

		objArrCol.add(5);
		objArrCol.add("Mikes");
		objArrCol.add(2.5);
		objArrCol.add(177F);
		objArrColDuplicate.add(5);
		objArrColDuplicate.add("Mikes");
		objArrColDuplicate.add(2.5);
		objArrColDuplicate.add(177F);

	}

	/****************** Grow Tests Begin ****************/
	@Test
	void testGrowSmallArrayString() {
		assertEquals(10, stringCol.getCap());
		assertEquals(7, stringCol.size());
		stringCol.add("seven");
		stringCol.add("eight");
		assertEquals(9, stringCol.size());
		assertEquals(10, stringCol.getCap());
		stringCol.add("nine");
		assertEquals(10, stringCol.size());
		assertEquals(10, stringCol.getCap());
		stringCol.add("ten");
		assertEquals(11, stringCol.size());
		assertEquals(20, stringCol.getCap());
		stringCol.add("eleven");
		assertEquals(12, stringCol.size());
		assertEquals(20, stringCol.getCap());
		stringCol.add("twelve");
		stringCol.add("13");
		stringCol.add("fourteen");
		stringCol.add("fiveteen");
		stringCol.add("6teen");
		stringCol.add("seven teen");
		stringCol.add("18");
		assertEquals(19, stringCol.size());
		assertEquals(20, stringCol.getCap());
		stringCol.add("nineteen");
		assertEquals(20, stringCol.size());
		assertEquals(20, stringCol.getCap());
		stringCol.add("twenty");
		assertEquals(21, stringCol.size());
		assertEquals(40, stringCol.getCap());
	}

	@Test
	void testGrowSmallArray() {
		assertEquals(10, intCol.getCap());
		assertEquals(7, intCol.size());
		intCol.add(7);
		intCol.add(8);
		assertEquals(9, intCol.size());
		assertEquals(10, intCol.getCap());
		intCol.add(9);
		assertEquals(10, intCol.size());
		assertEquals(10, intCol.getCap());
		intCol.add(10);
		assertEquals(11, intCol.size());
		assertEquals(20, intCol.getCap());
		intCol.add(11);
		assertEquals(12, intCol.size());
		assertEquals(20, intCol.getCap());
		intCol.add(12);
		intCol.add(13);
		intCol.add(14);
		intCol.add(15);
		intCol.add(16);
		intCol.add(17);
		intCol.add(18);
		assertEquals(19, intCol.size());
		assertEquals(20, intCol.getCap());
		intCol.add(19);
		assertEquals(20, intCol.size());
		assertEquals(20, intCol.getCap());
		intCol.add(20);
		assertEquals(21, intCol.size());
		assertEquals(40, intCol.getCap());
	}

	/****************** Grow Tests End ****************/

	/****************** Add Tests Begin ****************/
	@Test
	void testAddNegatives() {
		intCol.add(-2);
		intCol.add(-1);
		intCol.add(-3);
		intCol.add(-4);

		int[] values = new int[11];
		int index = 0;
		int[] testVals = { 0, 1, 2, 3, 4, 5, 6, -2, -1, -3, -4 };

		while (itr1.hasNext()) {
			values[index++] = itr1.next();
		}
		assertArrayEquals(testVals, values);
	}

	@Test
	void testAddStrings() {

		String[] values = new String[11];
		int index = 0;
		String[] testVals = { "sam0", "sam1", "sam2", "sam3", "sam4", "sam5", "sam6", "seven", "zero", "ate", "elves" };

		stringCol.add("seven");
		stringCol.add("zero");
		stringCol.add("ate");
		stringCol.add("elves");
		while (itr2.hasNext()) {
			values[index++] = itr2.next();
		}
		assertEquals(values.length, testVals.length );
		assertArrayEquals(testVals, values);
	}

	/****************** Add Tests End ****************/

	/****************** AddAll Tests Begin ****************/
	@Test
	void testAddAllStringOnEmpty() {
		assertEquals(0,emptyArrCol.size());
		emptyArrCol.addAll(stringArrCol);
		
		assertArrayEquals(stringArrColDuplicate.toArray() , emptyArrCol.toArray());
	}
	
	@Test
	void testAddAllIntegergOnEmpty() {
		assertEquals(0,emptyArrCol2.size());
		emptyArrCol2.addAll(intArrCol);
		
		assertArrayEquals(intArrColDuplicate.toArray() , emptyArrCol2.toArray());
	}
	
	@Test
	void testAddAllObjectOnEmpty() {
		assertEquals(0,emptyArrCol3.size());
		emptyArrCol3.addAll(objArrCol);
		
		assertArrayEquals(objArrColDuplicate.toArray() , emptyArrCol3.toArray());
	}
	
	@Test
	void testAddAllWithSameArr() {
		assertFalse(stringArrCol.addAll(stringArrColDuplicate) );
	}
	
	@Test
	void testAddAllTrueStatement() {
		assertTrue(objArrCol.addAll(stringArrColDuplicate) );
	}
	
	@Test
	void testAddAllCommon() {
		objArrCol.addAll(stringArrColDuplicate);
		
		Object[] values = new Object[8];
		int index = 0;
		Iterator<Object> itr = objArrColDuplicate.iterator();
		
		while (itr.hasNext()) {
			values[index++] = itr.next();
		}
		Iterator<String> itr1 = stringArrCol.iterator();
		
		while (itr1.hasNext()) {
			values[index++] = itr1.next();
		}
		
		assertArrayEquals(values, objArrCol.toArray());
	}
	/****************** AddAll Tests End ****************/

	// ------------------------- clear method tests start
	// -------------------------------
	@Test
	void testClearMethodStringCollection() {
		stringArrCol.clear();
		assertEquals(0, stringArrCol.size());
	}

	@Test
	void testClearMethodIntegerCollection() {
		intArrCol.clear();
		assertEquals(0, intArrCol.size());
	}

	@Test
	void testClearMethodObjectMixCollection() {
		objArrCol.clear();
		assertEquals(0, objArrCol.size());
	}

//------------------------- clear method tests end-------------------------------	

//------------------------- contains method tests start--------------------------

	@Test
	void testContainsStringCollectionTrue() {
		String test = "Miguel";
		assertTrue(stringArrCol.contains(test));
	}

	@Test
	void testContainsStringCollectionFalse() {
		String test = "Sarah";
		assertFalse(stringArrCol.contains(test));
	}

	@Test
	void testIncompatibleTypeStringCollection() {
		assertFalse(stringArrCol.contains(9));
	}

	@Test
	void testContainsIntegerCollectionTrue() {
		assertTrue(intArrCol.contains(5));
	}

	@Test
	void testContainsIntegerCollectionFalse() {
		assertFalse(intArrCol.contains(99));
	}

	@Test
	void testIncompatibleTypeIntegerCollection() {
		assertFalse(intArrCol.contains("Mark Twain"));
	}

	@Test
	void testContainsMixedObjectCollectionTrue() { // FLAG*********
		assertTrue(objArrCol.contains(2.5));
	}

	@Test
	void testContainsMixedObjectCollectionFalse() {
		assertFalse(objArrCol.contains(1000));
	}
//------------------------- contains method tests end-------------------------

//------------------------- containsAll tests start---------------------------

	@Test
	void testContainsAllTrueStringCollection() {
		assertTrue(stringArrCol.containsAll(stringArrColDuplicate));
	}

	@Test
	void testContainsAllFalseStringCollection() {
		assertFalse(stringArrCol.containsAll(objArrCol));
	}

	@Test
	void testContainsAllTrueIntegerCollection() {
		assertTrue(intArrCol.containsAll(intArrColDuplicate));
	}

	@Test
	void testContainsAllFalseIntegerCollection() {
		assertFalse(intArrCol.containsAll(intArrColUnique));
	}

	@Test
	void testContainsAllTrueObjectCollection() {
		assertTrue(objArrCol.containsAll(objArrColDuplicate));
	}

	@Test
	void testContainsAllFalseObjectCollection() {
		assertFalse(objArrCol.containsAll(intArrCol));
	}

	// ------------------------- contains method tests end---------------------

	// ------------------------- isEmpty tests start---------------------------

	@Test
	void testIsEmptyTrue() {
		assertTrue(emptyArrCol.isEmpty());
	}

	@Test
	void testIsEmptyFalseStringCol() {
		assertFalse(stringArrCol.isEmpty());
	}

	@Test
	void testIsEmptyFalseIntegerCol() {
		assertFalse(intArrCol.isEmpty());
	}

	@Test
	void testIsEmptyFalseObjectCol() {
		assertFalse(objArrCol.isEmpty());
	}
//------------------------- isEmpty method tests end---------------------

//------------------------- iterator tests start-------------------------

	@Test
	void testIteratorCreationAndNext() {
		Iterator itr = stringArrCol.iterator();
		assertEquals(itr.next(), "Mike");
		assertEquals(itr.next(), "Seth");
		assertEquals(itr.next(), "John");
		assertEquals(itr.next(), "Miguel");
		assertThrows(NoSuchElementException.class, () -> {
			itr.next();
		});

	}

	@Test
	void testIteratorHasNext() {
		Iterator itr = intArrCol.iterator();
		for (int i = 0; i < intArrCol.size(); i++) {
			itr.next();
		}
		assertFalse(itr.hasNext());
	}

	@Test
	void testIndexAfterRemoval() {
		Iterator itr = stringArrCol.iterator();
		itr.next();
		itr.next();
		itr.next();
		int currentIndex = 3;
		// Should remove 3rd item
		itr.remove();
		// index should now be 2 and the last item (of Array Collection of 4 items)
		// should be called with itr.next
		assertEquals(itr.next(), "Miguel");

	}

	@Test
	void testOrderAfterRemoval() {
		Iterator itr = stringArrCol.iterator();
		// Initial order of StringCollection
		String initialOrder = "[Mike, Seth, John, Miguel]";
		// Check that initial order matches stringArrCol actual initial order
		assertTrue(Arrays.deepToString(stringArrCol.toArray()).equals(initialOrder));

		itr.next();
		itr.next();
		// Remove the second item at index 1 (Seth)
		itr.remove();
		// Check that order displays as it should
		String orderAfterRemove = "[Mike, John, Miguel]";
		assertTrue(Arrays.deepToString(stringArrCol.toArray()).equals(orderAfterRemove));
	}

	@Test
	void testThrowsForConsecutiveRemove() {
		Iterator itr = stringArrCol.iterator();
		itr.next();
		itr.remove();
		assertThrows(IllegalStateException.class, () -> {
			itr.remove();
		});
	}

	@Test
	void testThrowsForRemoveAtBeginning() {
		Iterator itr = stringArrCol.iterator();
		assertThrows(IllegalStateException.class, () -> {
			itr.remove();
		});
	}

//------------------------- iterator tests end-------------------------

//------------------------- remove tests start---------------------------

	@Test
	void testRemoveStringCollection() {
		// Check to make sure collection contains Seth
		if (stringArrCol.contains("Seth")) {
			// Now Remove Seth
			stringArrCol.remove("Seth");
			// collection should now no longer contain seth
			assertFalse(stringArrCol.contains("Seth"));
		} else {
			fail();
		}
	}

	@Test
	void testRemoveIntegerCollectionItemNotContained() {
		// If collection does not have Integer
		if (!intArrCol.contains(30)) {
			// Try and remove it, it should fail
			assertFalse(intArrCol.remove(30));
		} else {
			fail();
		}
	}

	@Test
	void testIntegerCollectionSizeAfterRemoval() {
		int initialSize = intArrCol.size();
		intArrCol.remove(5);
		assertTrue((intArrCol.size()) == (initialSize - 1));
	}

	@Test
	void testRemoveIntegerCollection() {
		// Check to make sure collection contains -2
		if (intArrCol.contains(-2)) {
			// Now Remove -2
			intArrCol.remove(-2);
			// collection should now no longer contain -2
			assertFalse(intArrCol.contains(-2));
		} else {
			fail();
		}
	}

	@Test
	void testStringCollectionSizeAfterRemoval() {
		int initialSize = intArrCol.size();
		intArrCol.remove(1);
		assertTrue((intArrCol.size()) == (initialSize - 1));
	}

//------------------------- remove tests end---------------------------
	
//------------------------- removeAll tests start---------------------------
	
	@Test
	void testRemoveAllEmpties() {
		assertFalse( stringArrCol.removeAll(emptyArrCol) );
		assertFalse( intArrCol.removeAll(emptyArrCol2) );
		assertFalse( objArrCol.removeAll(emptyArrCol3) );
	}
	
	@Test
	void testRemoveAllSingular() {
		emptyArrCol.add("Seth");
		emptyArrCol2.add(5);
		emptyArrCol3.add(177F);
		assertTrue( stringArrCol.removeAll(emptyArrCol) );
		assertTrue( intArrCol.removeAll(emptyArrCol2) );
		assertTrue( objArrCol.removeAll(emptyArrCol3) );
		
		String[] values = new String[3];
		int index = 0;
		String[] testVals = {"Mike","John","Miguel"};
		
		Iterator<String> itr = stringArrCol.iterator();
		
		while (itr.hasNext()) {
			values[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, values);
		
		int[] values1 = new int[3];
		index = 0;
		int[] testVals1 = {2,1,-2};
		
		Iterator<Integer> itr1 = intArrCol.iterator();
		
		while (itr1.hasNext()) {
			values1[index++] = itr1.next();
		}
		
		assertArrayEquals(testVals1, values1);
		
	}
	
	@Test
	void testRemoveAllDouble() {
		emptyArrCol.add("Seth");
		emptyArrCol.add("Mike");
		emptyArrCol2.add(2);
		emptyArrCol2.add(1);
		emptyArrCol3.add(177F);
		emptyArrCol3.add(5);
		assertTrue( stringArrCol.removeAll(emptyArrCol) );
		assertTrue( intArrCol.removeAll(emptyArrCol2) );
		assertTrue( objArrCol.removeAll(emptyArrCol3) );
		
		String[] values = new String[2];
		int index = 0;
		String[] testVals = {"John","Miguel"};
		
		Iterator<String> itr = stringArrCol.iterator();
		
		while (itr.hasNext()) {
			values[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, values);
		
		int[] values1 = new int[2];
		index = 0;
		int[] testVals1 = {5,-2};
		
		Iterator<Integer> itr1 = intArrCol.iterator();
		
		while (itr1.hasNext()) {
			values1[index++] = itr1.next();
		}
		
		assertArrayEquals(testVals1, values1);
		
	}
	
	@Test
	void testCompleteRemoveAll() {
		assertTrue( stringArrCol.removeAll(stringArrColDuplicate) );
		assertTrue( intArrCol.removeAll(intArrColDuplicate) );
		assertTrue( objArrCol.removeAll(objArrColDuplicate) );
		
		assertTrue(stringArrCol.isEmpty());
		assertTrue(intArrCol.isEmpty());
		assertTrue(objArrCol.isEmpty());
	}
	
//------------------------- removeALL tests end---------------------------
	
//------------------------- retainAll tests start---------------------------
	
	@Test
	void testRetainAllEmpties() {
		assertEquals(0,emptyArrCol.size());
		assertTrue( stringArrCol.retainAll(emptyArrCol) );
		assertTrue( intArrCol.retainAll(emptyArrCol2) );
		assertTrue( objArrCol.retainAll(emptyArrCol3) );
		
		assertTrue( stringArrCol.isEmpty() );
		assertTrue( intArrCol.isEmpty() );
		assertTrue( objArrCol.isEmpty() );
	}
		
	@Test
	void testRetainAllSingular() {
		emptyArrCol.add("Seth");
		emptyArrCol2.add(5);
		emptyArrCol3.add(177F);
		assertTrue( stringArrCol.retainAll(emptyArrCol) );
		assertTrue( intArrCol.retainAll(emptyArrCol2) );
		assertTrue( objArrCol.retainAll(emptyArrCol3) );
		
		String[] values = new String[1];
		int index = 0;
		String[] testVals = {"Seth"};
		
		Iterator<String> itr = stringArrCol.iterator();
		
		while (itr.hasNext()) {
			values[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, values);
		
		int[] values1 = new int[1];
		index = 0;
		int[] testVals1 = {5};
		
		Iterator<Integer> itr1 = intArrCol.iterator();
		
		while (itr1.hasNext()) {
			values1[index++] = itr1.next();
		}
		
		assertArrayEquals(testVals1, values1);
		
	}
	
	@Test
	void testRetainAllDouble() {
		emptyArrCol.add("Seth");
		emptyArrCol.add("Mike");
		emptyArrCol2.add(1);
		emptyArrCol2.add(2);
		emptyArrCol3.add(177F);
		emptyArrCol3.add(5);
		assertTrue( stringArrCol.retainAll(emptyArrCol) );
		assertTrue( intArrCol.retainAll(emptyArrCol2) );
		assertTrue( objArrCol.retainAll(emptyArrCol3) );
		
		String[] values = new String[2];
		int index = 0;
		String[] testVals = {"Mike","Seth"};
		
		Iterator<String> itr = stringArrCol.iterator();
		
		while (itr.hasNext()) {
			values[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, values);
		
		int[] values1 = new int[2];
		index = 0;
		int[] testVals1 = {2,1};
		
		Iterator<Integer> itr1 = intArrCol.iterator();
		
		while (itr1.hasNext()) {
			values1[index++] = itr1.next();
		}
		
		assertArrayEquals(testVals1, values1);
		
	}
		
	@Test
	void testCompleteRetainAll() {
		assertFalse( stringArrCol.retainAll(stringArrColDuplicate) );
		assertFalse( intArrCol.retainAll(intArrColDuplicate) );
		assertFalse( objArrCol.retainAll(objArrColDuplicate) );
		
		assertFalse(stringArrCol.isEmpty());
		assertTrue(intArrCol.equals(intArrCol));
		assertTrue( intArrCol.equals(intArrCol) );
	}
		
//------------------------- retainAll tests end---------------------------

//------------------------- size tests start-------------------------

	@Test
	void testSizeStringCollection() {
		assertEquals(stringArrCol.size(), 4);
	}

	@Test
	void sizeEmptyCollection() {
		assertEquals(emptyArrCol.size(), 0);
	}

	@Test
	void testSizeAfterAdd() {
		int initialSize = stringArrCol.size();
		stringArrCol.add("ADD ME");
		assertEquals(initialSize + 1, stringArrCol.size());
	}

	@Test
	void testSizeAfterMultipleRemove() {
		int initialSize = stringArrCol.size();
		stringArrCol.remove("Mike");
		stringArrCol.remove("Seth");
		assertEquals(initialSize - 2, stringArrCol.size());
	}

//------------------------- size tests end --------------------------
	
//------------------------- toArray tests start-------------------------
	@Test
	void testToArrayEmpty() {
		assertArrayEquals(new Object[0], emptyArrCol.toArray() );
		assertArrayEquals(new Object[0], emptyArrCol2.toArray() );
		assertArrayEquals(new Object[0], emptyArrCol3.toArray() );
	}
	
	@Test
	void testToArrayString() {
		Object[] testVals = new Object[4];
		int index = 0;
		
		Iterator<String> itr = stringArrCol.iterator();
		
		while (itr.hasNext()) {
			testVals[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, stringArrCol.toArray() );
	}
	
	@Test 
	void testToArrayInt() {
		Object[] testVals = new Object[4];
		int index = 0;
		
		Iterator<Integer> itr = intArrCol.iterator();
		
		while (itr.hasNext()) {
			testVals[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, intArrCol.toArray() );
	}
	
	@Test
	void testToArrayObject() {
		Object[] testVals = new Object[4];
		int index = 0;
		
		Iterator<Object> itr = objArrCol.iterator();
		
		while (itr.hasNext()) {
			testVals[index++] = itr.next();
		}
		
		assertArrayEquals(testVals, objArrCol.toArray() );
	}	
//------------------------- toArray tests start-------------------------
	

//------------------------- toSortedArrayList tests start--------------	

	/**
	 * Comparator that defines an ordering among integers. Orders largest to
	 * smallest
	 */
	protected class OrderByInteger implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
	}
	
	protected class OrderByAlpha implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

	@Test
	void testToSortedListCommonInt() {
		intArrCol.remove(-2);
		intArrCol.add(3);
		String initialOrder = "[2, 5, 1, 3]";
		assertEquals(Arrays.toString(intArrCol.toArray()), initialOrder);

		ArrayList<Integer> sortedArrayList = new ArrayList<Integer>();

		Comparator integerCompare = new OrderByInteger();
		sortedArrayList = intArrCol.toSortedList(integerCompare);
		String sortedOrder = "[1, 2, 3, 5]";

		assertTrue(sortedArrayList.toString().equals(sortedOrder));
	}
	
	@Test
	void testToSortedListNegatives() {
		Object[] initialOrder = {2, 5, 1, -2, 0, -5};
		intArrCol.add(0);
		intArrCol.add(-5);
		
		assertArrayEquals(initialOrder, intArrCol.toArray() );

		Comparator cmp = new OrderByInteger();
		
		Object[] sortOrder = {-5, -2, 0, 1, 2, 5};

		assertArrayEquals(sortOrder, intArrCol.toSortedList(cmp).toArray());
	}
	
	@Test
	void testToSortedListReturnType() {
		ArrayList<Integer> sortOrder = new ArrayList<Integer>();
		ArrayList<String> sortOrderString = new ArrayList<String>();
		sortOrder.add(1);
		sortOrderString.add("jones");
		Comparator cmp = new OrderByInteger();
		Comparator cmpS = new OrderByAlpha();
		
		assertEquals(sortOrderString.get(0).getClass(), stringArrCol.toSortedList(cmpS).get(0).getClass() );
		
		assertEquals(sortOrder.get(0).getClass(), intArrCol.toSortedList(cmp).get(0).getClass() );
	}
	
	@Test
	void testToSortedListString() {
		ArrayList<Integer> sortOrder = new ArrayList<Integer>();
		Object[] sortOrderString = {"John", "Miguel", "Mike", "Seth"};

		Comparator cmpS = new OrderByAlpha();
		
		assertArrayEquals(sortOrderString, stringArrCol.toSortedList(cmpS).toArray() );
	
	}
	
	@Test
	void testToSortedListEMpty() {
		ArrayList<Integer> sortOrder = new ArrayList<Integer>();
		Object[] sortOrderString = new Object[0];

		Comparator cmpS = new OrderByAlpha();
		
		assertArrayEquals(sortOrderString, emptyArrCol.toSortedList(cmpS).toArray() );
	
	}

//------------------------- toSortedArrayList tests end--------------	


}