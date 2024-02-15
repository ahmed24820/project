package com.example.BookShop.Exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*  this is used to know spring that we are modifing the error that happens
* and we need to add a method with @exception_handler that has a class name that has the error dedict
* */
@ControllerAdvice
public class ExceptionHandeller extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Notfounded.class)
    public ResponseEntity<?> NotFounded_Response(Notfounded NT) {

        error_Response error = new error_Response(NT.getMessage(), Arrays.asList(NT.getMessage()));


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(DuplicatedError.class)
    public ResponseEntity<?> Duplicated_Response(DuplicatedError DT) {

        error_Response error = new error_Response(DT.getMessage(), Arrays.asList(DT.getMessage()
                , "u can use any email instead of that can we suggest one for u"));

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
            , HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors=new ArrayList<>();

        for (FieldError fieldError: ex.getBindingResult().getFieldErrors()){
            errors.add(fieldError.getDefaultMessage());
        }
        for (ObjectError Error: ex.getBindingResult().getGlobalErrors()){
            errors.add(Error.getDefaultMessage());
        }
        error_Response error = new error_Response(ex.toString(),errors);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
    }

