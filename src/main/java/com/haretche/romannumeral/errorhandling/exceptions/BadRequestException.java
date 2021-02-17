package com.haretche.romannumeral.errorhandling.exceptions;

/**
 * Indicates that the server will not process a request due to something perceived to be a user/client error.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}