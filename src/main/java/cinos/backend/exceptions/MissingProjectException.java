package cinos.backend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "no such project")
public class MissingProjectException extends Exception {

    private static final String ERROR_MESSAGE = "Project not found";

    public MissingProjectException(){
        super(ERROR_MESSAGE);
    }

}
