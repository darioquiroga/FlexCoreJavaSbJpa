/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "sis_modules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisModules.findAll", query = "SELECT s FROM SisModules s"),
    @NamedQuery(name = "SisModules.findByIdKey", query = "SELECT s FROM SisModules s WHERE s.idKey = :idKey"),
    @NamedQuery(name = "SisModules.findByName", query = "SELECT s FROM SisModules s WHERE s.name = :name"),
    @NamedQuery(name = "SisModules.findByDescription", query = "SELECT s FROM SisModules s WHERE s.description = :description"),
    @NamedQuery(name = "SisModules.findByStatus", query = "SELECT s FROM SisModules s WHERE s.status = :status")})
public class SisModules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModule", fetch = FetchType.LAZY)
    private List<DbConfigs> dbConfigsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSisModule", fetch = FetchType.LAZY)
    private List<SisModuleRelClient> sisModuleRelClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModule", fetch = FetchType.LAZY)
    private List<UsersGroups> usersGroupsList;

    public SisModules() {
    }

    public SisModules(Integer idKey) {
        this.idKey = idKey;
    }

    public SisModules(Integer idKey, String name, String description, int status) {
        this.idKey = idKey;
        this.name = name;
        this.description = description;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<DbConfigs> getDbConfigsList() {
        return dbConfigsList;
    }

    public void setDbConfigsList(List<DbConfigs> dbConfigsList) {
        this.dbConfigsList = dbConfigsList;
    }

    @XmlTransient
    public List<SisModuleRelClient> getSisModuleRelClientList() {
        return sisModuleRelClientList;
    }

    public void setSisModuleRelClientList(List<SisModuleRelClient> sisModuleRelClientList) {
        this.sisModuleRelClientList = sisModuleRelClientList;
    }

    @XmlTransient
    public List<UsersGroups> getUsersGroupsList() {
        return usersGroupsList;
    }

    public void setUsersGroupsList(List<UsersGroups> usersGroupsList) {
        this.usersGroupsList = usersGroupsList;
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
        if (!(object instanceof SisModules)) {
            return false;
        }
        SisModules other = (SisModules) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.SisModules[ idKey=" + idKey + " ]";
    }
    
}
