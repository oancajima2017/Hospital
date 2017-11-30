/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Araveli Araujo
 */
@Entity
@Table(catalog = "BDHospital", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detventa.findAll", query = "SELECT d FROM Detventa d")
    , @NamedQuery(name = "Detventa.findByNummed", query = "SELECT d FROM Detventa d WHERE d.detventaPK.nummed = :nummed")
    , @NamedQuery(name = "Detventa.findByNcodDoc", query = "SELECT d FROM Detventa d WHERE d.detventaPK.ncodDoc = :ncodDoc")
    , @NamedQuery(name = "Detventa.findByCantvMed", query = "SELECT d FROM Detventa d WHERE d.cantvMed = :cantvMed")
    , @NamedQuery(name = "Detventa.findByStotvDoc", query = "SELECT d FROM Detventa d WHERE d.stotvDoc = :stotvDoc")})
public class Detventa implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetventaPK detventaPK;
    @Column(name = "CANTV_MED")
    private Integer cantvMed;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STOTV_DOC", precision = 10, scale = 2)
    private BigDecimal stotvDoc;

    public Detventa() {
    }

    public Detventa(DetventaPK detventaPK) {
        this.detventaPK = detventaPK;
    }

    public Detventa(int nummed, int ncodDoc) {
        this.detventaPK = new DetventaPK(nummed, ncodDoc);
    }

    public DetventaPK getDetventaPK() {
        return detventaPK;
    }

    public void setDetventaPK(DetventaPK detventaPK) {
        this.detventaPK = detventaPK;
    }

    public Integer getCantvMed() {
        return cantvMed;
    }

    public void setCantvMed(Integer cantvMed) {
        this.cantvMed = cantvMed;
    }

    public BigDecimal getStotvDoc() {
        return stotvDoc;
    }

    public void setStotvDoc(BigDecimal stotvDoc) {
        this.stotvDoc = stotvDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detventaPK != null ? detventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detventa)) {
            return false;
        }
        Detventa other = (Detventa) object;
        if ((this.detventaPK == null && other.detventaPK != null) || (this.detventaPK != null && !this.detventaPK.equals(other.detventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Detventa[ detventaPK=" + detventaPK + " ]";
    }
    
}
