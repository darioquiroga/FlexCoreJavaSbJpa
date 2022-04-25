/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entityes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dario
 */
@Entity
@Table(name = "users_tokens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsersTokens.findAll", query = "SELECT u FROM UsersTokens u"),
    @NamedQuery(name = "UsersTokens.findByHashId", query = "SELECT u FROM UsersTokens u WHERE u.hashId = :hashId"),
    @NamedQuery(name = "UsersTokens.findByDateFrom", query = "SELECT u FROM UsersTokens u WHERE u.dateFrom = :dateFrom"),
    @NamedQuery(name = "UsersTokens.findByDateTo", query = "SELECT u FROM UsersTokens u WHERE u.dateTo = :dateTo"),
    @NamedQuery(name = "UsersTokens.findBySource", query = "SELECT u FROM UsersTokens u WHERE u.source = :source")})
public class UsersTokens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "hashId")
    private String hashId;
    @Column(name = "date_from")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;
    @Column(name = "date_to")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;
    @Size(max = 255)
    @Column(name = "source")
    private String source;
    @JoinColumn(name = "status", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private SisStatus status;
    @JoinColumn(name = "idUser", referencedColumnName = "idKey")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users idUser;

    public UsersTokens() {
    }

    public UsersTokens(String hashId) {
        this.hashId = hashId;
    }

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
        hash += (hashId != null ? hashId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersTokens)) {
            return false;
        }
        UsersTokens other = (UsersTokens) object;
        if ((this.hashId == null && other.hashId != null) || (this.hashId != null && !this.hashId.equals(other.hashId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entityes.UsersTokens[ hashId=" + hashId + " ]";
    }
    
}
