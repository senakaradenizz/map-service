/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.ProvinceEntity;
import com.example.mapservice.repository.ProvinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProvinceService extends BaseServiceImpl{
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    
    public ProvinceService(ProvinceRepository provinceRepository) {
        super(provinceRepository);
    }
    
    public List<ProvinceEntity> getProvinceByCountryId(Long countryId)
            throws ResourceNotFoundException {
	Optional<List<ProvinceEntity>> province = provinceRepository.findByCountryId(countryId);
        if(province.isPresent()){
            return province.get();
        }return null;   
    }
}
