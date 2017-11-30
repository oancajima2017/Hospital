/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Araveli Araujo
 */
@Entity
@Table(catalog = "BDHospital", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u")
    , @NamedQuery(name = "Ubigeo.findByUbigeo", query = "SELECT u FROM Ubigeo u WHERE u.ubigeo = :ubigeo")
    , @NamedQuery(name = "Ubigeo.findByDpto", query = "SELECT u FROM Ubigeo u WHERE u.dpto = :dpto")
    , @NamedQuery(name = "Ubigeo.findByProv", query = "SELECT u FROM Ubigeo u WHERE u.prov = :prov")
    , @NamedQuery(name = "Ubigeo.findByDist", query = "SELECT u FROM Ubigeo u WHERE u.dist = :dist")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String ubigeo;
    @Size(max = 60)
    @Column(length = 60)
    private String dpto;
    @Size(max = 60)
    @Column(length = 60)
    private String prov;
    @Size(max = 60)
    @Column(length = 60)
    private String dist;

    public Ubigeo() {
    }

    public Ubigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ubigeo != null ? ubigeo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.ubigeo == null && other.ubigeo != null) || (this.ubigeo != null && !this.ubigeo.equals(other.ubigeo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ubigeo[ ubigeo=" + ubigeo + " ]";
    }
    
}
