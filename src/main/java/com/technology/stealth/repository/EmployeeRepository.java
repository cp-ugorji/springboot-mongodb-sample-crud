/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.repository;

import com.technology.stealth.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Chukwudi Ugorji
 */

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Long>{
    
}
