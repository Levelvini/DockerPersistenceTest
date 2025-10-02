package com.levelVini.DockerPersistenceTest.exceptions;

public class ResourseNotFound extends RuntimeException{
    public ResourseNotFound(String message) {
        super(message);
    }
}
