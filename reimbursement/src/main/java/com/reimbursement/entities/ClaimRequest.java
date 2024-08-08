package com.reimbursement.entities;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class ClaimRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimFormId;
    private int expenseAmount;
    private String expenseType;
    private String managerComment;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerComment() {
        return managerComment;
    }

    public void setManager_comment(String manager_comment) {
        this.managerComment = managerComment;
    }


    public Long getClaimFormId() {
        return claimFormId;
    }

    public void setClaimFormId(Long claimFormId) {
        this.claimFormId = claimFormId;
    }
    public int getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(int expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaimRequest that = (ClaimRequest) o;
        return expenseAmount == that.expenseAmount && Objects.equals(claimFormId, that.claimFormId) && Objects.equals(expenseType, that.expenseType) && Objects.equals(managerComment, that.managerComment) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claimFormId, expenseAmount, expenseType, managerComment, status);
    }

    @Override
    public String toString() {
        return "ClaimRequest{" +
                "claimFormId=" + claimFormId +
                ", expenseAmount=" + expenseAmount +
                ", expenseType='" + expenseType + '\'' +
                ", managerComment='" + managerComment + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
