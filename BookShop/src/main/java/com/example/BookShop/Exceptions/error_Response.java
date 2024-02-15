package com.example.BookShop.Exceptions;

import java.time.LocalDate;
import java.util.List;

public class error_Response {

    public boolean success;
    public LocalDate localDate;
    public String message;
    public List<String> details;

    public error_Response(String message,List<String> details) {
        this.details = details;
        this.message=message;
        this.success=Boolean.FALSE;
        this.localDate=LocalDate.now();
    }


}
