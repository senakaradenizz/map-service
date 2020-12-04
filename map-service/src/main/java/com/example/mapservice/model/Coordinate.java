/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter @Setter 
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"latitude", "longitude", "subprovinceId"})
@Table(name = "coordinate")
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinate_id")
    private Long coordinateId;
    
    @ToString.Exclude
    @Column(name = "latitude")
    private Integer latitude;
    
    @ToString.Exclude
    @Column(name = "longitude")
    private Integer longitude;
    
    @ToString.Exclude
    @JoinColumn(name = "subprovince_id", referencedColumnName = "subprovince_id")
    @ManyToOne
    private Subprovince subprovinceId;

    public Coordinate(Integer latitude, Integer longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}