package lab04;

import java.util.Arrays;

public class FindMean {
	
	//<T extends Comparable<T>> ensures that 
	public static <T extends Comparable<T>> T median(T[] arr) {
		Arrays.sort(arr);
		
		T median = arr[(arr.length/2)];
		
		return median;
	}

	public static void main(String[] args) {
		Integer[] test = new Integer[]{1, 2, 3, 4 ,5 ,6 ,7, 8};
		
		System.out.println(median(test));

	}

}
