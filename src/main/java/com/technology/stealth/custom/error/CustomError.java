/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.custom.error;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * I don't want to use the default spring-boot error that is why i created this custom error class
 * to show only what I want and not all the detail as shown by spring-boot default
 * @author Chukwudi Ugorji
 */

@Data
@AllArgsConstructor
public class CustomError {
    private Date timestamp;
    private String message;
    private String details;
}
