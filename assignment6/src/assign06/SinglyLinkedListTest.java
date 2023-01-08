package assign06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class built to test SinglyLinkedList and all its methods
 * 
 * @author Mike Phelps
 *
 */
class SinglyLinkedListTest {
	Random rand = new Random();
	private SinglyLinkedList<Integer> emptyLL;
	private SinglyLinkedList<Integer> valuesLL;

	@BeforeEach
	void setUp() {
		emptyLL = new SinglyLinkedList<Integer>();
		valuesLL = new SinglyLinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			valuesLL.insert(i, rand.nextInt(10));
		}

	}

//----------------------InsertFirst Tests Start----------------------------------
	@Test
	public void testInsertFirstEmpty() {
		emptyLL.insertFirst(-1);
		assertEquals(emptyLL.get(0), -1);
	}

	@Test
	public void testInsertFirstFilled() {
		valuesLL.insertFirst(-2);
		assertEquals(valuesLL.get(0), -2);
	}

//----------------------InsertFirst Tests End------------------------------------

//----------------------Insert Tests Start---------------------------------------

	@Test
	public void testInsertEmpty() {
		emptyLL.insert(0, -2);
		assertEquals(emptyLL.get(0), -2);
	}

	@Test
	public void testInsertFilled() {
		valuesLL.insert(6, -4);
		assertEquals(valuesLL.get(6), -4);
	}

	@Test
	public void testInsertExceptionEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyLL.insert(5, -1);
		});
	}

	@Test
	public void testInsertExceptionValues() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			valuesLL.insert(100, -1);
		});
	}

//----------------------Insert Tests End-----------------------------------------

//----------------------GetFirst Tests Starts------------------------------------

	@Test
	public void getFirstFilled() {
		valuesLL.insert(0, -9);
		assertEquals(-9, valuesLL.getFirst());
	}

	@Test
	public void getFirstEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyLL.getFirst();
		});
	}

//----------------------GetFirst Tests End--------------------------------------

//----------------------Get Tests Starts----------------------------------------

	@Test
	public void getEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyLL.get(5);
		});
	}

	@Test
	public void getFilled() {
		valuesLL.insert(3, -8);
		assertEquals(-8, valuesLL.get(3));
	}

//----------------------Get Tests End-------------------------------------------

//----------------------DeleteFirst Tests Starts--------------------------------

	@Test
	public void deleteFirstFilled() {
		valuesLL.insertFirst(-7);
		valuesLL.insertFirst(-9);

		valuesLL.deleteFirst();

		assertEquals(-7, valuesLL.getFirst());
	}

	@Test
	public void deleteFirstEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyLL.deleteFirst();
		});
	}

//----------------------DeleteFirst Tests End-----------------------------------

//----------------------Delete Tests Starts-------------------------------------

	@Test
	public void deleteFilled() {
		valuesLL.insert(5, -2);
		valuesLL.insert(6, -7);

		valuesLL.delete(5);

		assertEquals(valuesLL.get(5), -7);
	}

	@Test
	public void deleteEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyLL.delete(4);
		});
	}

//----------------------Delete Tests End---------------------------------------	

//----------------------IndexOf Tests Starts-----------------------------------

	@Test
	public void IndexOfFilled() {
		valuesLL.insert(9, -9);

		assertEquals(9, valuesLL.indexOf(-9));
	}

	@Test
	public void IndexOfEmpty() {
		assertEquals(-1, emptyLL.indexOf(7));
	}

	@Test
	public void IndexOfFilledDoesNotExist() {
		assertEquals(-1, valuesLL.indexOf(-11));
	}

//----------------------IndexOf Tests End-------------------------------------

//----------------------Size Tests Start--------------------------------------

	@Test
	public void TestSizeEmpty() {
		assertEquals(0, emptyLL.size());
	}

	@Test
	public void TestSizeFilled() {
		assertEquals(10, valuesLL.size());
	}

	@Test
	public void TestSizeAfterInsert() {
		valuesLL.insert(3, -3);

		assertEquals(11, valuesLL.size());
	}

	@Test
	public void TestSizeAfterRemove() {
		valuesLL.delete(2);

		assertEquals(9, valuesLL.size());
	}

//----------------------Size Tests End-------------------------------------

//----------------------IsEmpty Tests Start--------------------------------

	@Test
	public void TestEmptyIsEmpty() {
		assertTrue(emptyLL.isEmpty());
	}

	@Test
	public void TestFilledIsEmpty() {
		assertFalse(valuesLL.isEmpty());
	}

	@Test
	public void TestIsEmptyAfterDeletion() {
		emptyLL.insertFirst(7);
		emptyLL.deleteFirst();

		assertTrue(emptyLL.isEmpty());
	}

	@Test
	public void TestIsEmptyAfterAdd() {
		assertTrue(emptyLL.isEmpty());

		emptyLL.insert(0, -2);

		assertFalse(emptyLL.isEmpty());
	}
//----------------------IsEmpty Tests End-----------------------------------

//----------------------Clear Tests Start-----------------------------------
	@Test
	public void TestClearOnValues() {
		assertFalse(valuesLL.isEmpty());
		valuesLL.clear();

		assertTrue(valuesLL.isEmpty());
		assertThrows(NoSuchElementException.class, () -> {
			valuesLL.getFirst();
		});
	}

	@Test
	public void TestClearOnEmpty() {
		assertTrue(emptyLL.isEmpty());
		emptyLL.clear();
		assertTrue(emptyLL.isEmpty());
	}

//----------------------Clear Tests End-------------------------------------

//----------------------ToArray Tests Start---------------------------------

	@Test
	public void TestToArrayFilled() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);

		assertEquals(Arrays.toString(emptyLL.toArray()), "[1, 2, 3, 4]");
	}

	@Test
	public void TestToArrayEmpty() {
		assertEquals(Arrays.toString(emptyLL.toArray()), "[]");
	}

	@Test
	public void TestToArrayAfterAdd() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		assertEquals(Arrays.toString(emptyLL.toArray()), "[1, 2, 3, 4]");

		emptyLL.insert(2, -7);
		assertEquals(Arrays.toString(emptyLL.toArray()), "[1, 2, -7, 3, 4]");

	}

	@Test
	public void TestToArrayAfterRemove() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		assertEquals(Arrays.toString(emptyLL.toArray()), "[1, 2, 3, 4]");

		emptyLL.delete(1);

		assertEquals(Arrays.toString(emptyLL.toArray()), "[1, 3, 4]");
	}

//----------------------ToArray Tests End------------------------------------

//----------------------Iterator Tests Start---------------------------------
	@Test
	void testIteratorCreationAndNext() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		assertEquals(itr.next(), 1);
		assertEquals(itr.next(), 2);
		assertEquals(itr.next(), 3);
		assertEquals(itr.next(), 4);
		assertEquals(itr.next(), 5);
		assertThrows(NoSuchElementException.class, () -> {
			itr.next();
		});

	}

	@Test
	void testIteratorHasNext() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		for (int i = 0; i < emptyLL.size(); i++) {
			itr.next();
		}
		assertFalse(itr.hasNext());
	}

	@Test
	void testIndexAfterRemoval() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		itr.next();
		itr.next();
		itr.next();
		// currentIndex = 3;
		// Should remove 3rd item
		itr.remove();

		assertEquals(itr.next(), 4);

	}

	@Test
	void testOrderAfterRemoval() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		// Initial order of StringCollection
		String initialOrder = "[1, 2, 3, 4, 5]";
		// Check that initial order matches stringArrCol actual initial order
		assertEquals(Arrays.toString(emptyLL.toArray()), initialOrder);

		itr.next();
		itr.next();
		// Remove the second item at index 1
		itr.remove();
		// Check that order displays as it should
		String orderAfterRemove = "[1, 3, 4, 5]";
		assertEquals(Arrays.toString(emptyLL.toArray()), orderAfterRemove);
	}

	@Test
	void testThrowsForConsecutiveRemove() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		itr.next();
		itr.remove();
		assertThrows(IllegalStateException.class, () -> {
			itr.remove();
		});
	}

	@Test
	void testThrowsForRemoveAtBeginning() {
		emptyLL.insert(0, 1);
		emptyLL.insert(1, 2);
		emptyLL.insert(2, 3);
		emptyLL.insert(3, 4);
		emptyLL.insert(4, 5);
		Iterator<Integer> itr = emptyLL.iterator();
		assertThrows(IllegalStateException.class, () -> {
			itr.remove();
		});

	}

//----------------------Iterator Tests End---------------------------------
}
