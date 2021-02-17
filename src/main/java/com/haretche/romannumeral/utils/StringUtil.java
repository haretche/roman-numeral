package com.haretche.romannumeral.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for Strings.
 */
public final class StringUtil {

    private static final Logger LOG = LoggerFactory.getLogger(StringUtil.class);

    private StringUtil() {
        // Util classes shouldn't be instantiated.
    }

    /**
     * Tries to parse the provided value into an integer.
     *
     * @param value string containing an integer.
     * @return Integer parsed from the provided value string. Or null if it is not an integer.
     */
    public static Integer tryParseInt(String value) {
        if (value == null) {
            LOG.info("Attempted to parse null.");
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            LOG.info("NumberFormatException was thrown. Attempted to parse a non-integer value. More info in debug.");
            LOG.debug("More info about NumberFormatException here.", e);
            return null;
        }
    }
}
