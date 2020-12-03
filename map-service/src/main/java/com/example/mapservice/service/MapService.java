/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.Coordinate;
import com.example.mapservice.model.Subprovince;
import com.example.mapservice.model.Province;
import com.example.mapservice.model.Country;
import com.example.mapservice.repository.CoordinateRepository;
import com.example.mapservice.repository.CountryRepository;
import com.example.mapservice.repository.ProvinceRepository;
import com.example.mapservice.repository.SubprovinceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


public class MapService {
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    @Autowired
    private SubprovinceRepository subprovinceRepository;
        
    @Autowired
    private CoordinateRepository coordinateRepository;
    
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    
    public ResponseEntity<Country> getCountryById(Long countryId)
            throws ResourceNotFoundException {
	Country country = countryRepository.findById(countryId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id : " + countryId));
	return ResponseEntity.ok().body(country);
    }
    
    public List<Province> getAllProvinces(){
        return provinceRepository.findAll();
    }
    
    public ResponseEntity<Province> getProvinceById(Long provinceId)
            throws ResourceNotFoundException {
	Province province = provinceRepository.findById(provinceId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Province not found for this id : " + provinceId));
	return ResponseEntity.ok().body(province);
    }
    
    public List<Subprovince> getAllSubprovinces(){
        return subprovinceRepository.findAll();
    }
    
    public ResponseEntity<Subprovince> getSubprovinceById(Long subprovinceId)
            throws ResourceNotFoundException {
	Subprovince subprovince = subprovinceRepository.findById(subprovinceId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Subprovince not found for this id : " + subprovinceId));
	return ResponseEntity.ok().body(subprovince);
    }
    
    public List<Coordinate> getAllCoordinates(){
        return coordinateRepository.findAll();
    }
    
    public ResponseEntity<Coordinate> getCoordinateById(Long coordinateId)
            throws ResourceNotFoundException {
	Coordinate coordinate = coordinateRepository.findById(coordinateId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Coordinate not found for this id : " + coordinateId));
	return ResponseEntity.ok().body(coordinate);
    }
}
