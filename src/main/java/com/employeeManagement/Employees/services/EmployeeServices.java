package com.employeeManagement.Employees.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.employeeManagement.Employees.entity.Employ;
import com.employeeManagement.Employees.repository.EmployeeRepository;

@Service
public class EmployeeServices {
@Autowired
private EmployeeRepository employeeRepository;
public List<Employ> showAllEmploys(){
	return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, ("empName"))); 

}
public void saveEmploy(Employ employ){	
	 employeeRepository.save(employ);

}
public Employ searchEmploy(int empId){
	try {
	return employeeRepository.findById(empId).get();
	}
	catch(Exception e){
	return null;
	}
	}
	
public void deleteEmploy(Employ employ) {
	employeeRepository.delete(employ);
}
public void updateEmploy(Employ employ){	
	 employeeRepository.save(employ);

}
public List<Employ> showAllEmpDesignation(String empDesignation){
	return employeeRepository.findByEmpDesignation(empDesignation);
}
}
	
	

