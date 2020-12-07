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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    
    @GetMapping("/eventdetails/{id}")
    @Override
    public ResponseEntity<EventDetailsEntity> findById(@PathVariable Long id) throws ResourceNotFoundException{
        return eventDetailsService.getEventDetailsById(id);
    }
}