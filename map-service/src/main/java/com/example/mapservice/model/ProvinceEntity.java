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
@Table(name = "province")
public class ProvinceEntity extends BaseEntity{
    
    @Column(name = "name")
    private String provinceName;
    
    @Column(name = "country_id")
    private Long countryId;
}
