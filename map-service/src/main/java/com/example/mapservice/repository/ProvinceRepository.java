/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.ProvinceEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvinceRepository extends BaseRepository<ProvinceEntity, Long>{
    
}