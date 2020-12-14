/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.CoordinateEntity;
import com.example.mapservice.service.CoordinateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapservice")
public class CoordinateController implements BaseController{
    
    private CoordinateService coordinateService;
    
    @Autowired
    public CoordinateController(CoordinateService coordinateService) {
        this.coordinateService = coordinateService;
    }
    
    @GetMapping("/coordinates/{subprovinceId}")
    @Override
    public List<CoordinateEntity> findById(@PathVariable Long subprovinceId) throws ResourceNotFoundException{
        return coordinateService.getCoordinateBySubprovinceId(subprovinceId);
    }
}
