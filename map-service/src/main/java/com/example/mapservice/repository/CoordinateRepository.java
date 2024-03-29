/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.CoordinateEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface CoordinateRepository extends BaseRepository<CoordinateEntity, Long>{
    Optional<List<CoordinateEntity>> findBySubprovinceId(Long id);
}
