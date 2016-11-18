/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightschedulersamatkinssja5408;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author samatkins
 */
@Entity
@Table(name = "FLIGHTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flights.findAll", query = "SELECT f FROM Flights f"),
    @NamedQuery(name = "Flights.findByFlightid", query = "SELECT f FROM Flights f WHERE f.flightid = :flightid"),
    @NamedQuery(name = "Flights.findByNumseats", query = "SELECT f FROM Flights f WHERE f.numseats = :numseats")})
public class Flights implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FLIGHTID")
    private Integer flightid;
    @Basic(optional = false)
    @Lob
    @Column(name = "FLIGHTNUMBER")
    private String flightnumber;
    @Column(name = "NUMSEATS")
    private Integer numseats;

    public Flights() {
    }

    public Flights(Integer flightid) {
        this.flightid = flightid;
    }

    public Flights(Integer flightid, String flightnumber) {
        this.flightid = flightid;
        this.flightnumber = flightnumber;
    }

    public Integer getFlightid() {
        return flightid;
    }

    public void setFlightid(Integer flightid) {
        this.flightid = flightid;
    }

    public String getFlightnumber() {
        return flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.flightnumber = flightnumber;
    }

    public Integer getNumseats() {
        return numseats;
    }

    public void setNumseats(Integer numseats) {
        this.numseats = numseats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightid != null ? flightid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flights)) {
            return false;
        }
        Flights other = (Flights) object;
        if ((this.flightid == null && other.flightid != null) || (this.flightid != null && !this.flightid.equals(other.flightid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "flightschedulersamatkinssja5408.Flights[ flightid=" + flightid + " ]";
    }
    
}
