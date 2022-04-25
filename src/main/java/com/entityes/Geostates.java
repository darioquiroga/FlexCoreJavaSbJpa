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
@Table(name = "geostates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Geostates.findAll", query = "SELECT g FROM Geostates g"),
    @NamedQuery(name = "Geostates.findByIdkey", query = "SELECT g FROM Geostates g WHERE g.idkey = :idkey"),
    @NamedQuery(name = "Geostates.findByName", query = "SELECT g FROM Geostates g WHERE g.name = :name"),
    @NamedQuery(name = "Geostates.findByIso", query = "SELECT g FROM Geostates g WHERE g.iso = :iso"),
    @NamedQuery(name = "Geostates.findByGeoLocAltitude", query = "SELECT g FROM Geostates g WHERE g.geoLocAltitude = :geoLocAltitude"),
    @NamedQuery(name = "Geostates.findByGeoLocLongitude", query = "SELECT g FROM Geostates g WHERE g.geoLocLongitude = :geoLocLongitude")})
public class Geostates implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idkey")
    private Integer idkey;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 5)
    @Column(name = "iso")
    private String iso;
    @Size(max = 50)
    @Column(name = "geoLocAltitude")
    private String geoLocAltitude;
    @Size(max = 50)
    @Column(name = "geoLocLongitude")
    private String geoLocLongitude;
    @OneToMany(mappedBy = "idState", fetch = FetchType.LAZY)
    private List<Geocitys> geocitysList;
    @JoinColumn(name = "idCountry", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Geocountry idCountry;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private SisStatus status;

    public Geostates() {
    }

    public Geostates(Integer idkey) {
        this.idkey = idkey;
    }

    public Integer getIdkey() {
        return idkey;
    }

    public void setIdkey(Integer idkey) {
        this.idkey = idkey;
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

    @XmlTransient
    public List<Geocitys> getGeocitysList() {
        return geocitysList;
    }

    public void setGeocitysList(List<Geocitys> geocitysList) {
        this.geocitysList = geocitysList;
    }

    public Geocountry getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Geocountry idCountry) {
        this.idCountry = idCountry;
    }

    public SisStatus getStatus() {
        return status;
    }

    public void setStatus(SisStatus status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkey != null ? idkey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Geostates)) {
            return false;
        }
        Geostates other = (Geostates) object;
        if ((this.idkey == null && other.idkey != null) || (this.idkey != null && !this.idkey.equals(other.idkey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Geostates[ idkey=" + idkey + " ]";
    }
    
}
