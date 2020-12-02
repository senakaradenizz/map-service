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
@EqualsAndHashCode(exclude = {"subprovinceName", "coordinateList", "provinceId"})
@Table(name = "subprovince")
@NamedQueries({
    @NamedQuery(name = "Subprovince.findAll", query = "SELECT s FROM Subprovince s")})
public class Subprovince {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subprovince_id")
    private long subprovinceId;
    
    @ToString.Exclude
    @Column(name = "subprovince_name")
    private String subprovinceName;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "subprovinceId")
    private List<Coordinate> coordinateList;
    
    @ToString.Exclude
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    @ManyToOne
    private Province provinceId;
}