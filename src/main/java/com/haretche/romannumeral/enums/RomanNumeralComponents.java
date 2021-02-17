package com.haretche.romannumeral.enums;

import java.util.Collections;
import java.util.TreeMap;

/**
 * Represents the components needed to build a Roman Numeral. Each element is associated with an integer value.
 */
public enum RomanNumeralComponents {
    M(1000),
    CM(900),
    D(500),
    CD(400),
    C(100),
    XC(90),
    L(50),
    XL(40),
    X(10),
    IX(9),
    V(5),
    IV(4),
    I(1);

    private final int integerValue;

    /**
     * Contains all the elements in descending integer value.
     */
    private static final TreeMap<Integer, RomanNumeralComponents> VALUES_ORDERED_DESC;

    static {
        // Initialize and populate VALUES_ORDERED_DESC.
        VALUES_ORDERED_DESC = new TreeMap<>(Collections.reverseOrder());
        for (RomanNumeralComponents enumValue : RomanNumeralComponents.values()) {
            VALUES_ORDERED_DESC.put(enumValue.getIntegerValue(), enumValue);
        }
    }

    /**
     * Returns all the values in RomanNumeralComponents ordered by descending integer value.
     */
    public static TreeMap<Integer, RomanNumeralComponents> getValuesOrderedDesc() {
        return VALUES_ORDERED_DESC;
    }

    public int getIntegerValue() {
        return integerValue;
    }

    RomanNumeralComponents(int integerValue) {
        this.integerValue = integerValue;
    }
}
