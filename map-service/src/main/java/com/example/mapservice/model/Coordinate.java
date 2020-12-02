/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mehmet
 */
@Entity
@Table(name = "coordinate")
@NamedQueries({
    @NamedQuery(name = "Coordinate.findAll", query = "SELECT c FROM Coordinate c")})
public class Coordinate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "coordinate_id")
    private Integer coordinateId;
    @Column(name = "latitude")
    private Integer latitude;
    @Column(name = "longitude")
    private Integer longitude;
    @JoinColumn(name = "subprovince_id", referencedColumnName = "subprovince_id")
    @ManyToOne
    private Subprovince subprovinceId;

    public Coordinate() {
    }

    public Coordinate(Integer coordinateId) {
        this.coordinateId = coordinateId;
    }

    public Integer getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(Integer coordinateId) {
        this.coordinateId = coordinateId;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Subprovince getSubprovinceId() {
        return subprovinceId;
    }

    public void setSubprovinceId(Subprovince subprovinceId) {
        this.subprovinceId = subprovinceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coordinateId != null ? coordinateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) object;
        if ((this.coordinateId == null && other.coordinateId != null) || (this.coordinateId != null && !this.coordinateId.equals(other.coordinateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.mapservice.model.Coordinate[ coordinateId=" + coordinateId + " ]";
    }
    
}
