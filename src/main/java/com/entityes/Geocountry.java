/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "geocountry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geocountry.findAll", query = "SELECT g FROM Geocountry g"),
    @NamedQuery(name = "Geocountry.findByIdKey", query = "SELECT g FROM Geocountry g WHERE g.idKey = :idKey"),
    @NamedQuery(name = "Geocountry.findByName", query = "SELECT g FROM Geocountry g WHERE g.name = :name"),
    @NamedQuery(name = "Geocountry.findByIso", query = "SELECT g FROM Geocountry g WHERE g.iso = :iso"),
    @NamedQuery(name = "Geocountry.findByCode", query = "SELECT g FROM Geocountry g WHERE g.code = :code"),
    @NamedQuery(name = "Geocountry.findByGeoLocAltitude", query = "SELECT g FROM Geocountry g WHERE g.geoLocAltitude = :geoLocAltitude"),
    @NamedQuery(name = "Geocountry.findByGeoLocLongitude", query = "SELECT g FROM Geocountry g WHERE g.geoLocLongitude = :geoLocLongitude")})
public class Geocountry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 5)
    @Column(name = "iso")
    private String iso;
    @Column(name = "code")
    private Integer code;
    @Size(max = 50)
    @Column(name = "geoLocAltitude")
    private String geoLocAltitude;
    @Size(max = 50)
    @Column(name = "geoLocLongitude")
    private String geoLocLongitude;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private SisStatus status;
    @OneToMany(mappedBy = "idCountry", fetch = FetchType.LAZY)
    private List<Geostates> geostatesList;

    public Geocountry() {
    }

    public Geocountry(Integer idKey) {
        this.idKey = idKey;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getGeoLocAltitude() {
        return geoLocAltitude;
    }

    public void setGeoLocAltitude(String geoLocAltitude) {
        this.geoLocAltitude = geoLocAltitude;
    }

    public String getGeoLocLongitude() {
        return geoLocLongitude;
    }

    public void setGeoLocLongitude(String geoLocLongitude) {
        this.geoLocLongitude = geoLocLongitude;
    }

    public SisStatus getStatus() {
        return status;
    }

    public void setStatus(SisStatus status) {
        this.status = status;
    }

    @XmlTransient
    public List<Geostates> getGeostatesList() {
        return geostatesList;
    }

    public void setGeostatesList(List<Geostates> geostatesList) {
        this.geostatesList = geostatesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKey != null ? idKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geocountry)) {
            return false;
        }
        Geocountry other = (Geocountry) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Geocountry[ idKey=" + idKey + " ]";
    }
    
}
