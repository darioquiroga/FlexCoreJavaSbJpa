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
@Table(name = "users_groups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersGroups.findAll", query = "SELECT u FROM UsersGroups u"),
    @NamedQuery(name = "UsersGroups.findByIdKey", query = "SELECT u FROM UsersGroups u WHERE u.idKey = :idKey"),
    @NamedQuery(name = "UsersGroups.findByDescription", query = "SELECT u FROM UsersGroups u WHERE u.description = :description"),
    @NamedQuery(name = "UsersGroups.findByName", query = "SELECT u FROM UsersGroups u WHERE u.name = :name")})
public class UsersGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "idUserGroup", fetch = FetchType.LAZY)
    private List<Users> usersList;
    @JoinColumn(name = "idClient", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Clients idClient;
    @JoinColumn(name = "idModule", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SisModules idModule;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private SisStatus status;

    public UsersGroups() {
    }

    public UsersGroups(Integer idKey) {
        this.idKey = idKey;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Clients getIdClient() {
        return idClient;
    }

    public void setIdClient(Clients idClient) {
        this.idClient = idClient;
    }

    public SisModules getIdModule() {
        return idModule;
    }

    public void setIdModule(SisModules idModule) {
        this.idModule = idModule;
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
        if (!(object instanceof UsersGroups)) {
            return false;
        }
        UsersGroups other = (UsersGroups) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.UsersGroups[ idKey=" + idKey + " ]";
    }
    
}
