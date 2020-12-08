/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.CoordinateEntity;
import com.example.mapservice.repository.CoordinateRepository;
import java.util.List;
import java.util.Optional;
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
    
    public List<CoordinateEntity> getCoordinateBySubprovinceId(Long subprovinceId)
            throws ResourceNotFoundException {
	Optional<List<CoordinateEntity>> coordinate = coordinateRepository.findBySubprovinceId(subprovinceId);
        if(coordinate.isPresent()){
            return coordinate.get();
        }return null;
        
    }
}
