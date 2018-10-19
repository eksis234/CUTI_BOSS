/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "jenis_cuti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JenisCuti.findAll", query = "SELECT j FROM JenisCuti j")
    , @NamedQuery(name = "JenisCuti.findByIdCuti", query = "SELECT j FROM JenisCuti j WHERE j.idCuti = :idCuti")
    , @NamedQuery(name = "JenisCuti.findByNamaCuti", query = "SELECT j FROM JenisCuti j WHERE j.namaCuti = :namaCuti")
    , @NamedQuery(name = "JenisCuti.findByDeskripsi", query = "SELECT j FROM JenisCuti j WHERE j.deskripsi = :deskripsi")
    , @NamedQuery(name = "JenisCuti.findByLamaCuti", query = "SELECT j FROM JenisCuti j WHERE j.lamaCuti = :lamaCuti")})
public class JenisCuti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_cuti")
    private String idCuti;
    @Basic(optional = false)
    @Column(name = "nama_cuti")
    private String namaCuti;
    @Basic(optional = false)
    @Column(name = "deskripsi")
    private String deskripsi;
    @Basic(optional = false)
    @Column(name = "lama_cuti")
    private int lamaCuti;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuti", fetch = FetchType.LAZY)
    private List<Permohonan> permohonanList;

    public JenisCuti() {
    }

    public JenisCuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public JenisCuti(String idCuti, String namaCuti, String deskripsi, int lamaCuti) {
        this.idCuti = idCuti;
        this.namaCuti = namaCuti;
        this.deskripsi = deskripsi;
        this.lamaCuti = lamaCuti;
    }

    public String getIdCuti() {
        return idCuti;
    }

    public void setIdCuti(String idCuti) {
        this.idCuti = idCuti;
    }

    public String getNamaCuti() {
        return namaCuti;
    }

    public void setNamaCuti(String namaCuti) {
        this.namaCuti = namaCuti;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getLamaCuti() {
        return lamaCuti;
    }

    public void setLamaCuti(int lamaCuti) {
        this.lamaCuti = lamaCuti;
    }

    @XmlTransient
    public List<Permohonan> getPermohonanList() {
        return permohonanList;
    }

    public void setPermohonanList(List<Permohonan> permohonanList) {
        this.permohonanList = permohonanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCuti != null ? idCuti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JenisCuti)) {
            return false;
        }
        JenisCuti other = (JenisCuti) object;
        if ((this.idCuti == null && other.idCuti != null) || (this.idCuti != null && !this.idCuti.equals(other.idCuti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.JenisCuti[ idCuti=" + idCuti + " ]";
    }
    
}
