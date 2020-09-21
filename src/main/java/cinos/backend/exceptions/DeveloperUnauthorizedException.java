package cinos.backend.exceptions;

public class DeveloperUnauthorizedException extends Exception{
    private static final String ERROR_MESSAGE = "Unauthorized";

    public DeveloperUnauthorizedException (){
        super(ERROR_MESSAGE);
    }
}
