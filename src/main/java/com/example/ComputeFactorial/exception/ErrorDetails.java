package com.example.ComputeFactorial.exception;

import java.util.Date;

public class ErrorDetails {
    //data fields to handle error details
    private Date timestamp;
    private String message;
    private String details;


    /**
     * get field //data fields to handle error details
     *
     * @return timestamp //data fields to handle error details

     */
    public Date getTimestamp() {
        return this.timestamp;
    }

    /**
     * set field //data fields to handle error details
     *
     * @param timestamp //data fields to handle error details

     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * get field
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * set field
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * get field
     *
     * @return details
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * set field
     *
     * @param details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    //specified parameters constructor
    public ErrorDetails(Date timestamp, String message, String details){
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
