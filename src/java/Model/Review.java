/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r")
    , @NamedQuery(name = "Review.findByReviewID", query = "SELECT r FROM Review r WHERE r.reviewID = :reviewID")
    , @NamedQuery(name = "Review.findByTeamwork", query = "SELECT r FROM Review r WHERE r.teamwork = :teamwork")
    , @NamedQuery(name = "Review.findByAthletism", query = "SELECT r FROM Review r WHERE r.athletism = :athletism")
    , @NamedQuery(name = "Review.findByTechnique", query = "SELECT r FROM Review r WHERE r.technique = :technique")
    , @NamedQuery(name = "Review.findByComments", query = "SELECT r FROM Review r WHERE r.comments = :comments")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reviewID")
    private Integer reviewID;
    @Column(name = "teamwork")
    private Integer teamwork;
    @Column(name = "athletism")
    private Integer athletism;
    @Column(name = "technique")
    private Integer technique;
    @Column(name = "comments")
    private String comments;
    @JoinColumn(name = "match", referencedColumnName = "CourtReservationID")
    @ManyToOne(optional = false)
    private CourtReservation match;
    @JoinColumn(name = "reviewed", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User reviewed;
    @JoinColumn(name = "reviewer", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User reviewer;

    public Review() {
    }

    public Review(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getReviewID() {
        return reviewID;
    }

    public void setReviewID(Integer reviewID) {
        this.reviewID = reviewID;
    }

    public Integer getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(Integer teamwork) {
        this.teamwork = teamwork;
    }

    public Integer getAthletism() {
        return athletism;
    }

    public void setAthletism(Integer athletism) {
        this.athletism = athletism;
    }

    public Integer getTechnique() {
        return technique;
    }

    public void setTechnique(Integer technique) {
        this.technique = technique;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public CourtReservation getMatch() {
        return match;
    }

    public void setMatch(CourtReservation match) {
        this.match = match;
    }

    public User getReviewed() {
        return reviewed;
    }

    public void setReviewed(User reviewed) {
        this.reviewed = reviewed;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewID != null ? reviewID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.reviewID == null && other.reviewID != null) || (this.reviewID != null && !this.reviewID.equals(other.reviewID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Review[ reviewID=" + reviewID + " ]";
    }
    
}
