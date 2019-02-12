/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "court_reservation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourtReservation.findAll", query = "SELECT c FROM CourtReservation c")
    , @NamedQuery(name = "CourtReservation.findByCourtReservationID", query = "SELECT c FROM CourtReservation c WHERE c.courtReservationID = :courtReservationID")
    , @NamedQuery(name = "CourtReservation.findByDate", query = "SELECT c FROM CourtReservation c WHERE c.date = :date")})
public class CourtReservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CourtReservationID")
    private Integer courtReservationID;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @JoinColumn(name = "court_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Court courtId;
    @JoinColumn(name = "hours", referencedColumnName = "hours_id")
    @ManyToOne(optional = false)
    private Hours hours;
    @JoinColumn(name = "booker", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User booker;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private Collection<GameRequest> gameRequestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "match")
    private Collection<Review> reviewCollection;

    public CourtReservation() {
    }

    public CourtReservation(Integer courtReservationID) {
        this.courtReservationID = courtReservationID;
    }

    public CourtReservation(Integer courtReservationID, Date date) {
        this.courtReservationID = courtReservationID;
        this.date = date;
    }

    public Integer getCourtReservationID() {
        return courtReservationID;
    }

    public void setCourtReservationID(Integer courtReservationID) {
        this.courtReservationID = courtReservationID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Court getCourtId() {
        return courtId;
    }

    public void setCourtId(Court courtId) {
        this.courtId = courtId;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public User getBooker() {
        return booker;
    }

    public void setBooker(User booker) {
        this.booker = booker;
    }

    @XmlTransient
    public Collection<GameRequest> getGameRequestCollection() {
        return gameRequestCollection;
    }

    public void setGameRequestCollection(Collection<GameRequest> gameRequestCollection) {
        this.gameRequestCollection = gameRequestCollection;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courtReservationID != null ? courtReservationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourtReservation)) {
            return false;
        }
        CourtReservation other = (CourtReservation) object;
        if ((this.courtReservationID == null && other.courtReservationID != null) || (this.courtReservationID != null && !this.courtReservationID.equals(other.courtReservationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.CourtReservation[ courtReservationID=" + courtReservationID + " ]";
    }
    
}
