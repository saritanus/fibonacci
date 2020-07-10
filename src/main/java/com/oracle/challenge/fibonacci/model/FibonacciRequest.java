package com.oracle.challenge.fibonacci.model;

public class FibonacciRequest {
    private static final long serialVersionUID = 103640251760933139L;
    /**
     * No of elements requested for fibonacci series
     */
    private int elements;

    public FibonacciRequest(int elements) {
        this.elements=elements;
    }

    public  FibonacciRequest(){

    }

    /**
     * Returns the no of elements needs to be returned "elements
     * @return no of elements
     */
    public int getElements() {
        return elements;
    }

    /**
     * Seth the no of elements in the series
     * @param elements no of elements
     */
    public void setElements(Integer elements) {
        this.elements = elements;
    }

}
