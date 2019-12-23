/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Chukwudi Ugorji
 */
@Document(collection = "db_sequence")
@Data
@NoArgsConstructor
public class DBSequence {
    @Id
    private String id;
    private long seq;
}
