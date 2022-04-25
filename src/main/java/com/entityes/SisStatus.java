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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "sis_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SisStatus.findAll", query = "SELECT s FROM SisStatus s"),
    @NamedQuery(name = "SisStatus.findByIdKey", query = "SELECT s FROM SisStatus s WHERE s.idKey = :idKey"),
    @NamedQuery(name = "SisStatus.findByName", query = "SELECT s FROM SisStatus s WHERE s.name = :name"),
    @NamedQuery(name = "SisStatus.findByDescription", query = "SELECT s FROM SisStatus s WHERE s.description = :description")})
public class SisStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Clients> clientsList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Geocountry> geocountryList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<ClientsCategories> clientsCategoriesList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<UsersChangePasswords> usersChangePasswordsList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<UsersTokens> usersTokensList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Language> languageList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Geocitys> geocitysList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Users> usersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<UsersDetails> usersDetailsList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<DbConfigs> dbConfigsList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Geostates> geostatesList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<Companys> companysList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status", fetch = FetchType.LAZY)
    private List<SisModuleRelClient> sisModuleRelClientList;
    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
    private List<UsersGroups> usersGroupsList;

    public SisStatus() {
    }

    public SisStatus(Integer idKey) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Clients> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Clients> clientsList) {
        this.clientsList = clientsList;
    }

    @XmlTransient
    public List<Geocountry> getGeocountryList() {
        return geocountryList;
    }

    public void setGeocountryList(List<Geocountry> geocountryList) {
        this.geocountryList = geocountryList;
    }

    @XmlTransient
    public List<ClientsCategories> getClientsCategoriesList() {
        return clientsCategoriesList;
    }

    public void setClientsCategoriesList(List<ClientsCategories> clientsCategoriesList) {
        this.clientsCategoriesList = clientsCategoriesList;
    }

    @XmlTransient
    public List<UsersChangePasswords> getUsersChangePasswordsList() {
        return usersChangePasswordsList;
    }

    public void setUsersChangePasswordsList(List<UsersChangePasswords> usersChangePasswordsList) {
        this.usersChangePasswordsList = usersChangePasswordsList;
    }

    @XmlTransient
    public List<UsersTokens> getUsersTokensList() {
        return usersTokensList;
    }

    public void setUsersTokensList(List<UsersTokens> usersTokensList) {
        this.usersTokensList = usersTokensList;
    }

    @XmlTransient
    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }

    @XmlTransient
    public List<Geocitys> getGeocitysList() {
        return geocitysList;
    }

    public void setGeocitysList(List<Geocitys> geocitysList) {
        this.geocitysList = geocitysList;
    }

    @XmlTransient
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @XmlTransient
    public List<UsersDetails> getUsersDetailsList() {
        return usersDetailsList;
    }

    public void setUsersDetailsList(List<UsersDetails> usersDetailsList) {
        this.usersDetailsList = usersDetailsList;
    }

    @XmlTransient
    public List<DbConfigs> getDbConfigsList() {
        return dbConfigsList;
    }

    public void setDbConfigsList(List<DbConfigs> dbConfigsList) {
        this.dbConfigsList = dbConfigsList;
    }

    @XmlTransient
    public List<Geostates> getGeostatesList() {
        return geostatesList;
    }

    public void setGeostatesList(List<Geostates> geostatesList) {
        this.geostatesList = geostatesList;
    }

    @XmlTransient
    public List<Companys> getCompanysList() {
        return companysList;
    }

    public void setCompanysList(List<Companys> companysList) {
        this.companysList = companysList;
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
        if (!(object instanceof SisStatus)) {
            return false;
        }
        SisStatus other = (SisStatus) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.SisStatus[ idKey=" + idKey + " ]";
    }
    
}
