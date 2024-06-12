package com.game;

public class IncorrectPositionException extends RuntimeException {
    public IncorrectPositionException(String format) {
        System.out.println(format);
    }
}
