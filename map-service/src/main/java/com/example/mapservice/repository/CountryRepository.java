/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mapservice.model.Country;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sena
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    
}
