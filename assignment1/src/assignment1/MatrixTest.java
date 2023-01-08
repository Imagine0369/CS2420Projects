package assignment1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author CS 2420 staff and ??
 * @version August 18, 2021
 *
 */
class MatrixTest {

	/* ******equals tests****** */
	@Test
	void testModerateMatricesEqual() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		assertTrue(m1.equals(m2));
	}
	
	//Tests Matrices that are not equal.
	@Test
	void testUnequalValuesMatrices() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		Matrix m2 = new Matrix(new int[][] {
			{8, 2, 7},
			{1, 4, 6}
		});
		
		assertFalse(m1.equals(m2));
	}
	
	//Tests Matrices with unequal dimensions but same initial values
	@Test
	void testUnequalDimensionsMatrices() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{6, 5, 3}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});
		
		assertFalse(m1.equals(m2));
	}
	
	//Tests that method can verify smallest possible matrices.
	@Test
	void testSmallMatricesEqual() {
		Matrix m1 = new Matrix(new int[][] {
			{1},
			{1}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1},
			{1}
		});

		assertTrue(m1.equals(m2));
	}
	
	//Tests that method can accurately identify inequality with matrices that are nearly identical
	@Test
	void testSimilarMatricesDontEqual() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 5}
		});

		Matrix m2 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6}
		});

		assertFalse(m1.equals(m2));
	}
	
	//Tests that method can detect difference between pos and neg values
	@Test
	void testNegatedValuesMatricesDontEqual() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{6, 5, 3}
		});

		Matrix m2 = new Matrix(new int[][] {
			{-1, -2, -3},
			{-4, -5, -6},
			{-6, -5, -3}
		});
		
		assertFalse(m1.equals(m2));
	}
	
	
	/* ******end equals tests****** */

	

	/* ******toString tests****** */
	@Test
	void testModerateToString() {
		Matrix m = new Matrix(new int[][] {
			{1, 2},
			{3, 4}
		});

		assertEquals("1 2\n3 4\n", m.toString());
	}
	
	//Tests that toString works with smallest possible matrix
	@Test
	void testSmallToString() {
		Matrix m = new Matrix(new int[][] {
			{1},
			{1}
		});

		assertEquals("1\n1\n", m.toString());
	}
	
	//Test that toString method works on matrices that have uneven dimensions. Ensures that i and j are
	//independently accurate.
	@Test
	void testRectangularMatrixToString() {
		Matrix m = new Matrix(new int[][] {
			{1,5,3,7,8},
			{1,4,5,2,4}
		});
		
		assertEquals("1 5 3 7 8\n1 4 5 2 4\n", m.toString());
	}
	
	//Tests that toString works with negative values.
	@Test
	void testNegativeValuesToString() {
		Matrix m = new Matrix(new int[][] {
			{-1,-2},
			{-3,-4}
		});

		assertEquals("-1 -2\n-3 -4\n", m.toString());
	}
	
	/* ******end toString tests****** */



	/* ******times tests****** */
	@Test
	void testCompatibleTimes() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2, 3},
				{2, 5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5},
				{3, 2},
				{1, 1}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{13, 12},
				{29, 26}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	//Tests methods ability to throw IllegalArgumentException
	@Test
	void testIncompatibleTimes() {
		Matrix m1 = new Matrix(new int[][]
				{{1, 2},
				{2, 5}});

		Matrix m2 = new Matrix(new int[][]
				{{4, 5},
				{3, 2},
				{1, 1}});
		
		assertThrows(IllegalArgumentException.class, () -> { m1.times(m2); });  
	}
	
	//Tests that method accurately multiplies negative values
	@Test
	void testNegativeValuesTimes() {
		Matrix m1 = new Matrix(new int[][]
				{{-1, 2, -3},
				{2, -5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{-4, 5},
				{3, -2},
				{-1, 1}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{13, -12},
				{-29, 26}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	//Tests that method accurately multiplies matrices with 0's as values
	@Test
	void testZerosValuesTimes() {
		Matrix m1 = new Matrix(new int[][]
				{{-1, 2, -3},
				{2, -5, 6}});

		Matrix m2 = new Matrix(new int[][]
				{{0, 0},
				{0, 0},
				{0, 0}});

		// the known correct result of multiplying m1 by m2
		int[][] expected = new int[][]
				{{0, 0},
				{0, 0}};
		
		// the result produced by the times method
		Matrix mulResult = m1.times(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	/* ******end times tests****** */
	

	/* ******plus tests****** */
	@Test
	public void testIncompatiblePlus() {	
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1},
			{1, 1, 1}
		});

		Matrix m2 = new Matrix(new int[][] {
			{2, 2},
			{2, 2}
		});
		
		// This is an example of how to test that an exception is thrown when needed.
		// The odd syntax below is an example of a lambda expression.
		// See Lab 1 for more info.
		assertThrows(IllegalArgumentException.class, () -> { m1.plus(m2); });  
	}
	
	//Tests basic matrix addition with two 2X3 matrices
	@Test
	public void testModeratePlus() {	
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1},
			{1, 1, 1}
		});

		Matrix m2 = new Matrix(new int[][] {
			{2, 2, 2},
			{2, 2, 2}
		});
		
		int[][] expected = new int[][]
				{{3, 3, 3},
				{3, 3, 3}};
		
		// the result produced by the times method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]); 
	}
	
	//Tests method accurately adds 2 matrices of the smallest possible dimension
	@Test
	public void testSmallMatricesPlus() {	
		Matrix m1 = new Matrix(new int[][] {
			{1},
			{1}
		});

		Matrix m2 = new Matrix(new int[][] {
			{2},
			{2}
		});
		
		int[][] expected = new int[][]
				{{3},
				{3}};
		
		// the result produced by the times method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]); 
	}
	
	//Tests that method accurately adds positive and negative values
	@Test
	public void testNegativeValuesPlus() {	
		Matrix m1 = new Matrix(new int[][] {
			{1, -10},
			{-4, 7}
		});

		Matrix m2 = new Matrix(new int[][] {
			{2, 11},
			{-6, 3}
		});
		
		int[][] expected = new int[][]
				{{3, 1},
				{-10, 10}};
		
		// the result produced by the times method
		Matrix mulResult = m1.plus(m2);
		int[][] resultArray = mulResult.getData();
		
		
		// compare the raw arrays
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]); 
	}
	
	/* ******end plus tests****** */
	
	
	
	/* ******transpose tests****** */
	@Test
	public void testSameValuesTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{1, 1, 1},
			{1, 1, 1}
		});
		
		int expected[][] = {
				{1, 1},
				{1, 1},
				{1, 1}
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	//Tests transpose on moderately sized matrix with distinct values
	@Test
	public void testModerateTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{6, 5, 8},
			{4, 3, 9}
		});
		
		int expected[][] = {
				{6, 4},
				{5, 3},
				{8, 9}
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	//Tests transpose on smallest possible matrix
	@Test
	public void testSmallTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{6},
			{1}
		});
		
		int expected[][] = {
				{6, 1},
				
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	//Tests transpose with symmetric matrix
	@Test
	public void testSymmetircMatrixTranspose() {
		Matrix m1 = new Matrix(new int[][] {
			{0,1},
			{1,0}
		});
		
		int expected[][] = {
				{0, 1},
				{1, 0}
				
		};
		
		Matrix t = m1.transpose();
		int resultArray[][] = t.getData();
		
		assertEquals(expected.length, resultArray.length);
		for(int i = 0; i < expected.length; i++)
			assertArrayEquals(expected[i], resultArray[i]);
	}
	
	/* ******end transpose tests****** */


}
