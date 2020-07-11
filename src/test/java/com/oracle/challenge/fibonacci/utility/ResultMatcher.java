package com.oracle.challenge.fibonacci.utility;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ResultMatcher {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public ResultMatcher() {
    }

    public static boolean matchJson(String responseString, String expectedString, boolean reportMismatch) {
        try {
            JsonNode response = OBJECT_MAPPER.readTree(responseString);
            JsonNode expected = OBJECT_MAPPER.readTree(expectedString);
            if (!response.equals(expected)) {
                if (reportMismatch) {
                    System.out.println("\u001b[0;31mExpected <" + expectedString + "> but was <" + responseString + ">." + "\u001b[0m");
                }

                return false;
            } else {
                return true;
            }
        } catch (IOException var5) {
            return false;
        }
    }
}
