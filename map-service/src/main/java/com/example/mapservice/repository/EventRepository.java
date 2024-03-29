/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.EventEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EventRepository extends BaseRepository<EventEntity, Long>{
    @Query(
        value = "SELECT * FROM EVENT e WHERE e.latitude < ?1 AND e.latitude > ?2 "
                + "AND e.longitude < ?3 AND e.longitude > ?4", 
                nativeQuery = true)
    List<EventEntity> findAllEventsInBounds(Double northEastLat, 
                                            Double southWestLat,
                                            Double northEastLng,
                                            Double southWestLng);
    
}