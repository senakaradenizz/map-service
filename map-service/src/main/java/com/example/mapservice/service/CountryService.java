/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.model.CountryEntity;
import com.example.mapservice.repository.CountryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryService extends BaseServiceImpl{
    
    @Autowired
    private CountryRepository countryRepository;
    
    
    public CountryService(CountryRepository countryRepository) {
        super(countryRepository);
    }
    
    public List<CountryEntity> getAllCountries(){
        List<CountryEntity> resultList= countryRepository.findAll();
        return resultList;
    }
}
