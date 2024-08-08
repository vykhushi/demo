package com.reimbursement.exception;

public class ExceptionHandler {

    public static class EmailAlreadyExists extends Exception{
        public EmailAlreadyExists(){
            super("Email Already Exist");
        }
    }
}

