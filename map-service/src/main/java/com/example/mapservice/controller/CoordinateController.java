/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.CoordinateEntity;
import com.example.mapservice.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapservice")
public abstract class CoordinateController implements BaseController {
    
    private CoordinateService coordinateService;
    
    @Autowired
    public CoordinateController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }
    
    @GetMapping("/coordinates/{id}")
    public ResponseEntity<CoordinateEntity> findById(@PathVariable(value = "id") Long coordinateId) throws ResourceNotFoundException{
        return coordinateService.getCoordinateById(coordinateId);
    }
}
