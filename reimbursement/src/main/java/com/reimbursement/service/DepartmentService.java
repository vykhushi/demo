package com.reimbursement.service;
import com.reimbursement.outdto.DepartmentOutDto;
import com.reimbursement.entities.Department;
import com.reimbursement.exception.DepartmentAlreadyExistsException;
import com.reimbursement.exception.DepartmentNotFoundException;
import com.reimbursement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List <Department> getDepartment(){
        List<Department> list= new ArrayList();
        list= departmentRepository.findAll();
        return list;
    }

    public DepartmentOutDto addDepartment(Department department) {

        Department savedDepartment;
//        System.err.println(department.getDepartmentName());
        if (departmentRepository.existsByDepartmentName(department.getDepartmentName())) {
            throw new DepartmentAlreadyExistsException(department.getDepartmentName());
        }
            savedDepartment = departmentRepository.save(department);
            return new DepartmentOutDto(savedDepartment, "Department created");
            // return savedDepartment;
    }

    public boolean deleteDepartment(Long departmentId){
        departmentRepository.deleteById(departmentId);
        if (!departmentRepository.existsById(departmentId)) {
            throw new DepartmentNotFoundException(departmentId);
        }
        else {
            departmentRepository.deleteById(departmentId);
        }
        return true;
    }
}

