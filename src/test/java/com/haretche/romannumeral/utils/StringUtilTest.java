package com.haretche.romannumeral.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for StringUtilTest
 */
public class StringUtilTest {

    /**
     * call tryParse with Strings that don't contain a valid integer.
     */
    @Test
    void tryParseTestWhenValueIsInvalid() {
        List<String> tests = Arrays.asList(null, "", " ", "not an int");
        for (String test : tests) {
            Integer result = StringUtil.tryParseInt(test);
            Assertions.assertEquals(null, result);
        }
    }

    @Test
    void tryParseTestWhenValueIsValid() {
        Map<String, Integer> tests = new HashMap<>();

        tests.put("-1", -1);
        tests.put("0", 0);
        tests.put("1", 1);
        tests.put("99999", 99999);

        for (String testKey : tests.keySet()) {
            int expected = tests.get(testKey);
            Integer actual = StringUtil.tryParseInt(testKey);
            Assertions.assertEquals(expected, actual);
        }
    }


}
