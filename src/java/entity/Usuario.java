package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
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
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodusu", query = "SELECT u FROM Usuario u WHERE u.codusu = :codusu")
    , @NamedQuery(name = "Usuario.findByNomusu", query = "SELECT u FROM Usuario u WHERE u.nomusu = :nomusu")
    , @NamedQuery(name = "Usuario.findByUsuusu", query = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu")
    , @NamedQuery(name = "Usuario.findByPwdusu", query = "SELECT u FROM Usuario u WHERE u.pwdusu = :pwdusu")
    , @NamedQuery(name = "Usuario.findByDniusu", query = "SELECT u FROM Usuario u WHERE u.dniusu = :dniusu")
    , @NamedQuery(name = "Usuario.findByIngusu", query = "SELECT u FROM Usuario u WHERE u.ingusu = :ingusu")
    , @NamedQuery(name = "Usuario.findByTelfusu", query = "SELECT u FROM Usuario u WHERE u.telfusu = :telfusu")
    , @NamedQuery(name = "Usuario.findByFnacusu", query = "SELECT u FROM Usuario u WHERE u.fnacusu = :fnacusu")
    , @NamedQuery(name = "Usuario.findByCargusu", query = "SELECT u FROM Usuario u WHERE u.cargusu = :cargusu")
    , @NamedQuery(name = "Usuario.findByDirusu", query = "SELECT u FROM Usuario u WHERE u.dirusu = :dirusu")
    , @NamedQuery(name = "Usuario.findByUbigeo", query = "SELECT u FROM Usuario u WHERE u.ubigeo = :ubigeo")
    , @NamedQuery(name = "Usuario.findByLevusu", query = "SELECT u FROM Usuario u WHERE u.levusu = :levusu")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer codusu;
    @Size(max = 50)
    @Column(length = 50)
    private String nomusu;
    @Size(max = 5)
    @Column(length = 5)
    private String usuusu;
    @Size(max = 50)
    @Column(length = 50)
    private String pwdusu;
    @Size(max = 8)
    @Column(length = 8)
    private String dniusu;
    @Temporal(TemporalType.DATE)
    @Past(message = "El usuario se registra el mismo día o antes")
    private Date ingusu;
    @Size(max = 30)
    @Column(length = 30)
    private String telfusu;
    @Temporal(TemporalType.DATE)
    private Date fnacusu;
    @Size(max = 30)
    @Column(length = 30)
    private String cargusu;
    @Size(max = 50)
    @Column(length = 50)
    private String dirusu;
    @Size(max = 6)
    @Column(length = 6)
    private String ubigeo;
    private Character levusu;

    public Usuario() {
    }

    public Usuario(Integer codusu) {
        this.codusu = codusu;
    }

    public Integer getCodusu() {
        return codusu;
    }

    public void setCodusu(Integer codusu) {
        this.codusu = codusu;
    }

    public String getNomusu() {
        return nomusu;
    }

    public void setNomusu(String nomusu) {
        this.nomusu = nomusu;
    }

    public String getUsuusu() {
        return usuusu;
    }

    public void setUsuusu(String usuusu) {
        this.usuusu = usuusu;
    }

    public String getPwdusu() {
        return pwdusu;
    }

    public void setPwdusu(String pwdusu) {
        this.pwdusu = pwdusu;
    }

    public String getDniusu() {
        return dniusu;
    }

    public void setDniusu(String dniusu) {
        this.dniusu = dniusu;
    }

    public Date getIngusu() {
        return ingusu;
    }

    public void setIngusu(Date ingusu) {
        this.ingusu = ingusu;
    }

    public String getTelfusu() {
        return telfusu;
    }

    public void setTelfusu(String telfusu) {
        this.telfusu = telfusu;
    }

    public Date getFnacusu() {
        return fnacusu;
    }

    public void setFnacusu(Date fnacusu) {
        this.fnacusu = fnacusu;
    }

    public String getCargusu() {
        return cargusu;
    }

    public void setCargusu(String cargusu) {
        this.cargusu = cargusu;
    }

    public String getDirusu() {
        return dirusu;
    }

    public void setDirusu(String dirusu) {
        this.dirusu = dirusu;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Character getLevusu() {
        return levusu;
    }

    public void setLevusu(Character levusu) {
        this.levusu = levusu;
    }

    public String getLevel() {
        switch (Integer.parseInt(String.valueOf(this.levusu))) {
            case 1:
                return "Administrador";
            case 2:
                return "Operativo";
            default:
                return "Sin Privilegios";
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusu != null ? codusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codusu == null && other.codusu != null) || (this.codusu != null && !this.codusu.equals(other.codusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Usuario[ codusu=" + codusu + " ]";
    }

}
