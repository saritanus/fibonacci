package com.oracle.challenge.fibonacci.service;

import com.oracle.challenge.fibonacci.excpetion.InvalidInputException;
import com.oracle.challenge.fibonacci.model.FibonacciResponse;

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
public class FibonacciService {

    public static final int MIN_ELEMENTS = 1;
    public static final int MAX_ELEMENTS = 93;

    private FibonacciService(){}

    /**
     * This method will return a fibonacci series in an array
     *
     * @param noElement The noElement must be between 1 to 100
     * @return It returns a fibonacci series
     */
    public static FibonacciResponse getFibonacciSequence(int noElement) throws InvalidInputException {
        FibonacciResponse response = new FibonacciResponse();
        long[] series;
        long a = 0;
        long b = 1;
        long c;

        if (noElement < MIN_ELEMENTS) {
            throw new InvalidInputException(5001,String.format("Number elements is less than minimum value %d. [%d]", MIN_ELEMENTS, noElement));
        } else if (noElement>MAX_ELEMENTS) {
            throw new InvalidInputException(5002,String.format("Number elements is greater than maximum value %d. [%d]",MAX_ELEMENTS, noElement));
        } else {
            series = new long[noElement];
            if (noElement == 1) {
                series[0] = a;
            }else if(noElement==2){
                series[0] = a;
                series[1] = b;
            }else {
                series[0] = a;
                series[1] = b;
                int i = 2;
                while (i < noElement) {
                    c = a + b;
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
    private static long[] getSortedFibonacciSequence(long[] input) {
        List<Long> even = new ArrayList<>();
        List<Long> odd = new ArrayList<>();
        long[] sorted= new long[input.length];
        for (long number : input) {
            if (number % 2 == 0) {
                even.add(number);
            } else {
                odd.add(number);
            }
        }
        even.sort(Collections.reverseOrder());
        odd.sort(Collections.reverseOrder());
        even.addAll(odd);

        for(int i=0;i<even.size();i++)
        {
            sorted[i]=even.get(i);
        }
        return sorted;
    }
}