package com.levelVini.DockerPersistenceTest.exceptions;

public class ResourseNotFoundException extends RuntimeException{
    public ResourseNotFoundException(String message) {
        super(message);
    }
}
