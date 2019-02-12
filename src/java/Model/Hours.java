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
@Table(name = "hours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hours.findAll", query = "SELECT h FROM Hours h")
    , @NamedQuery(name = "Hours.findByHoursId", query = "SELECT h FROM Hours h WHERE h.hoursId = :hoursId")
    , @NamedQuery(name = "Hours.findByHour", query = "SELECT h FROM Hours h WHERE h.hour = :hour")})
public class Hours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hours_id")
    private Integer hoursId;
    @Column(name = "hour")
    private String hour;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hours")
    private Collection<CourtReservation> courtReservationCollection;

    public Hours() {
    }

    public Hours(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public Integer getHoursId() {
        return hoursId;
    }

    public void setHoursId(Integer hoursId) {
        this.hoursId = hoursId;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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
        hash += (hoursId != null ? hoursId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hours)) {
            return false;
        }
        Hours other = (Hours) object;
        if ((this.hoursId == null && other.hoursId != null) || (this.hoursId != null && !this.hoursId.equals(other.hoursId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Hours[ hoursId=" + hoursId + " ]";
    }
    
}
