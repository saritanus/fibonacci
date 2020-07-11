package com.oracle.challenge.fibonacci.model;

public class FibonacciResponse {
	private long[] fibonacci;
	private long[] sorted;

	public FibonacciResponse(long[] fibonacci, long[] sorted) {
		this.fibonacci = fibonacci;
		this.sorted = sorted;
	}

	public FibonacciResponse() {}

	public long[] getFibonacci() {
		return fibonacci;
	}

	public void setFibonacci(long[] fibonacci) {
		this.fibonacci = fibonacci;
	}

	public long[] getSorted() {
		return sorted;
	}

	public void setSorted(long[] sorted) {
		this.sorted = sorted;
	}
}
