package com.oracle.challenge.fibonacci.service;

import com.oracle.challenge.fibonacci.exception.InvalidInputException;
import com.oracle.challenge.fibonacci.model.FibonacciResponse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h1>Fibonacci Service</h1>
 * This class provide service to create Fibonacci Series and sorts it in descending order.
 *
 * @author Sarita Sethy
 * @version 1.0
 * @since 2020-02-10
 */
public final class FibonacciService {

	public static final int MIN_ELEMENTS = 1;
	public static final int MAX_ELEMENTS = 100;

	private FibonacciService() {}

	/**
	 * This method will return a fibonacci series in an array
	 *
	 * @param noElement The noElement must be between 1 to 100
	 * @return It returns a fibonacci series
	 */
	public static FibonacciResponse getFibonacciSequence(int noElement) throws InvalidInputException {
		FibonacciResponse response = new FibonacciResponse();
		BigInteger[] series;
		BigInteger a = BigInteger.valueOf(0);
		BigInteger b = BigInteger.valueOf(1);
		BigInteger c;

		if (noElement < MIN_ELEMENTS) {
			throw new InvalidInputException(5001, String.format("Number elements is less than minimum value %d. [%d]", MIN_ELEMENTS, noElement));
		} else if (noElement > MAX_ELEMENTS) {
			throw new InvalidInputException(5002, String.format("Number elements is greater than maximum value %d. [%d]", MAX_ELEMENTS, noElement));
		} else {
			series = new BigInteger[noElement];
			if (noElement == 1) {
				series[0] = a;
			} else if (noElement == 2) {
				series[0] = a;
				series[1] = b;
			} else {
				series[0] = a;
				series[1] = b;
				int i = 2;
				while (i < noElement) {
					c = a.add(b);
					series[i] = c;
					a = b;
					b = c;
					i++;
				}
			}
			response.setFibonacci(series);
			response.setSorted(getSortedFibonacciSequence(series));
			return response;
		}
	}

	/**
	 * This method will return a sorted array in descending order where even number comes first and odd numbers in second
	 *
	 * @param input unsorted fibonacci array
	 * @return sorted array in a descending order where even number comes first
	 */
	private static BigInteger[] getSortedFibonacciSequence(BigInteger[] input) {
		List<BigInteger> even = new ArrayList<>();
		List<BigInteger> odd = new ArrayList<>();
		BigInteger[] sorted = new BigInteger[input.length];
		for (BigInteger number : input) {
			if (number.mod(BigInteger.valueOf(2)) == BigInteger.ZERO) {
				even.add(number);
			} else {
				odd.add(number);
			}
		}
		even.sort(Collections.reverseOrder());
		odd.sort(Collections.reverseOrder());
		even.addAll(odd);

		for (int i = 0; i < even.size(); i++) {
			sorted[i] = even.get(i);
		}
		return sorted;
	}
}
