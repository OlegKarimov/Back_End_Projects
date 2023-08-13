package de.ait.taskslist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

/**
 * 8/9/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class ForbiddenFieldException extends RestException {

    public ForbiddenFieldException(String field) {
        super(HttpStatus.FORBIDDEN, "Cannot work with <" + field + ">");
    }

}

