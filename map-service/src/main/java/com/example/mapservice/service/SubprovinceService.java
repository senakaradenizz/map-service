/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.SubprovinceEntity;
import com.example.mapservice.repository.SubprovinceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubprovinceService extends BaseServiceImpl{
    
    @Autowired
    private SubprovinceRepository subprovinceRepository;
    
    
    public SubprovinceService(SubprovinceRepository subprovinceRepository) {
        super(subprovinceRepository);
    }
    
    public List<SubprovinceEntity> getSubprovinceByProvinceId(Long provinceId)
            throws ResourceNotFoundException {
	Optional<List<SubprovinceEntity>> subprovince = subprovinceRepository.findByProvinceId(provinceId);
        if(subprovince.isPresent()){
            return subprovince.get();
        }return null;
        
    }
}
