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
@Table(name = "subprovince")
public class SubprovinceEntity extends BaseEntity{
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "province_id")
    private Long provinceId;
}
