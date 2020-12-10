/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.EventEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends BaseRepository<EventEntity, Long>{
    @Query(
        value = "SELECT * FROM EVENT e WHERE e.latitude < :northEastLat AND e.latitude > :southWestLat"
                + "AND e.longitude < :northEastLng AND e.longitude > :southWestLng", 
                nativeQuery = true)
    List<EventEntity> findAll(@Param("northEastLat") Integer northEastLat, 
                              @Param("southWestLat") Integer southWestLat,
                              @Param("northEastLng") Integer northEastLng,
                              @Param("southWestLng") Integer southWestLng);
}