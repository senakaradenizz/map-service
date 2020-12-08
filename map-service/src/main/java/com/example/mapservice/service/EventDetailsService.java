/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.repository.EventDetailsRepository;
import com.example.mapservice.model.EventDetailsEntity;
import java.util.List;
import java.util.Optional;


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
    
    public List<EventDetailsEntity> getEventDetailsByEventId(Long eventId)
            throws ResourceNotFoundException {
	Optional<List<EventDetailsEntity>> eventDetails = eventDetailsRepository.findByEventId(eventId);
        if(eventDetails.isPresent()){
            return eventDetails.get();
        }return null;   
    }
}
