/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.EventEntity;
import com.example.mapservice.repository.EventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EventService extends BaseServiceImpl{
    
    @Autowired
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        super(eventRepository);
    }
    
    public ResponseEntity<EventEntity> getEventById(Long eventId)
            throws ResourceNotFoundException {
	EventEntity eventEntity = eventRepository.findById(eventId)
                                    .orElseThrow(() -> new ResourceNotFoundException("Event not found for this id : " + eventId));
	return ResponseEntity.ok().body(eventEntity);
    }
    
    public List<EventEntity> getAllEventsInRange(){
        List<EventEntity> resultList= eventRepository.findAll();
        return resultList;
    }
    
    
}