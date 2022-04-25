/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findByIdKey", query = "SELECT c FROM Clients c WHERE c.idKey = :idKey"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByDescription", query = "SELECT c FROM Clients c WHERE c.description = :description"),
    @NamedQuery(name = "Clients.findByAdress", query = "SELECT c FROM Clients c WHERE c.adress = :adress"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByTelephoneNumber", query = "SELECT c FROM Clients c WHERE c.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "Clients.findByWeb", query = "SELECT c FROM Clients c WHERE c.web = :web")})
public class Clients implements Serializable {

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
    @Size(max = 255)
    @Column(name = "adress")
    private String adress;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Column(name = "telephone_number")
    private BigInteger telephoneNumber;
    @Size(max = 255)
    @Column(name = "web")
    private String web;
    @JoinColumn(name = "idCompany", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Companys idCompany;
    @JoinColumn(name = "idCity", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Geocitys idCity;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private SisStatus status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient", fetch = FetchType.LAZY)
    private List<SisModuleRelClient> sisModuleRelClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idClient", fetch = FetchType.LAZY)
    private List<UsersGroups> usersGroupsList;

    public Clients() {
    }

    public Clients(Integer idKey) {
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(BigInteger telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Companys getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Companys idCompany) {
        this.idCompany = idCompany;
    }

    public Geocitys getIdCity() {
        return idCity;
    }

    public void setIdCity(Geocitys idCity) {
        this.idCity = idCity;
    }

    public SisStatus getStatus() {
        return status;
    }

    public void setStatus(SisStatus status) {
        this.status = status;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.Clients[ idKey=" + idKey + " ]";
    }
    
}
