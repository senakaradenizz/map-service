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
    private String type;
    
    @Column(name = "subtype")
    private String subtype;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "priority")
    private Integer priority;
    
    @Column(name = "event_id")
    private Long eventId;
}