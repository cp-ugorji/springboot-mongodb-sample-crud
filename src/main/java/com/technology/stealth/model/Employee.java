/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Chukwudi Ugorji
 */
@Document(collection = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    
    @Id
    private long id;
    
    @NotBlank(message = "First name cannot be empty")
    @Min(value = 2, message = "First name must be more than a character")
    @Max(value = 50, message = "First name must not be more than 50 character")
    @Size(min = 2, max = 50)
    private String firstName;
    
    @NotBlank(message = "Last name cannot be empty")
    @Min(value = 2, message = "Last name must be more than a character")
    @Max(value = 50, message = "Last name must not be more than 50 character")
    @Size(min = 2, max = 50)
    private String lastName;
    
    private String otherName;
    
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email is not valid")
    @Size(max = 100)
    @Indexed(unique = true)
    private String email;
    
    @NotBlank(message = "Phone number cannot be empty")
    @Size(max = 14)
    @Indexed(unique = true)
    private String phone;
}
