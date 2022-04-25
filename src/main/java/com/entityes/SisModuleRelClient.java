/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "sis_module_rel_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisModuleRelClient.findAll", query = "SELECT s FROM SisModuleRelClient s"),
    @NamedQuery(name = "SisModuleRelClient.findByIdKey", query = "SELECT s FROM SisModuleRelClient s WHERE s.idKey = :idKey"),
    @NamedQuery(name = "SisModuleRelClient.findByDomain", query = "SELECT s FROM SisModuleRelClient s WHERE s.domain = :domain")})
public class SisModuleRelClient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "domain")
    private String domain;
    @JoinColumn(name = "idClient", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clients idClient;
    @JoinColumn(name = "idSisModule", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SisModules idSisModule;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SisStatus status;

    public SisModuleRelClient() {
    }

    public SisModuleRelClient(Integer idKey) {
        this.idKey = idKey;
    }

    public SisModuleRelClient(Integer idKey, String domain) {
        this.idKey = idKey;
        this.domain = domain;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public SisModules getIdSisModule() {
        return idSisModule;
    }

    public void setIdSisModule(SisModules idSisModule) {
        this.idSisModule = idSisModule;
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
        hash += (idKey != null ? idKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SisModuleRelClient)) {
            return false;
        }
        SisModuleRelClient other = (SisModuleRelClient) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.SisModuleRelClient[ idKey=" + idKey + " ]";
    }
    
}
