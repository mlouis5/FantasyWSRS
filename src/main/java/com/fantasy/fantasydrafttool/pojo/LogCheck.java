/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fantasy.fantasydrafttool.pojo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author MacDerson
 */
@Entity
@Table(name = "log_check", catalog = "fantasy", schema = "drafttool")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogCheck.findAll", query = "SELECT l FROM LogCheck l"),
    @NamedQuery(name = "LogCheck.findByEmail", query = "SELECT l FROM LogCheck l WHERE l.email = :email"),
    @NamedQuery(name = "LogCheck.findByPwd", query = "SELECT l FROM LogCheck l WHERE l.pwd = :pwd")})
public class LogCheck implements Serializable {
    @Size(max = 128)
    @Column(name = "pc_host_name")
    private String pcHostName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "pwd")
    private String pwd;
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected LogCheckPK logCheckPK;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "logCheck")
//    private List<Heartbeat> heartbeatList;

    public LogCheck() {
    }

//    public LogCheck(LogCheckPK logCheckPK) {
//        this.logCheckPK = logCheckPK;
//    }

//    public LogCheck(String email, String pwd) {
//        this.logCheckPK = new LogCheckPK(email, pwd);
//    }

//    public LogCheckPK getLogCheckPK() {
//        return logCheckPK;
//    }

//    public void setLogCheckPK(LogCheckPK logCheckPK) {
//        this.logCheckPK = logCheckPK;
//    }

//    @XmlTransient
//    public List<Heartbeat> getHeartbeatList() {
//        return heartbeatList;
//    }
//
//    public void setHeartbeatList(List<Heartbeat> heartbeatList) {
//        this.heartbeatList = heartbeatList;
//    }

    public LogCheck(String email) {
        this.email = email;
    }

    public LogCheck(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogCheck)) {
            return false;
        }
        LogCheck other = (LogCheck) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fantasy.draftlogger.service.pojo.LogCheck[ email=" + email + " ]";
    }

    public String getPcHostName() {
        return pcHostName;
    }

    public void setPcHostName(String pcHostName) {
        this.pcHostName = pcHostName;
    }
    
}
