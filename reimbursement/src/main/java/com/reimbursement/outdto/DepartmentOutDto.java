package com.reimbursement.outdto;

import com.reimbursement.entities.Department;

public class DepartmentOutDto {
    private Department department;
    private String message;

    public DepartmentOutDto(Department department, String message){
            this.department=department;
            this.message=message;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
