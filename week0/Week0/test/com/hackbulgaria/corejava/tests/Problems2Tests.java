package com.hackbulgaria.corejava.tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import javax.swing.JApplet;

import org.junit.Assert;
import org.junit.Test;

import com.hackbulgaria.corejava.Problems2;
import com.hackbulgaria.corejava.Problems2Impl;

public class Problems2Tests {

	private static final String NOT_IMPLEMENTED = "NOT IMPLEMENTED";
	private final Problems2 problems2 = new Problems2Impl();

	private void notImplemented() {
		fail(NOT_IMPLEMENTED);
	}

	@Test
	public void testIsPrime() {
		assertTrue(problems2.isPrime(5));
		assertTrue(problems2.isPrime(7));
		assertTrue(problems2.isPrime(41));
		assertTrue(problems2.isPrime(3));
		assertTrue(!problems2.isPrime(39));
	}

	@Test
	public void testIsOdd() {
		assertTrue(problems2.isOdd(3));
		assertTrue(problems2.isOdd(5));
		assertTrue(problems2.isOdd(7));
		assertTrue(problems2.isOdd(-1));
		assertTrue(problems2.isOdd(-3));
		assertTrue(!problems2.isOdd(0));
	}

	@Test
	public void testMin() {
		int min = problems2.min(1, 3, 4, 5, 6, -1, 23, -125, 125125, -63262, 2151, -1212);
		assertTrue(min == -63262);

		min = problems2.min(-1, 0, 1, 1, -1, -9, 0, 5);
		assertTrue(min == -9);
	}

	@Test
	public void testKthMin() {
		int testArr[] = new int[] { 1, 2151, 125, 125, 1125, 16, 754, 132, 613, -51521, 51251, 675, 125366 };
		Arrays.sort(testArr);

		assertTrue(testArr[0] == problems2.kthMin(1, testArr));
		assertTrue(testArr[1] == problems2.kthMin(2, testArr));
		assertTrue(testArr[2] == problems2.kthMin(3, testArr));
	}

	@Test
	public void testGetAverage() {
		int testArr[] = new int[] { 1, 2151, 125, 125, 1125, 16, 754, 132, 613, -51521, 51251, 675, 125366 };

		float avg = 0;
		for (int i = 0; i < testArr.length; i++) {
			avg += testArr[i];
		}
		avg /= testArr.length;

		assertEquals(avg, problems2.getAverage(testArr), 0.01f);
	}

	@Test
	public void testGetSmallestMultiple() {
		assertEquals(2520, problems2.getSmallestMultiple(10));
		assertEquals(232792560, problems2.getSmallestMultiple(20));
	}

	@Test
	public void testGetLargestPalindrome() {
		assertEquals(99, problems2.getLargestPalindrome(100));
		assertEquals(99_999, problems2.getLargestPalindrome(10_0000));
		assertEquals(123_321, problems2.getLargestPalindrome(123_456));
	}

	@Test
	public void testHistorgram() {
		final short[][] image = new short[10][10];
		assertEquals(100, problems2.histogram(image)[0]);

		for (short i = 0; i < image.length; i++) {
			for (short j = 0; j < image[0].length; j++) {
				image[i][j] = (short) (i * image[0].length + j);
			}
		}

		assertEquals(1, problems2.histogram(image)[13]);

		for (short i = 0; i < image.length; i++) {
			for (short j = 0; j < image[0].length; j++) {
				image[i][j] = (short) (i * j + j);
			}
		}
	}

	@Test
	public void testDoubleFac() {
		assertEquals(720, problems2.doubleFac(3));
		assertEquals(2, problems2.doubleFac(2));
	}

	@Test
	public void testKthFac() {
		assertEquals(3628800, problems2.kthFac(1, 10));
		assertEquals(3628800 / 10, problems2.kthFac(1, 9));
		testDoubleFac();
	}

	@Test
	public void testGetOddOccurrence() {
		int[] numbers = new int[] { 1, 1, 3, 3, 6, 5, 4, 6, 5, 9, 1, 1, 3, 15, 4, 5, 9, 3, 15 };
		assertEquals(5, problems2.getOddOccurrence(numbers));
	}

	@Test
	public void testPow() {
		assertEquals(8, problems2.pow(2, 3));
		assertEquals(-1, problems2.pow(-1, 9));
		assertEquals(1, problems2.pow(99, 0));

		assertEquals(-32, problems2.pow(-2, 5));
		assertEquals(729, problems2.pow(3, 6));
	}

	@Test
	public void testMaximalScalarSum() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] b = new int[] { 0, 0, 0, 0, 0, 0 };

		assertEquals(0, problems2.maximalScalarSum(a, b));
		b = new int[] { 1, 1, 1, 1, 1, 1 };

		assertEquals(21, problems2.maximalScalarSum(a, b));

		b = new int[] { 5, 4, 8, 9, -1, 2 };
		assertEquals(129, problems2.maximalScalarSum(a, b));

	}

	@Test
	public void testMaxSpan() {
		assertEquals(4, problems2.maxSpan(new int[] { 1, 2, 1, 1, 3 }));
		assertEquals(6, problems2.maxSpan(new int[] { 1, 4, 2, 1, 4, 1, 4 }));
		assertEquals(6, problems2.maxSpan(new int[] { 1, 4, 2, 1, 4, 4, 4 }));
	}

	@Test
	public void testCanBalance() {
		assertTrue(problems2.canBalance(new int[] { 1, 1, 1, 2, 1 }));
		assertFalse(problems2.canBalance(new int[] { 2, 1, 1, 2, 1 }));
		assertTrue(problems2.canBalance(new int[] { 10, 10 }));
	}

	@Test
	public void testRescale() {
		final int[][] original = new int[100][100];
		int counter = 0;
		for (int y = 0; y < original.length; y++) {
			for (int x = 0; x < original[0].length; x++) {
				original[y][x] = counter++;
			}
		}

		final int newWidth = 10;
		final int newHeight = 10;

		final int[][] newImage = problems2.rescale(original, newWidth, newHeight);
		assertEquals(newImage[0][0], original[0][0]);
		assertEquals(newImage[9][9], original[90][90]);
		assertEquals(newImage[0][9], original[0][90]);
		assertEquals(newImage[9][0], original[90][0]);

	}
}