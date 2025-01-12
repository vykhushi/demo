package com.reimbursement.repository;
import com.reimbursement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Department,Long> {
   Boolean existsByDepartmentName(String departmentName);
}
