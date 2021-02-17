package com.haretche.romannumeral.errorhandling.exceptions;

/**
 * Indicates that a requested resource cannot be found.
 * This class is currently not used. It was included to show how errors should be handled in this code base.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}