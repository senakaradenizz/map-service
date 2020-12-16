/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.model.EventEntity;
import com.example.mapservice.repository.EventRepository;
import java.util.ArrayList;
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

    public List<EventEntity> getAllEventsInRange(Double centeralLat, Double centeralLng, Double searchRadius) {
        final Double GLOBE_RADIUS = 6378.137;
        Double searchRadiusInKilometers = searchRadius / 1000;
        Double angularRadius = searchRadiusInKilometers / GLOBE_RADIUS;
        Double radCenteralLat = Math.toRadians(centeralLat);
        Double radCenteralLng = Math.toRadians(centeralLng);
        
        Double radSouthWestLat = radCenteralLat - angularRadius;
        Double radNorthEastLat = radCenteralLat + angularRadius;
        
        Double deltaLon = Math.asin(Math.sin(angularRadius) / Math.cos(radCenteralLat));
        
        Double radSouthWestLng = radCenteralLng - deltaLon;
        Double radNorthEastLng = radCenteralLng + deltaLon;
        
        Double southWestLat = (radSouthWestLat * 180) / Math.PI;
        Double northEastLat = (radNorthEastLat * 180) / Math.PI;
        Double southWestLng = (radSouthWestLng * 180) / Math.PI;
        Double northEastLng = (radNorthEastLng * 180) / Math.PI;
        
        List<EventEntity> eventListInBounds = eventRepository.findAllEventsInBounds(northEastLat, 
                                                                                    southWestLat, 
                                                                                    northEastLng, 
                                                                                    southWestLng);

        List<EventEntity> eventsInCircleList = new ArrayList<>();
        for(Integer i=0; i < eventListInBounds.size(); i++){
            Double distance = Math.acos(Math.sin(radCenteralLat) * Math.sin(Math.toRadians(eventListInBounds.get(i).getLatitude()))
                                        + Math.cos(radCenteralLat) * Math.cos(Math.toRadians(eventListInBounds.get(i).getLatitude()))
                                        * Math.cos((radCenteralLng - Math.toRadians(eventListInBounds.get(i).getLongitude()))))
                                        * GLOBE_RADIUS;
            if(distance < searchRadiusInKilometers){
                eventsInCircleList.add(eventListInBounds.get(i));
            }
        }

        return eventsInCircleList;
    }
}