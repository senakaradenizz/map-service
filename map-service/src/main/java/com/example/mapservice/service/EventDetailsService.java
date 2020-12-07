/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.repository.EventDetailsRepository;
import com.example.mapservice.model.EventDetailsEntity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class EventDetailsService extends BaseServiceImpl{
    
    @Autowired
    private EventDetailsRepository eventDetailsRepository;

    public EventDetailsService(EventDetailsRepository eventDetailsRepository) {
        super(eventDetailsRepository);
    }
    
    public ResponseEntity<EventDetailsEntity> getEventDetailsById(Long eventDetailsId)
            throws ResourceNotFoundException {
	EventDetailsEntity eventDetailsEntity = eventDetailsRepository.findById(eventDetailsId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Event details not found for this id : " + eventDetailsId));
	return ResponseEntity.ok().body(eventDetailsEntity);
    }
}
