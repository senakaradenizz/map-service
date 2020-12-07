/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "coordinate")
public class CoordinateEntity extends BaseEntity{

    @Column(name = "latitude")
    private Integer latitude;
    
    @Column(name = "longitude")
    private Integer longitude;
    
    @Column(name = "subprovince_id")
    private Long subprovinceId;
}