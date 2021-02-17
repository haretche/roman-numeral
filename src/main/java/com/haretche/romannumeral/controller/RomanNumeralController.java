package com.haretche.romannumeral.controller;

import com.haretche.romannumeral.errorhandling.exceptions.BadRequestException;
import com.haretche.romannumeral.model.RomanNumeralResponse;
import com.haretche.romannumeral.utils.RomanNumeralUtil;
import com.haretche.romannumeral.utils.StringUtil;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle REST endpoints related to Roman Numerals.
 */
@RestController
public class RomanNumeralController {

    private static final Logger LOG = LoggerFactory.getLogger(RomanNumeralController.class);

    protected static final String ERROR_NO_QUERY = "Please provide a 'query' parameter.";
    protected static final String ERROR_QUERY_NOT_INT = "Please provide an integer value for 'query'";
    protected static final String ERROR_QUERY_OUT_OF_RANGE = "Please provide a 'query' in the range [1-3999].";

    /**
     * Get endpoint that receives an integer and calculates the roman numeral representation for it.
     *
     * @param query Query parameter with the integer that needs to be converted. Marked as not required to be able to
     *              display a relevant error message when the param is missing.
     * @return A Json with the following format: { "input" : "1", "output" : "I" }.
     * If provided input is invalid, then it returns an error message as plain text and status code 400 (bad request).
     */
    @Timed(
            value = "romannumeral.get.request",
            histogram = true,
            percentiles = {0.95, 0.99},
            extraTags = {"version", "1.0"}
    )
    @GetMapping("/romannumeral")
    public RomanNumeralResponse romanNumeral(@RequestParam(required = false) String query) {
        if (query == null) {
            LOG.info("Bad request: 'query' param is missing.");
            throw new BadRequestException(ERROR_NO_QUERY);
        }
        Integer input = StringUtil.tryParseInt(query);
        if (input == null) {
            LOG.info("Bad request: 'query' is not an integer.");
            throw new BadRequestException(ERROR_QUERY_NOT_INT);
        }
        if (!RomanNumeralUtil.isSupported(input)) {
            LOG.info("Bad request: 'query' is out of range.");
            throw new BadRequestException(ERROR_QUERY_OUT_OF_RANGE);
        }
        String output = RomanNumeralUtil.fromInt(input);
        return new RomanNumeralResponse(input, output);
    }
}
