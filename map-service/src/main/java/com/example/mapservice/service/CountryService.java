/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.CountryEntity;
import com.example.mapservice.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CountryService extends BaseServiceImpl{
    
    @Autowired
    private CountryRepository countryRepository;
    
    
    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
    }
    
    public List<CountryEntity> getAllCountries(){
         
        return countryRepository.findAll();
    }
    
    public ResponseEntity<CountryEntity> getCountryById(Long countryId)
            throws ResourceNotFoundException {
	CountryEntity country = countryRepository.findById(countryId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Country not found for this id : " + countryId));
	return ResponseEntity.ok().body(country);
    }
}
