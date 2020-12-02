/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter @Setter 
@NoArgsConstructor @AllArgsConstructor 
@ToString
@EqualsAndHashCode(exclude = {"provinceName", "subprovinceList", "countryId"})
@Table(name = "province")
@NamedQueries({
    @NamedQuery(name = "Province.findAll", query = "SELECT p FROM Province p")})
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "province_id")
    private long provinceId;
    
    @ToString.Exclude
    @Column(name = "province_name")
    private String provinceName;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "provinceId")
    private List<Subprovince> subprovinceList;
    
    @ToString.Exclude
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne
    private Country countryId;
}