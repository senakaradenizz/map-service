/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.controller;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.service.EventDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mapservice.model.EventDetailsEntity;
import com.example.mapservice.model.EventEntity;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/mapservice")
public class EventDetailsController implements BaseController{
    
    private EventDetailsService eventDetailsService;
    
    @Autowired
    public EventDetailsController(EventDetailsService eventDetailsService) {
        this.eventDetailsService = eventDetailsService;
    }
    
    @GetMapping("/eventdetails/{eventId}")  
    @Override
    public List<EventDetailsEntity> findById(@PathVariable Long eventId) throws ResourceNotFoundException{
        return eventDetailsService.getEventDetailsByEventId(eventId);
    }
    
    @GetMapping("/eventdetails/{eventIdList}/{type}")  
    public List<EventDetailsEntity> findByType(@PathVariable List<Long> eventIdList, @PathVariable String type) 
            throws ResourceNotFoundException{
        return eventDetailsService.getEventDetailsByType(eventIdList, type);
    }
}