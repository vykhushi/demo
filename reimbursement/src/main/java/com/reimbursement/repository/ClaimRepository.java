package com.reimbursement.repository;
import com.reimbursement.entities.ClaimRequest;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClaimRepository extends JpaRepository<ClaimRequest,Long> {

}
