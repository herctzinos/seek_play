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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "User.findByImage", query = "SELECT u FROM User u WHERE u.image = :image")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
     @Transient
    private String password_confirmation;
   @JsonIgnore  
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booker")
    private Collection<CourtReservation> courtReservationCollection;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestReceiver")
    private Collection<GameRequest> gameRequestCollection;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewed")
    private Collection<Review> reviewCollection;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reviewer")
    private Collection<Review> reviewCollection1;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiver")
    private Collection<Message> messageCollection;
   @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sender")
    private Collection<Message> messageCollection1;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String username, String firstname, String lastname, String password) {
        this.userId = userId;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }
    

    @XmlTransient
    public Collection<CourtReservation> getCourtReservationCollection() {
        return courtReservationCollection;
    }

    public void setCourtReservationCollection(Collection<CourtReservation> courtReservationCollection) {
        this.courtReservationCollection = courtReservationCollection;
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

    @XmlTransient
    public Collection<Review> getReviewCollection1() {
        return reviewCollection1;
    }

    public void setReviewCollection1(Collection<Review> reviewCollection1) {
        this.reviewCollection1 = reviewCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.User[ userId=" + userId + " ]";
    }
    
}
