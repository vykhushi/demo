package com.reimbursement.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException (String userEmail) {
        super("User with " + userEmail+ "not found");
    }
}
