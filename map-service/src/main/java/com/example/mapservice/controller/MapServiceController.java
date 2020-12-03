/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.Country;
import com.example.mapservice.model.Province;
import com.example.mapservice.model.Subprovince;
import com.example.mapservice.model.Coordinate;
import com.example.mapservice.service.MapService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MapServiceController {
    
    @Autowired
    private MapService mapService;
    
    @GetMapping("/countries")
    public List<Country> findAllCountries(){
        return mapService.getAllCountries();
    }

    @GetMapping("/countries/{id}")
    public ResponseEntity<Country> findCountryById(@PathVariable(value = "id") Long countryId){
        try {
            return mapService.getCountryById(countryId);
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(MapServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GetMapping("/provinces")
    public List<Province> findAllProvinces(){
        return mapService.getAllProvinces();
    }
    
    @GetMapping("/provinces/{id}")
    public ResponseEntity<Province> findProvinceById(@PathVariable(value = "id") Long provinceId){
        try {
            return mapService.getProvinceById(provinceId);
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(MapServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GetMapping("/subprovinces")
    public List<Subprovince> findAllSubprovinces(){
        return mapService.getAllSubprovinces();
    }
    
    @GetMapping("/subprovinces/{id}")
    public ResponseEntity<Subprovince> findSubprovinceById(@PathVariable(value = "id") Long subprovinceId){
        try {
            return mapService.getSubprovinceById(subprovinceId);
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(MapServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GetMapping("/coordinates")
    public List<Coordinate> findAllCoordinates(){
        return mapService.getAllCoordinates();
    }
    
    @GetMapping("/coordinates/{id}")
    public ResponseEntity<Coordinate> findCoordinateById(@PathVariable(value = "id") Long coordinateId){
        try {
            return mapService.getCoordinateById(coordinateId);
        } catch (ResourceNotFoundException ex) {
            Logger.getLogger(MapServiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
