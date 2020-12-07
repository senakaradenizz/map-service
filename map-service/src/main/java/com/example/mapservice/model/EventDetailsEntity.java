/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "event_details")
public class EventDetailsEntity extends BaseEntity{
    
    @Column(name = "type")
    private String eventType;
    
    @Column(name = "subtype")
    private String eventSubtype;
    
    @Column(name = "latitude")
    private Integer latitude;
    
    @Column(name = "longitude")
    private Integer longitude;
    
    @Column(name = "date")
    private Date eventDate;
    
    @Column(name = "priority")
    private Integer eventPriority;
}