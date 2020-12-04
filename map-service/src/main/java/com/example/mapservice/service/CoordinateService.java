/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.CoordinateEntity;
import com.example.mapservice.repository.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CoordinateService extends BaseServiceImpl{
    
    @Autowired
    private CoordinateRepository coordinateRepository;
    
    
    public CoordinateService(CoordinateRepository coordinateRepository) {
        super(coordinateRepository);
    }
    
    public ResponseEntity<CoordinateEntity> getCoordinateById(Long coordinateId)
            throws ResourceNotFoundException {
	CoordinateEntity coordinate = coordinateRepository.findById(coordinateId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Coordinate not found for this id : " + coordinateId));
	return ResponseEntity.ok().body(coordinate);
    }
}
