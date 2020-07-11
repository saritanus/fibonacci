package com.oracle.challenge.fibonacci.service;

import com.oracle.challenge.fibonacci.exception.InvalidInputException;
import com.oracle.challenge.fibonacci.model.FibonacciResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


/**
 * <h1> Fibonacci Service Test </h1>
 * The FibonacciServiceTest class defines unit tests cases for FibonacciService class.
 *
 * @author Sarita Sethy
 * @version 1.0
 * @since 2020-07-10
 */
class FibonacciServiceTest {

    /**
     * It tests fibonacci sequence of length 10
     */
    @Test
    void getFibonacciSequenceWith10() throws InvalidInputException {
        FibonacciResponse expected = new FibonacciResponse();
        expected.setFibonacci(new long[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34});
        expected.setSorted(new long[]{34, 8, 2, 0, 21, 13, 5, 3, 1, 1});
        FibonacciResponse result = FibonacciService.getFibonacciSequence(10);
        Assert.assertArrayEquals(expected.getFibonacci(), result.getFibonacci());
        Assert.assertArrayEquals(expected.getSorted(), result.getSorted());
    }

    /**
     * It tests fibonacci sequence when input is 0
     */
    @Test
    void getFibonacciSequenceWith0(){
        String expectedMessage= String.format("Number elements is less than minimum value %d. [%d]", FibonacciService.MIN_ELEMENTS, 0);
        try {
            FibonacciService.getFibonacciSequence(0);
        } catch (InvalidInputException e) {
            Assert.assertEquals(expectedMessage,e.getMessage());
        }
    }

    /**
     * It tests fibonacci sequence when input is 1
     */
    @Test
    void getFibonacciSequenceWith1() throws InvalidInputException {
        FibonacciResponse expected = new FibonacciResponse();
        expected.setFibonacci(new long[]{0});
        expected.setSorted(new long[]{0});
        FibonacciResponse result = FibonacciService.getFibonacciSequence(1);
        Assert.assertArrayEquals(expected.getFibonacci(), result.getFibonacci());
        Assert.assertArrayEquals(expected.getSorted(), result.getSorted());
    }

    /**
     * It tests fibonacci sequence when input is 101 which is invalid
     */
    @Test
    void getFibonacciSequenceWithAbove100() {
        String expectedMessage= String.format("Number elements is greater than maximum value %d. [%d]", FibonacciService.MAX_ELEMENTS, 100);
        try {
            FibonacciService.getFibonacciSequence(100);
        } catch (InvalidInputException e) {
            Assert.assertEquals(expectedMessage,e.getMessage());
        }
    }


}