/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.CountryEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends BaseRepository<CountryEntity, Long> {
    
}