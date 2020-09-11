package cinos.backend.exceptions;

public class MissingTypeException extends Exception {

    private static final String ERROR_MESSAGE = "Strange type";

    public MissingTypeException(){
        super(ERROR_MESSAGE);
    }

}
