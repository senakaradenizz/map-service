/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.model.CountryEntity;
import com.example.mapservice.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapservice")
public class CountryController{
    
    private CountryService countryService;
    
    @Autowired
    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }
    
    @GetMapping("/countries")
    public List<CountryEntity> findAll(){
    
        return countryService.getAllCountries();
    }
   
}
