/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.repository.EventDetailsRepository;
import com.example.mapservice.model.EventDetailsEntity;
import com.example.mapservice.model.EventEntity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<EventDetailsEntity> getEventDetailsByType(List<Long> eventIdList, String type) {
        List<EventDetailsEntity> eventDetailsInCircleList = new ArrayList<>();
        for(Integer i=0; i < eventIdList.size(); i++){
            Long eventId = eventIdList.get(i);
            Optional<List<EventDetailsEntity>> eventDetails = eventDetailsRepository.findByEventId(eventId);
            if(eventDetails.isPresent()){
                List<EventDetailsEntity> eventDetailsList = eventDetails.get();
                for(Integer j=0; j < eventDetailsList.size(); j++){
                    if("default".equals(type)){
                        eventDetailsInCircleList.add(eventDetailsList.get(j));
                    } else {
                        String eventType = eventDetailsList.get(j).getType().replaceAll("\\s","").toLowerCase();
                        if(eventType == null ? type == null : eventType.equals(type)){
                            eventDetailsInCircleList.add(eventDetailsList.get(j));
                        }
                    }

                }  
            }
        }
        return eventDetailsInCircleList;
    }
}
