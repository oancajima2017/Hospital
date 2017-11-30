/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Araveli Araujo
 */
@Embeddable
public class DetventaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private int nummed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NCOD_DOC", nullable = false)
    private int ncodDoc;

    public DetventaPK() {
    }

    public DetventaPK(int nummed, int ncodDoc) {
        this.nummed = nummed;
        this.ncodDoc = ncodDoc;
    }

    public int getNummed() {
        return nummed;
    }

    public void setNummed(int nummed) {
        this.nummed = nummed;
    }

    public int getNcodDoc() {
        return ncodDoc;
    }

    public void setNcodDoc(int ncodDoc) {
        this.ncodDoc = ncodDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nummed;
        hash += (int) ncodDoc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetventaPK)) {
            return false;
        }
        DetventaPK other = (DetventaPK) object;
        if (this.nummed != other.nummed) {
            return false;
        }
        if (this.ncodDoc != other.ncodDoc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DetventaPK[ nummed=" + nummed + ", ncodDoc=" + ncodDoc + " ]";
    }
    
}
