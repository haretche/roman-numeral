package com.haretche.romannumeral.model;

/**
 * Simple POJO that represents a response from the REST endpoint /romannumeral.
 */
public class RomanNumeralResponse {
    private final int input;
    private final String output;

    public RomanNumeralResponse(int input, String output) {
        this.input = input;
        this.output = output;
    }

    public int getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}
