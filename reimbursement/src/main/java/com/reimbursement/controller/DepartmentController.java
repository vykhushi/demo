package com.reimbursement.controller;


import com.reimbursement.outdto.DepartmentOutDto;
import com.reimbursement.entities.Department;
import com.reimbursement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> list = departmentService.getDepartment();
        if (!list.isEmpty()) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentOutDto> addDepartments(@RequestBody Department department){
        DepartmentOutDto departmentResponse=departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponse);
    }

    @DeleteMapping("/deleteDepartment/{departmentId}")
    public ResponseEntity<DepartmentOutDto> deleteDepartment(@PathVariable("departmentId") Long departmentId) {
        boolean isdeleted =departmentService.deleteDepartment(departmentId);
        if (isdeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}




