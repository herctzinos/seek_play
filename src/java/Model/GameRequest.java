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
@Table(name = "game_request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GameRequest.findAll", query = "SELECT g FROM GameRequest g")
    , @NamedQuery(name = "GameRequest.findById", query = "SELECT g FROM GameRequest g WHERE g.id = :id")
    , @NamedQuery(name = "GameRequest.findByRequestId", query = "SELECT g FROM GameRequest g WHERE g.requestId = :requestId")
    , @NamedQuery(name = "GameRequest.findByStatus", query = "SELECT g FROM GameRequest g WHERE g.status = :status")
    , @NamedQuery(name = "GameRequest.findByText", query = "SELECT g FROM GameRequest g WHERE g.text = :text")})
public class GameRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "request_id")
    private int requestId;
    @Column(name = "status")
    private String status;
    @Column(name = "text")
    private String text;
    @JoinColumn(name = "request_receiver", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User requestReceiver;
    @JoinColumn(name = "match", referencedColumnName = "CourtReservationID")
    @ManyToOne(optional = false)
    private CourtReservation match;

    public GameRequest() {
    }

    public GameRequest(Integer id) {
        this.id = id;
    }

    public GameRequest(Integer id, int requestId) {
        this.id = id;
        this.requestId = requestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getRequestReceiver() {
        return requestReceiver;
    }

    public void setRequestReceiver(User requestReceiver) {
        this.requestReceiver = requestReceiver;
    }

    public CourtReservation getMatch() {
        return match;
    }

    public void setMatch(CourtReservation match) {
        this.match = match;
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
        if (!(object instanceof GameRequest)) {
            return false;
        }
        GameRequest other = (GameRequest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.GameRequest[ id=" + id + " ]";
    }
    
}
