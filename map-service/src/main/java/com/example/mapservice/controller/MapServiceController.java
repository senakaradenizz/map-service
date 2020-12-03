/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.repository.CoordinateRepository;
import com.example.mapservice.repository.CountryRepository;
import com.example.mapservice.repository.ProvinceRepository;
import com.example.mapservice.repository.SubprovinceRepository;
import com.example.mapservice.model.Country;
import com.example.mapservice.model.Province;
import com.example.mapservice.model.Subprovince;
import com.example.mapservice.model.Coordinate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class MapServiceController {
    
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    ProvinceRepository provinceRepository;
    @Autowired
    SubprovinceRepository subprovinceRepository;
    @Autowired
    CoordinateRepository coordinateRepository;
  
    @GetMapping
    List<Country> customers() {
        return countryRepository.findAll();
    }
    
    @GetMapping("/countries")
    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }
    
    @GetMapping("/provinces")
    public List<Province> getAllProvinces(){
        return provinceRepository.findAll();
    }
    
    @GetMapping("/subprovinces")
    public List<Subprovince> getAllSubprovinces(){
        return subprovinceRepository.findAll();
    }
    
    @GetMapping("/coordinates")
    public List<Coordinate> getAllCoordinates(){
        return coordinateRepository.findAll();
    }
}
