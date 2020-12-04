/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.SubprovinceEntity;
import com.example.mapservice.service.SubprovinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapservice")
public class SubprovinceController implements BaseController{
    
    private SubprovinceService subprovinceService;
    
    @Autowired
    public SubprovinceController(SubprovinceService subprovinceService) {
        this.subprovinceService = subprovinceService;
    }
    
    @GetMapping("/subprovinces/{id}")
    @Override
    public ResponseEntity<SubprovinceEntity> findById(@PathVariable Long id) throws ResourceNotFoundException{
        return subprovinceService.getSubprovinceById(id);
    }
}
