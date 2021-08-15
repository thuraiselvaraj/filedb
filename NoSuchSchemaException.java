package com.filedb;
public class NoSuchSchemaException extends Exception {
    public NoSuchSchemaException(String message){
        super(message);
    }
}
