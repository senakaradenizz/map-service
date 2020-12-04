/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.ProvinceEntity;
import com.example.mapservice.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProvinceService extends BaseServiceImpl{
    
    @Autowired
    private ProvinceRepository provinceRepository;
    
    
    public ProvinceService(ProvinceRepository provinceRepository) {
        super(provinceRepository);
    }
    
    
    public ResponseEntity<ProvinceEntity> getProvinceById(Long provinceId)
            throws ResourceNotFoundException {
	ProvinceEntity province = provinceRepository.findById(provinceId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Province not found for this id : " + provinceId));
	return ResponseEntity.ok().body(province);
    }
}