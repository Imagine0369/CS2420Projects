package assignment1;

/**
 * This class represents a 2D matrix and simple operations on them.
 * 
 * @author Daniel Kopta and ??
 * @version August 08, 2021
 *
 */

public class Matrix {
	
	// the dimensions of the matrix
	private int numRows;
	private int numColumns;
	
	// the internal storage for the matrix elements 
	private int data[][];
	
	/**
	 * DO NOT MODIFY THIS METHOD.
	 * Constructor for a new Matrix. Automatically determines dimensions.
	 * This is implemented for you.
	 * @param d - the raw 2D array containing the initial values for the Matrix.
	 */
	public Matrix(int d[][])
	{
		// d.length is the number of 1D arrays in the 2D array
		numRows = d.length; 
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		
		// create a new matrix to hold the data
		data = new int[numRows][numColumns]; 
		
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	

	/**
	 * Determines whether this Matrix is equal to another object.
	 * @param o - the other object to compare to, which may not be a Matrix
	 */
	@Override // instruct the compiler that we intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		// make sure the Object we're comparing to is a Matrix
		if(!(o instanceof Matrix)) 
			return false;
		
		// if the above was not true, we know it's safe to treat 'o' as a Matrix
		Matrix m = (Matrix)o; 
		
		//confirm that matrix dimensions are the same. If they are not the same, return false.
		if((m.numRows != this.numRows) || (m.numColumns != this.numColumns)) {
			return false;
		}
		
		//compare values of each matrix in the same position[i][j]. If at any point the values differ, return false.
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j < this.numColumns; j++) {
				if(m.data[i][j] != this.data[i][j]) {
					return false;
				}
			}
		}
		
		//If algorithm gets to this point without returning, the dimensions and all values are the same.
		//therefore we return true.
		return true; 
	}
	
	
	/**
	 * Returns a String representation of this Matrix.
	 */
	@Override // instruct the compiler that we intend for this method to override the superclass' (Object) version
	public String toString()
	{
		//Starting String to build on
		String matrixString = "";
		
		//For loops to grab each element in order
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j < this.numColumns; j++) {
				//if is last element of the row, end with a new line instead of a space
				if(j == this.numColumns - 1) {
					matrixString += this.data[i][j] + "\n";
				}
				//if it is not the last element in the row, end with a space
				else {
					matrixString += this.data[i][j] + " ";

				}
			}
		}
		//Return String we've been building on.
		return matrixString; 
	}
	
	/**
	 * Returns a new Matrix that is the result of multiplying this Matrix as the left hand side
	 * by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the multiplication
	 * @return - the result of the multiplication
	 * @throws IllegalArgumentException - if the input Matrix does not have compatible dimensions
	 * for multiplication
	 */
	public Matrix times(Matrix m) throws IllegalArgumentException
	{
		//If the amount of columns on the left matrix does not equal the amount of rows on the right matrix then the
		//matrices are not compatible for multiplication, therefore throw IllegalArgumentException.
		if(this.numColumns != m.numRows) {
			throw new IllegalArgumentException("Incompatible dimensions, cannot perform matrix multiplication");
		}
		
		//New 2D array which will be converted into a matrix later in the algorithm. Dimensions of the new 2D array
		//will be: (left arrays number of rows) X (Right arrays number of columns)
		int[][] newData = new int[this.numRows][m.numColumns];
		
		/*
		 * Traverses each value in both 2D arrays starting at Row 0 Column 0 of the right array and Row 0 Column 0 of
		 * the left array. Each iteration adds a new value (which is the product of 2 numbers) to the current placement 
		 * position of the new array.
		 * The placement position in the new array is determined by the (current row matrix A) X (current column matrix B)
		 * 
		 */
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j <m.numColumns; j++) {
				for(int k = 0; k < this.numColumns; k++) {
					newData[i][j] += this.data[i][k] * m.data[k][j];
				}
			}
		}
		
		//Make a new matrix using the newData 2D array we created and filled in with the multiplied values
		Matrix returnMatrix = new Matrix(newData);
		
		//Use our newData 2D array to construct a Matrix and return that matrix
		return returnMatrix;
	}
	
	/**
	 * Returns a new Matrix that is the result of adding this Matrix as the left hand side
	 * by the input matrix as the right hand side.
	 * 
	 * @param m - the Matrix on the right hand side of the addition
	 * @return - the result of the addition
	 * @throws IllegalArgumentException - if the input Matrix does not have compatible dimensions
	 * for addition
	 */
	public Matrix plus(Matrix m) throws IllegalArgumentException
	{
		//If matrix dimensions aren't identical, they are incompatible for Matrix addition
		//therefore an IllegalArgumentException must be thrown.
		if((m.numRows != this.numRows) || (m.numColumns != this.numColumns)) {
			throw new IllegalArgumentException("Matrices must have same dimensions in order to perform addition");
		}
		
		//New 2D array where we will store the added values from the left and right matrix.
		int[][] addedData = new int[this.numRows][this.numColumns];
		
		//Traverse through each value in both arrays, adding the values from the left and right matrices at their identical
		//positions.
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j < this.numColumns; j++) {
				addedData[i][j]= this.data[i][j] + m.data[i][j];
			}
		}
		
		//construct a matrix using the addedData 2D array we built onto earlier in the algorithm.
		Matrix newMatrix = new Matrix(addedData);
		
		//return the newMatrix Matrix we built with our addedData 2D array
		return newMatrix; 
	}
	
	
	/**
	 * Produces the transpose of this matrix.
	 * @return - the transpose
	 */
	public Matrix transpose()
	{
		//Create new 2D array with opposite dimension of the matrix we are given. This will be used to hold the
		//transposed data.
		int[][] newData = new int[this.numColumns][this.numRows];
		
		//Traverse through all values in our given matrix and reverse the dimensions. If a value is in
		//Row 0, Column 1, it will now be in Row 1 Column 0 in the transposed 2D array.
		for(int i = 0; i < this.numRows; i++) {
			for(int j = 0; j < this.numColumns; j++) {
				newData[j][i] = this.data[i][j];
			}
		}
		
		//Construct matrix using newData 2D array we defined and built onto in the earlier part of our algorithm.
		Matrix newMatrix = new Matrix(newData);
		
		//Return the matrix we constructed using our newData 2D array
		return newMatrix;
	}
	
	
	/**
	 * DO NOT MODIFY THIS METHOD.
	 * Produces a copy of the internal 2D array representing this matrix.
	 * This method is for grading and testing purposes.
	 * @return - the copy of the data
	 */
	public int[][] getData()
	{
		int[][] retVal = new int[data.length][];
		for(int i = 0; i < data.length; i++)
			retVal[i] = data[i].clone();
		return retVal;
	}
	

	}

