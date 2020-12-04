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
@Table(name = "country")
public class CountryEntity extends BaseEntity {

    @Column(name = "country_name")
    private String countryName;
}