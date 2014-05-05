package com.hackbulgaria.corejava;

public interface Problems2 {
	boolean isOdd(int number);

	boolean isPrime(int number);

	int min(int... array);
	
	int kthMin(int k, int[] array);
	
	float getAverage(int[] array);

	long getSmallestMultiple(int upperBound);

	long getLargestPalindrome(long N);

	int[] histogram(short[][] image);
	
	long doubleFac(int n);
	
	long kthFac(int k, int n);
	
	int getOddOccurrence(int[] array);
	
	long pow(int a, int b);
	
	long maximalScalarSum(int[] a, int[] b);
	
	int maxSpan(int[] array);
	
	boolean canBalance(int[] array);
	
	int[][] rescale(int[][] original, int newWidth, int newHeight);
}
