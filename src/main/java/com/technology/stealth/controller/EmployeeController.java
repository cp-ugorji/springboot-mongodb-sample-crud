/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.controller;

import com.technology.stealth.exception.ResourceNotFoundException;
import com.technology.stealth.model.Employee;
import com.technology.stealth.repository.EmployeeRepository;
import com.technology.stealth.service.SequenceGeneratorService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Chukwudi Ugorji
 */

@RestController
@RequestMapping("api/v1")
//@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
    @Autowired
    private EmployeeRepository _employeeRepository;
    
    @Autowired
    private SequenceGeneratorService _sequenceGeneratorService;
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        //get all employee from the database
        return _employeeRepository.findAll();
    }
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        //check for employee with the said id
        Employee employee = _employeeRepository.findById(employeeId)
                //if not found, throw ResourceNotFoundException
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with the id :: " + employeeId));
        //if found return the detail
        return ResponseEntity.ok().body(employee);
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        employee.setId(_sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return _employeeRepository.save(employee);
    }
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, 
            @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
        //check for employee with the said id
        Employee employee = _employeeRepository.findById(employeeId)
                //if not found, throw ResourceNotFoundException
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with the id :: " + employeeId));
        
        //assigning updated values appropriately
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setOtherName(employeeDetails.getOtherName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPhone(employeeDetails.getPhone());
        
        //update record
        final Employee updatedEmployee = _employeeRepository.save(employee);
        
        //if found return the detail
        return ResponseEntity.ok().body(updatedEmployee);
    }
    
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        //check for employee with the said id
        Employee employee = _employeeRepository.findById(employeeId)
                //if not found, throw ResourceNotFoundException
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with the id :: " + employeeId));
        
        _employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
