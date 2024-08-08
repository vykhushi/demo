package com.reimbursement.indto;


import jakarta.validation.constraints.NotBlank;

public class UserRequest
{

    @NotBlank(message = "name is mandatory")
    private String userName;

    @NotBlank(message = "email is mandatory")
    private String userEmail;

    private String managerId;

    @NotBlank(message = "role is mandatory")
    private String userRole;

    @NotBlank(message = "password is mandatory")
    private String userPassword;

    @NotBlank(message = "department is mandatory")
    private String userDepartment;

    // Getters and Setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }
}

