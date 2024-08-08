package com.reimbursement.exception;

public class ClaimFormNotFoundException extends RuntimeException {
    public ClaimFormNotFoundException(Long id) {
        super("Claim form not found with ID: " + id);
    }
}
