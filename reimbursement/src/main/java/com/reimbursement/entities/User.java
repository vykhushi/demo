package com.reimbursement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "users")  // Specify the table name if it differs from the class name
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

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

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String department) {
        this.userDepartment = department;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public void setUserRole(String  userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName) && Objects.equals(userEmail, user.userEmail) && Objects.equals(managerId, user.managerId) && Objects.equals(userRole, user.userRole) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userDepartment, user.userDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, managerId, userRole, userPassword, userDepartment);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", managerId='" + managerId + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userDepartment='" + userDepartment + '\'' +
                '}';
    }
}