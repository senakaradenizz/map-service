/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mehmet
 */
@Entity
@Table(name = "subprovince")
@NamedQueries({
    @NamedQuery(name = "Subprovince.findAll", query = "SELECT s FROM Subprovince s")})
public class Subprovince implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "subprovince_id")
    private Integer subprovinceId;
    @Basic(optional = false)
    @Column(name = "subprovince_name")
    private String subprovinceName;
    @OneToMany(mappedBy = "subprovinceId")
    private List<Coordinate> coordinateList;
    @JoinColumn(name = "province_id", referencedColumnName = "province_id")
    @ManyToOne
    private Province provinceId;

    public Subprovince() {
    }

    public Subprovince(Integer subprovinceId) {
        this.subprovinceId = subprovinceId;
    }

    public Subprovince(Integer subprovinceId, String subprovinceName) {
        this.subprovinceId = subprovinceId;
        this.subprovinceName = subprovinceName;
    }

    public Integer getSubprovinceId() {
        return subprovinceId;
    }

    public void setSubprovinceId(Integer subprovinceId) {
        this.subprovinceId = subprovinceId;
    }

    public String getSubprovinceName() {
        return subprovinceName;
    }

    public void setSubprovinceName(String subprovinceName) {
        this.subprovinceName = subprovinceName;
    }

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public Province getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Province provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subprovinceId != null ? subprovinceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subprovince)) {
            return false;
        }
        Subprovince other = (Subprovince) object;
        if ((this.subprovinceId == null && other.subprovinceId != null) || (this.subprovinceId != null && !this.subprovinceId.equals(other.subprovinceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.mapservice.model.Subprovince[ subprovinceId=" + subprovinceId + " ]";
    }
    
}
