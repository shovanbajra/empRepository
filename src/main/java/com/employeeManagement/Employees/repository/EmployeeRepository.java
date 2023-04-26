package com.employeeManagement.Employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeManagement.Employees.entity.Employ;

@Repository
public interface EmployeeRepository extends JpaRepository<Employ, Integer> {
	List<Employ> findByEmpDesignation(String empDesignation);

	
	
	
	
	
}
