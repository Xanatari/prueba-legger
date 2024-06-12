package com.example.exceptions;


public class InsufficientCapacityException extends RuntimeException {
    public InsufficientCapacityException(String message) {
        super(message);
    }
}