package com.haretche.romannumeral.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for RomanNumeralUtil
 */
public class RomanNumeralUtilTest {

    /**
     * Test that fromInt throws IllegalArgumentException when called with an integer outside of the supported range.
     */
    @Test
    void fromIntTestWithInvalidInput() {
        List<Integer> tests = Arrays.asList(-1, 0, 4000);
        for (int test : tests) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> RomanNumeralUtil.fromInt(test));
        }
    }

    /**
     * Test Roman Numerals from 1 to 21 and near all edge cases.
     */
    @Test
    void fromIntTestWithValidInput() {
        Map<Integer, String> tests = new HashMap<>();
        tests.put(1, "I");
        tests.put(2, "II");
        tests.put(3, "III");
        tests.put(4, "IV");
        tests.put(5, "V");
        tests.put(6, "VI");
        tests.put(7, "VII");
        tests.put(8, "VIII");
        tests.put(9, "IX");
        tests.put(10, "X");
        tests.put(11, "XI");
        tests.put(12, "XII");
        tests.put(13, "XIII");
        tests.put(14, "XIV");
        tests.put(15, "XV");
        tests.put(16, "XVI");
        tests.put(17, "XVII");
        tests.put(18, "XVIII");
        tests.put(19, "XIX");
        tests.put(20, "XX");
        tests.put(21, "XXI");

        tests.put(39, "XXXIX");
        tests.put(40, "XL");
        tests.put(41, "XLI");

        tests.put(49, "XLIX");
        tests.put(50, "L");
        tests.put(51, "LI");

        tests.put(89, "LXXXIX");
        tests.put(90, "XC");
        tests.put(91, "XCI");

        tests.put(99, "XCIX");
        tests.put(100, "C");
        tests.put(101, "CI");

        tests.put(399, "CCCXCIX");
        tests.put(400, "CD");
        tests.put(401, "CDI");

        tests.put(499, "CDXCIX");
        tests.put(500, "D");
        tests.put(501, "DI");

        tests.put(899, "DCCCXCIX");
        tests.put(900, "CM");
        tests.put(901, "CMI");

        tests.put(999, "CMXCIX");
        tests.put(1000, "M");
        tests.put(1001, "MI");

        tests.put(3999, "MMMCMXCIX");
        for (int testKey : tests.keySet()) {
            String expected = tests.get(testKey);
            String actual = RomanNumeralUtil.fromInt(testKey);
            Assertions.assertEquals(expected, actual);
        }
    }


}
