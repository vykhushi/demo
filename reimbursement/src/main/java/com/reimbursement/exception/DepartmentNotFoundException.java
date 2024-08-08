package com.reimbursement.exception;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id)
    {
        super("Department not found with ID: " + id);
    }
}