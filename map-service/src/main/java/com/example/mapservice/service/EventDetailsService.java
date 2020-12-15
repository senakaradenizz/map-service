/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.exception.ResourceNotFoundException;
import com.example.mapservice.repository.EventDetailsRepository;
import com.example.mapservice.model.EventDetailsEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public List<EventDetailsEntity> getEventDetailsByTypeAndOrDate(List<Long> eventIdList, 
                                                                   String type, Date startDate, 
                                                                   Date endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedStartDate = formatter.format(startDate);
        String formattedEndDate = formatter.format(endDate);
        List<EventDetailsEntity> eventDetailsInCircleFilteredList = new ArrayList<>();
        try {
            Long startDateInSeconds = formatter.parse(formattedStartDate).getTime() / 1000;
            Long endDateInSeconds = formatter.parse(formattedEndDate).getTime() / 1000;
            List<EventDetailsEntity> eventDetailsInCircleList = getEventDetailsByType(eventIdList, type);
            if(endDate == null || startDate == null){
                return eventDetailsInCircleList;
            } else {
                for(Integer i=0; i < eventDetailsInCircleList.size(); i++){
                    String formattedEventDate = formatter.format(eventDetailsInCircleList.get(i).getDate());
                    Long eventDateInSeconds = formatter.parse(formattedEventDate).getTime() / 1000;
                    if(eventDateInSeconds >= startDateInSeconds && eventDateInSeconds <endDateInSeconds){
                        eventDetailsInCircleFilteredList.add(eventDetailsInCircleList.get(i));
                    }
                }
                return eventDetailsInCircleFilteredList;
              }
            } catch (ParseException ex) {
                Logger.getLogger(EventDetailsService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
}
