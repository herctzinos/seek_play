/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author Michail Sitmalidis
 */
@Entity
@Immutable
@Table(name = "ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r")
    , @NamedQuery(name = "Ratings.findByPlayer", query = "SELECT r FROM Ratings r WHERE r.player = :player")
    , @NamedQuery(name = "Ratings.findByTeamwork", query = "SELECT r FROM Ratings r WHERE r.teamwork = :teamwork")
    , @NamedQuery(name = "Ratings.findByAthletism", query = "SELECT r FROM Ratings r WHERE r.athletism = :athletism")
    , @NamedQuery(name = "Ratings.findByTechnique", query = "SELECT r FROM Ratings r WHERE r.technique = :technique")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Player")
    @Id
    private int player;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "teamwork")
    private BigDecimal teamwork;
    @Column(name = "athletism")
    private BigDecimal athletism;
    @Column(name = "technique")
    private BigDecimal technique;

    public Ratings() {
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public BigDecimal getTeamwork() {
        return teamwork;
    }

    public void setTeamwork(BigDecimal teamwork) {
        this.teamwork = teamwork;
    }

    public BigDecimal getAthletism() {
        return athletism;
    }

    public void setAthletism(BigDecimal athletism) {
        this.athletism = athletism;
    }

    public BigDecimal getTechnique() {
        return technique;
    }

    public void setTechnique(BigDecimal technique) {
        this.technique = technique;
    }
    
}
