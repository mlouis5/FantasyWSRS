/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.pojo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MacDerson
 */
@Entity
@Table(name = "heartbeat", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Heartbeat.findAll", query = "SELECT h FROM Heartbeat h"),
    @NamedQuery(name = "Heartbeat.findById", query = "SELECT h FROM Heartbeat h WHERE h.id = :id"),
    @NamedQuery(name = "Heartbeat.findByHeartbeat", query = "SELECT h FROM Heartbeat h WHERE h.heartbeat = :heartbeat")})
public class Heartbeat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "heartbeat")
    private BigInteger heartbeat;

    public Heartbeat() {
    }

    public Heartbeat(Integer id) {
        this.id = id;
    }
    
    public Heartbeat(BigInteger heartbeat) {
        this.id = 0;
        this.heartbeat = heartbeat;
    }
    
    public Heartbeat(String heartbeat) {
        this.id = 0;
        this.heartbeat = new BigInteger(isLong(heartbeat)? heartbeat : String.valueOf(Long.MIN_VALUE));
    }
    
    public Heartbeat(long heartbeat){
        this.id = 0;
        this.heartbeat = new BigInteger(String.valueOf(heartbeat));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(BigInteger heartbeat) {
        this.heartbeat = heartbeat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Heartbeat)) {
            return false;
        }
        Heartbeat other = (Heartbeat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fantasy.draftlogger.service.pojo.Heartbeat[ id=" + id + " ]";
    }
    
    private boolean isLong(String heartbeat) {
        if (Objects.nonNull(heartbeat)) {
            try {
                Long.parseLong(heartbeat);
                return true;
            } catch (NumberFormatException ex) {
                //Logger.getLogger(HeartbeatFacadeRest.class.getName()).log(Level.SEVERE, null, ex);
            }        }
        return false;
    }
}
