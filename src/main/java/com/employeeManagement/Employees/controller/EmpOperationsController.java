package com.employeeManagement.Employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeManagement.Employees.entity.Employ;
import com.employeeManagement.Employees.services.EmployeeServices;

@RestController

public class EmpOperationsController {
	@Autowired 
	private EmployeeServices employeeServices;
	
	
	@GetMapping("/showAll")
	
	public List<Employ> showAllEmp(){
	
	return employeeServices.showAllEmploys();
		
		
	}
	
	@PostMapping("/addEmploy")

	public String saveEmploy(@RequestBody Employ employ){
	employeeServices.saveEmploy(employ);
	return "Successfully Inserted";
	}
	
	@GetMapping ("/searchEmploy/{empid}")
	public ResponseEntity<?> searchEmploy(@PathVariable ("empid" ) int empid){
	Employ employ = employeeServices.searchEmploy(empid);
	if(employ != null) {
		return new ResponseEntity<Employ>(employ, HttpStatus.OK);
	}
	else return new ResponseEntity<String>("No Record Found with "+ empid , HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp/{empid}")
	
	public String deleteEmploy (@PathVariable ("empid" ) int empid){
		Employ employ = employeeServices.searchEmploy(empid);
		if(employ != null) {
			employeeServices.deleteEmploy(employ);
			return "Record Deleted successfully...";
		}
		else return "No Record Found with "+ empid ;	
	}
	
	@PutMapping("/updateEmploy")

	public String updateEmploy(@RequestBody Employ employ){
		Employ emp = employeeServices.searchEmploy(employ.getEmpId());
		if(emp != null) {
			emp.setEmpName(employ.getEmpName());
			emp.setEmpDesignation(employ.getEmpDesignation());
			emp.setSalary(employ.getSalary());
			employeeServices.updateEmploy(emp);
			return "Record Uodated successfully...";
		}
		else return "No Record Found with "+ employ.getEmpId() ;
	
	}
	@GetMapping("/showAllByDesignation/{empDesignation}")
	public List<Employ> showAllEmpDesignation(@PathVariable ("empDesignation") String empDesignation){
		
		return employeeServices.showAllEmpDesignation(empDesignation);
		}
	@GetMapping("/test")
	public String sayHello(){
		return "gitResponse Method";
	}
	}


