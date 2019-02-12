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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Herc
 */
@Entity
@Table(name = "Stats")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stats.findAll", query = "SELECT s FROM Stats s")
    , @NamedQuery(name = "Stats.findByPlayer", query = "SELECT s FROM Stats s WHERE s.player = :player")
    , @NamedQuery(name = "Stats.findByUsername", query = "SELECT s FROM Stats s WHERE s.username = :username")
    , @NamedQuery(name = "Stats.findByTeamwork", query = "SELECT s FROM Stats s WHERE s.teamwork = :teamwork")
    , @NamedQuery(name = "Stats.findByAthletism", query = "SELECT s FROM Stats s WHERE s.athletism = :athletism")
    , @NamedQuery(name = "Stats.findByTechnique", query = "SELECT s FROM Stats s WHERE s.technique = :technique")})
public class Stats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "Player")
    private int player;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "teamwork")
    private BigDecimal teamwork;
    @Column(name = "athletism")
    private BigDecimal athletism;
    @Column(name = "technique")
    private BigDecimal technique;

    public Stats() {
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
