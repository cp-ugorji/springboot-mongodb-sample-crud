/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.technology.stealth.service;

import com.technology.stealth.model.DBSequence;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chukwudi Ugorji
 */
@Service
public class SequenceGeneratorService {
    private final MongoOperations _mongoOperations;
    
    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations){
        this._mongoOperations = mongoOperations;
    }
    
    public long generateSequence(String sequenceName){
        DBSequence dbSequenceCounter = _mongoOperations.findAndModify(query(where("_id").is(sequenceName)), 
                new Update().inc("seq", 1), 
                options().returnNew(true).upsert(true), 
                DBSequence.class);
        return !Objects.isNull(dbSequenceCounter) ? dbSequenceCounter.getSeq() : 1;
    }
}
