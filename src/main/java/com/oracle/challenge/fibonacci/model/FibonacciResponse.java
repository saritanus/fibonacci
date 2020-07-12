package com.oracle.challenge.fibonacci.model;

import java.math.BigInteger;

public class FibonacciResponse {
	private BigInteger[] fibonacci;
	private BigInteger[] sorted;

	public FibonacciResponse(BigInteger[] fibonacci, BigInteger[] sorted) {
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}

	public FibonacciResponse() {}

	public BigInteger[] getFibonacci() {
		return fibonacci;
	}

	public void setFibonacci(BigInteger[] fibonacci) {
		this.fibonacci = fibonacci;
	}

	public BigInteger[] getSorted() {
		return sorted;
	}

	public void setSorted(BigInteger[] sorted) {
		this.sorted = sorted;
	}
}
