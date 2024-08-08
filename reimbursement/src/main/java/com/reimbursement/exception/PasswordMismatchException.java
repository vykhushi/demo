package com.reimbursement.exception;

public class PasswordMismatchException  extends RuntimeException {
    public PasswordMismatchException(String userPassword) {
        super("Password does not match");
    }
}
