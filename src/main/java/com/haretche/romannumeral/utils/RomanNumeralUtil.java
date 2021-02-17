package com.haretche.romannumeral.utils;

import com.haretche.romannumeral.enums.RomanNumeralComponents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Utility class for Roman Numerals.
 */
public class RomanNumeralUtil {
    private static final Logger LOG = LoggerFactory.getLogger(RomanNumeralUtil.class);

    private static final int MIN_SUPPORTED = 1;
    private static final int MAX_SUPPORTED = 3999;

    private RomanNumeralUtil() {
        // Util classes shouldn't be instantiated.
    }

    /**
     * At this time, only values between MIN_SUPPORTED and MAX_SUPPORTED can be converted from integer to roman numeral.
     * This method checks that the provided value is in that range.
     */
    public static boolean isSupported(int value) {
        return value >= MIN_SUPPORTED && value <= MAX_SUPPORTED;
    }

    /**
     * Converts the provided input integer into a roman numeral.
     * Only inputs in the range [1-3999] are currently supported.
     * For example: if input is '6', then returns 'VI'.
     */
    public static String fromInt(int input) {
        if (!isSupported(input)) {
            LOG.warn("The provided input is not supported: " + input);
            throw new IllegalArgumentException("Input is not in supported range");
        }
        StringBuilder convertedValue = new StringBuilder(); // The roman numeral is built here.
        Collection<RomanNumeralComponents> componentsDesc = RomanNumeralComponents.getValuesOrderedDesc().values();
        // Collection of supported roman numeral components in descendant order, from 1000 down to 1.
        for (RomanNumeralComponents romanNumeralComponent : componentsDesc) {
            while (input >= romanNumeralComponent.getIntegerValue()) {
                convertedValue.append(romanNumeralComponent.toString());
                input -= romanNumeralComponent.getIntegerValue();
            }
        }
        return convertedValue.toString();
    }
}
