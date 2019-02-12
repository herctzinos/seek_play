/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "court")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Court.findAll", query = "SELECT c FROM Court c")
    , @NamedQuery(name = "Court.findById", query = "SELECT c FROM Court c WHERE c.id = :id")
    , @NamedQuery(name = "Court.findByName", query = "SELECT c FROM Court c WHERE c.name = :name")
    , @NamedQuery(name = "Court.findByAddress", query = "SELECT c FROM Court c WHERE c.address = :address")
    , @NamedQuery(name = "Court.findByPhone", query = "SELECT c FROM Court c WHERE c.phone = :phone")})
public class Court implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private Integer phone;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courtId")
    private Collection<CourtReservation> courtReservationCollection;

    public Court() {
    }

    public Court(Integer id) {
        this.id = id;
    }

    public Court(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @XmlTransient
    public Collection<CourtReservation> getCourtReservationCollection() {
        return courtReservationCollection;
    }

    public void setCourtReservationCollection(Collection<CourtReservation> courtReservationCollection) {
        this.courtReservationCollection = courtReservationCollection;
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
        if (!(object instanceof Court)) {
            return false;
        }
        Court other = (Court) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Court[ id=" + id + " ]";
    }
    
}
