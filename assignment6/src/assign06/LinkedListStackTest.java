package assign06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class built to test LinkedListStack and all its methods
 * 
 * @author Mike Phelps
 *
 */
class LinkedListStackTest {
	Random rand = new Random();
	private LinkedListStack<Integer> emptyLL;
	private LinkedListStack<Integer> valuesLL;

	@BeforeEach
	void setUp() {
		emptyLL = new LinkedListStack<Integer>();
		valuesLL = new LinkedListStack<Integer>();
		for (int i = 0; i < 10; i++) {
			valuesLL.push(rand.nextInt(10));
		}
	}

//-------------------------Clear Tests Start------------------------------	
	@Test
	void ClearOnFilled() {
		assertFalse(valuesLL.isEmpty());
		valuesLL.clear();
		assertTrue(valuesLL.isEmpty());
	}

	@Test
	public void TestClearOnEmpty() {
		assertTrue(emptyLL.isEmpty());
		emptyLL.clear();
		assertTrue(emptyLL.isEmpty());
	}

//-------------------------Clear Tests Start------------------------------

//-------------------------IsEmpty Test Start-----------------------------

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
		emptyLL.push(7);
		emptyLL.pop();

		assertTrue(emptyLL.isEmpty());
	}

	@Test
	public void TestIsEmptyAfterAdd() {
		assertTrue(emptyLL.isEmpty());

		emptyLL.push(-2);

		assertFalse(emptyLL.isEmpty());
	}

//-------------------------IsEmpty Tests End-------------------------------	

//-------------------------Peek Tests Start--------------------------------	

	@Test
	public void PeekFilled() {
		valuesLL.push(-9);
		assertEquals(-9, valuesLL.peek());
	}

	@Test
	public void PeekEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyLL.peek();
		});
	}

	@Test
	public void PeekAfterConsecutiveAdd() {
		valuesLL.push(-7);
		valuesLL.push(-16);

		assertEquals(-16, valuesLL.peek());
	}

	@Test
	public void PeekAfterDeletion() {
		valuesLL.push(-6);
		valuesLL.push(-30);
		valuesLL.pop();

		assertEquals(-6, valuesLL.peek());
	}

//-------------------------Peek Tests End----------------------------------	

//-------------------------Pop Tests Start---------------------------------	

	@Test
	public void PopFilled() {
		valuesLL.push(-7);
		valuesLL.push(-9);
		valuesLL.push(-3);

		assertEquals(-3, valuesLL.pop());
	}

	@Test
	public void popEmpty() {
		assertThrows(NoSuchElementException.class, () -> {
			emptyLL.pop();
		});
	}

	@Test
	public void testConsecutivePop() {
		valuesLL.push(-7);
		valuesLL.push(-9);
		valuesLL.push(-3);

		assertEquals(-3, valuesLL.pop());
		assertEquals(-9, valuesLL.pop());
		assertEquals(-7, valuesLL.pop());

	}

	@Test
	public void testInvalidPop() {
		emptyLL.push(7);
		emptyLL.pop();

		assertThrows(NoSuchElementException.class, () -> {
			emptyLL.pop();
		});
	}

//-------------------------Pop Tests End-----------------------------------	

//-------------------------Push Tests Start--------------------------------
	@Test
	public void testPushEmpty() {
		emptyLL.push(-1);
		assertEquals(-1, emptyLL.pop());
	}

	@Test
	public void testPushFilled() {
		valuesLL.push(-2);
		assertEquals(-2, valuesLL.pop());
	}

	@Test
	public void testPushConsecutive() {
		emptyLL.push(-5);
		emptyLL.push(-6);
		emptyLL.push(-7);

		assertEquals(-7, emptyLL.pop());
		assertEquals(-6, emptyLL.pop());
		assertEquals(-5, emptyLL.pop());
	}

	@Test
	public void testPushAfterDeletion() {
		emptyLL.push(-5);
		emptyLL.push(-7);
		emptyLL.pop();
		emptyLL.push(-17);

		assertEquals(-17, emptyLL.peek());
	}

//-------------------------Push Tests End----------------------------------	

//-------------------------Size Tests Start---------------------------------		
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
		valuesLL.push(-3);

		assertEquals(11, valuesLL.size());
	}

	@Test
	public void TestSizeAfterRemove() {
		valuesLL.pop();

		assertEquals(9, valuesLL.size());
	}
//-------------------------Size Tests Start---------------------------------	
}
