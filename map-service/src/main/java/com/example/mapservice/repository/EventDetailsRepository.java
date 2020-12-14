/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import com.example.mapservice.model.EventDetailsEntity;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EventDetailsRepository extends BaseRepository<EventDetailsEntity, Long>{
    Optional<List<EventDetailsEntity>> findByEventId(Long id);
    
//    @Query(value = "SELECT * FROM event_details e WHERE e.type == ?1 AND e.date == ?2", 
//           nativeQuery = true)
//    Optional<List<EventDetailsEntity>> findEventDetailsByTypeAndDate(String type, Date date);
    
}