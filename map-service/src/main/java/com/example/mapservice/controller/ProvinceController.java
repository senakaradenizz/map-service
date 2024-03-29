/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.ProvinceEntity;
import com.example.mapservice.service.ProvinceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mapservice")
public class ProvinceController implements BaseController{
    
    private ProvinceService provinceService;
    
    @Autowired
    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @GetMapping("/provinces/{countryId}")
    @Override
    public List<ProvinceEntity> findById(@PathVariable Long countryId) throws ResourceNotFoundException{
        return provinceService.getProvinceByCountryId(countryId);
    }
}
