/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "users_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersDetails.findAll", query = "SELECT u FROM UsersDetails u"),
    @NamedQuery(name = "UsersDetails.findByIdKey", query = "SELECT u FROM UsersDetails u WHERE u.idKey = :idKey"),
    @NamedQuery(name = "UsersDetails.findByAddressStreet", query = "SELECT u FROM UsersDetails u WHERE u.addressStreet = :addressStreet"),
    @NamedQuery(name = "UsersDetails.findByAddressNumber", query = "SELECT u FROM UsersDetails u WHERE u.addressNumber = :addressNumber"),
    @NamedQuery(name = "UsersDetails.findByCelNumber", query = "SELECT u FROM UsersDetails u WHERE u.celNumber = :celNumber"),
    @NamedQuery(name = "UsersDetails.findByDateBorn", query = "SELECT u FROM UsersDetails u WHERE u.dateBorn = :dateBorn"),
    @NamedQuery(name = "UsersDetails.findByDocNumber", query = "SELECT u FROM UsersDetails u WHERE u.docNumber = :docNumber"),
    @NamedQuery(name = "UsersDetails.findByFacebook", query = "SELECT u FROM UsersDetails u WHERE u.facebook = :facebook"),
    @NamedQuery(name = "UsersDetails.findByInstagram", query = "SELECT u FROM UsersDetails u WHERE u.instagram = :instagram"),
    @NamedQuery(name = "UsersDetails.findByLinkedin", query = "SELECT u FROM UsersDetails u WHERE u.linkedin = :linkedin"),
    @NamedQuery(name = "UsersDetails.findByPassportNumber", query = "SELECT u FROM UsersDetails u WHERE u.passportNumber = :passportNumber"),
    @NamedQuery(name = "UsersDetails.findByTwiter", query = "SELECT u FROM UsersDetails u WHERE u.twiter = :twiter")})
public class UsersDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idKey")
    private Integer idKey;
    @Size(max = 255)
    @Column(name = "address_street")
    private String addressStreet;
    @Column(name = "address_number")
    private Integer addressNumber;
    @Column(name = "cel_number")
    private Long celNumber;
    @Column(name = "date_born")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBorn;
    @Column(name = "doc_number")
    private Long docNumber;
    @Size(max = 255)
    @Column(name = "facebook")
    private String facebook;
    @Size(max = 255)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 255)
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "passport_number")
    private BigInteger passportNumber;
    @Size(max = 255)
    @Column(name = "twiter")
    private String twiter;
    @JoinColumn(name = "idCity", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Geocitys idCity;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SisStatus status;
    @JoinColumn(name = "idUser", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idUser;

    public UsersDetails() {
    }

    public UsersDetails(Integer idKey) {
        this.idKey = idKey;
    }

    public Integer getIdKey() {
        return idKey;
    }

    public void setIdKey(Integer idKey) {
        this.idKey = idKey;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public Integer getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Integer addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Long getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(Long celNumber) {
        this.celNumber = celNumber;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public Long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(Long docNumber) {
        this.docNumber = docNumber;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public BigInteger getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(BigInteger passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getTwiter() {
        return twiter;
    }

    public void setTwiter(String twiter) {
        this.twiter = twiter;
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

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
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
        if (!(object instanceof UsersDetails)) {
            return false;
        }
        UsersDetails other = (UsersDetails) object;
        if ((this.idKey == null && other.idKey != null) || (this.idKey != null && !this.idKey.equals(other.idKey))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.UsersDetails[ idKey=" + idKey + " ]";
    }
    
}
